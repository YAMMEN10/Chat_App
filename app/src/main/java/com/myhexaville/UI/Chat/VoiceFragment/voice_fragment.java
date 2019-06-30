package com.myhexaville.UI.Chat.VoiceFragment;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.app.progresviews.ProgressWheel;
import com.myhexaville.Logic.Client.$_ClientStatic;
import com.myhexaville.Logic.JSONData.$_JSONAttributes;
import com.myhexaville.UI.$_Static_Class;
import com.myhexaville.UI.Adapter.AdapterRoomChat.Message.$_Message;
import com.myhexaville.UI.Adapter.AdapterRoomChat.Message.MessageVoice.$_Message_Voice;
import com.myhexaville.login.FourActivity;
import com.myhexaville.login.MainActivity;
import com.myhexaville.login.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link voice_fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link voice_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class voice_fragment extends Fragment {
    public static final int REQUEST_AUDIO_PERMISSION_CODE = 1;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String LOG_TAG = "AudioRecording";
    public static boolean isPlay = false;
    public static byte[] bytes;
    private static String mFileName = null;
    Button btn_stop_record;
    MediaRecorder mRecorder = null;
    ProgressWheel recording;
    private int time = 0;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    public voice_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment voice_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static voice_fragment newInstance(String param1, String param2) {
        voice_fragment fragment = new voice_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_voice_fragment, container, false);
        btn_stop_record = view.findViewById(R.id.btn_stop_record);
        recording = view.findViewById(R.id.recording);
        startTimming();
        //Bundle bundle = getArguments();
        //System.out.println("TTTTTTTTTTT = " + bundle +  "    " + bundle.getString("name"));
        mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();

        mFileName += "/" + $_ClientStatic.idRecived + ".3gp";

        isPlay = true;
        if (CheckPermissions()) {
            mRecorder = new MediaRecorder();
            mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mRecorder.setOutputFile(mFileName);
            try {
                mRecorder.prepare();
            } catch (IOException e) {
                Log.e(LOG_TAG, "prepare() failed");
            }
            mRecorder.start();
            Toast.makeText(getContext(), "Recording Started", Toast.LENGTH_LONG).show();
        } else {
            RequestPermissions();
        }


        btn_stop_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopRecording();
            }
        });


        return view;
    }


    private void stopRecording() {
        isPlay = false;
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
        FourActivity.fragmentActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(), "Recording Stopped", Toast.LENGTH_LONG).show();
            }
        });

        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(mFileName));
            bytes = new byte[dataInputStream.available()];
            dataInputStream.read(bytes);
            dataInputStream.close();
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put($_JSONAttributes.Id.toString(), $_ClientStatic.getEmail());
                jsonObject.put($_JSONAttributes.IdRecive.toString(), $_ClientStatic.idRecived);
                jsonObject.put($_JSONAttributes.Type.toString(), "Message_Voice");
                jsonObject.put("Time", $_Static_Class.getCurrentTime());
                jsonObject.put($_JSONAttributes.User_Name.toString(), $_ClientStatic.getUserName());
                jsonObject.put("MType", "R");
                jsonObject.put("Message", bytes.length);
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {

                            $_ClientStatic.getDataOutputStreamMessage().writeUTF(jsonObject.toString());
                            $_ClientStatic.getDataOutputStreamMessage().write(bytes);
                            $_ClientStatic.getDataOutputStreamMessage().flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });
                thread.start();
                thread.join();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            $_Message_Voice message_voice = new $_Message_Voice($_ClientStatic.getEmail(), $_ClientStatic.getUserName(), "5", $_Static_Class.getCurrentTime(), 0, bytes);
            addMessage(message_voice);
            storeMessage(MainActivity.allMessages.get($_ClientStatic.idRecived).second);
// maybe this statement not work i dont test it
            FourActivity.fragmentActivity.getSupportFragmentManager().beginTransaction().remove(FourActivity.voice_fragment).commit();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void startTimming() {
        Thread time_recording = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        FourActivity.fragmentActivity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                recording.setStepCountText(String.valueOf(time));
                            }
                        });
                        Thread.sleep(1000);
                        if (time == 20 || !isPlay) {
                            time = 0;
                            stopRecording();
                            break;
                        }
                        time++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        time_recording.start();


    }


    public synchronized void storeMessage(List<$_Message> messages) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                MainActivity.store_message.storeMessage($_ClientStatic.idRecived, messages);
            }
        });
        thread.start();
    }

    public synchronized void addMessage($_Message message) {
        //list.add(message);
        MainActivity.allMessages.get($_ClientStatic.idRecived).second.add(message);
        FourActivity.fragmentActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                MainActivity.allMessages.get($_ClientStatic.idRecived).first.notifyDataSetChanged();
                if (FourActivity.recycle_view_room_chat == null) {
                    System.out.println("NNNNULLLLLLLLLLLLL->");
                } else
                    FourActivity.recycle_view_room_chat.scrollToPosition(MainActivity.allMessages.get($_ClientStatic.idRecived).first.getItemCount() - 1);
            }
        });


    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public boolean CheckPermissions() {
        int result = ContextCompat.checkSelfPermission(getContext(), WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(getContext(), RECORD_AUDIO);
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
    }

    private void RequestPermissions() {
        ActivityCompat.requestPermissions(getActivity(), new String[]{RECORD_AUDIO, WRITE_EXTERNAL_STORAGE}, REQUEST_AUDIO_PERMISSION_CODE);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
