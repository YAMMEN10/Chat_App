package com.myhexaville.UI.Chat.MainFragment.RoomChat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.myhexaville.Logic.Client.$_Client;
import com.myhexaville.Logic.JSONData.$_JSONAttributes;
import com.myhexaville.UI.$_Static_Class;
import com.myhexaville.UI.Adapter.AdapterRoomChat.$_Recycle_View_Room_Chat_Adapter;
import com.myhexaville.UI.Adapter.AdapterRoomChat.Message.$_Message;
import com.myhexaville.UI.Adapter.AdapterRoomChat.Message.MessageImage.$_Message_Image;
import com.myhexaville.UI.Adapter.AdapterRoomChat.Message.MessageText.$_Message_Text;
import com.myhexaville.login.FourActivity;
import com.myhexaville.login.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hani.momanii.supernova_emoji_library.Actions.EmojIconActions;
import hani.momanii.supernova_emoji_library.Helper.EmojiconEditText;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link room_chat.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link room_chat#newInstance} factory method to
 * create an instance of this fragment.
 */
public class room_chat extends Fragment {
    public static final int PICK_IMAGE_REQUEST = 100;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = FourActivity.class.getSimpleName();
    EmojIconActions emojIcon;
    RecyclerView.LayoutManager layoutManager;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;
    //Attribute
    private RecyclerView recycle_view_room_chat;
    private ImageButton item_recycle_view_room_chat_studio;
    private ImageButton txt_message_send;
    private ImageView btn_emoji;
    private View rootView;
    private EmojiconEditText txt_message_input;
    private $_Recycle_View_Room_Chat_Adapter recycle_view_room_chat_adapter;
    private List<$_Message> list;


    public room_chat() {
        // Required empty public constructor
        list = new ArrayList<>();
        recycle_view_room_chat_adapter = new $_Recycle_View_Room_Chat_Adapter(list, getContext());
    }


    @SuppressLint("ValidFragment")
    protected room_chat(Parcel in) {
        mParam1 = in.readString();
        mParam2 = in.readString();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment room_chat.
     */
    // TODO: Rename and change types and number of parameters
    public static room_chat newInstance(String param1, String param2) {
        room_chat fragment = new room_chat();
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
        View view = inflater.inflate(R.layout.fragment_room_chat, container, false);
        setHasOptionsMenu(true);
        initUI(view);
        action_UI();
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String json, String id) {
        if (mListener != null) {
            mListener.onFragmentInteraction(json, id);
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

    public void initUI(View view) {
        recycle_view_room_chat = view.findViewById(R.id.recycle_view_room_chat);
        layoutManager = new LinearLayoutManager(getContext());
        recycle_view_room_chat.setAdapter(recycle_view_room_chat_adapter);
        recycle_view_room_chat.setLayoutManager(layoutManager);
        recycle_view_room_chat.setHasFixedSize(true);

        item_recycle_view_room_chat_studio = view.findViewById(R.id.item_recycle_view_room_chat_studio);
        txt_message_send = view.findViewById(R.id.txt_message_send);
        item_recycle_view_room_chat_studio = view.findViewById(R.id.item_recycle_view_room_chat_studio);

        //emoji
        rootView = view.findViewById(R.id.root_view);
        txt_message_input = view.findViewById(R.id.txt_message_input);
        btn_emoji = view.findViewById(R.id.btn_emoji);

        emojIcon = new EmojIconActions(getContext(), rootView, txt_message_input, btn_emoji);
        emojIcon.ShowEmojIcon();
        emojIcon.setIconsIds(R.drawable.ic_action_keyboard, R.drawable.smiley);
        emojIcon.setKeyboardListener(new EmojIconActions.KeyboardListener() {
            @Override
            public void onKeyboardOpen() {
                Log.e(TAG, "Keyboard opened!");
            }

            @Override
            public void onKeyboardClose() {
                Log.e(TAG, "Keyboard closed");
            }
        });


    }


    public void action_UI() {
        txt_message_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final $_Message message_text = new $_Message_Text($_Client.getEmail(), "Yamen", "1", $_Static_Class.getCurrentTime(), txt_message_input.getText().toString());
                final JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put($_JSONAttributes.Id.toString(), $_Client.getEmail());
                    jsonObject.put($_JSONAttributes.IdRecive.toString(), $_Client.idRecived);
                    jsonObject.put($_JSONAttributes.Type.toString(), "Message_Text");
                    jsonObject.put("Time", $_Static_Class.getCurrentTime());
                    jsonObject.put($_JSONAttributes.User_Name.toString(), $_Client.getUserName());
                    jsonObject.put("Message", (($_Message_Text) message_text).getMessage_text());
                    jsonObject.put("MType", "1");

                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                $_Client.getDataOutputStreamMessage().writeUTF(jsonObject.toString());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                    thread.start();
                    thread.join();

                    addMessage(message_text);

                } catch (JSONException e) {

                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        recycle_view_room_chat.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recycle_view_room_chat, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));


        item_recycle_view_room_chat_studio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FromCard();
            }
        });


    }

    //Function
    public void FromCard() {
        //Create an Intent with action as ACTION_PICK
        Intent intent = new Intent(Intent.ACTION_PICK);
        // Sets the type as image/*. This ensures only components of type image are selected
        intent.setType("image/*");
        //We pass an extra array with the accepted mime types. This will ensure only components with these MIME types as targeted.
        String[] mimeTypes = {"image/jpeg", "image/png"};
        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
        // Launching the Intent
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ActivityCompat.requestPermissions(FourActivity.fragmentActivity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, requestCode);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContext().getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            try {
                final FileInputStream file;
                file = new FileInputStream(picturePath);
                final byte[] bytes = new byte[file.available()];
                file.read(bytes);
                System.out.println("BYYYTTTEEESSS = " + bytes);

                final JSONObject jsonObject = new JSONObject();
                jsonObject.put($_JSONAttributes.Id.toString(), $_Client.getEmail());
                jsonObject.put($_JSONAttributes.IdRecive.toString(), $_Client.idRecived);
                jsonObject.put($_JSONAttributes.Type.toString(), "Message_Image");
                jsonObject.put("Time", $_Static_Class.getCurrentTime());
                jsonObject.put($_JSONAttributes.User_Name.toString(), $_Client.getUserName());
                // String s = Base64.encodeToString(bytes, Base64.DEFAULT);
                jsonObject.put("Message", bytes.length);
                System.out.println(bytes);
                jsonObject.put("MType", "2");

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            $_Client.getDataOutputStreamMessage().writeUTF(jsonObject.toString());
                            $_Client.getDataOutputStreamMessage().write(bytes);
                            $_Client.getDataOutputStreamMessage().flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });
                thread.start();
                thread.join();
                System.out.println("BYYYTTTEEESSS = " + bytes);
                $_Message_Image message_image = new $_Message_Image($_Client.getEmail(), $_Client.getUserName(), "2", null, bytes);
                message_image.setTime(message_image.getTime());
                addMessage(message_image);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public synchronized void addMessage($_Message message) {
        list.add(message);

        FourActivity.fragmentActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                recycle_view_room_chat_adapter.notifyItemChanged(list.size() - 1);
                if (recycle_view_room_chat == null) {
                    System.out.println("NNNNULLLLLLLLLLLLL->");
                } else
                    recycle_view_room_chat.scrollToPosition(recycle_view_room_chat_adapter.getItemCount() - 1);
            }
        });


    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
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
        void onFragmentInteraction(String json, String id);
    }


}
