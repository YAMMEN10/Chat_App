package com.myhexaville.UI.Account;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.bumptech.glide.Glide;
import com.myhexaville.Logic.Client.$_Client;
import com.myhexaville.Logic.JSONData.$_JSONAttributes;
import com.myhexaville.Logic.JSONData.$_JSON_Change_Image;
import com.myhexaville.Logic.ServerManagment.$_CheckReciveData;
import com.myhexaville.login.R;
import com.myhexaville.login.SecondActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static android.app.Activity.RESULT_OK;
import static com.myhexaville.login.MainActivity.Decode_JSON;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link signup_fragment_tow.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link signup_fragment_tow#newInstance} factory method to
 * create an instance of this fragment.
 */
public class signup_fragment_tow extends Fragment {
    public static final int PICK_IMAGE_REQUEST = 100;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener onFragmentInteractionListener;
    //My Attribute
    private AppCompatImageView imageView;
    private EditText txt_state_signup;
    private Button btn_signup;
    private FloatingActionButton floatingActionButton;
    private String my_image = "";


    public signup_fragment_tow() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment signup_fragment_tow.
     */
    // TODO: Rename and change types and number of parameters
    public static signup_fragment_tow newInstance(String param1, String param2) {
        signup_fragment_tow fragment = new signup_fragment_tow();
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
        View view = inflater.inflate(R.layout.fragment_signup_fragment_tow, container, false);
        init_UI(view);
        action_UI();
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String json, String id) {
        if (onFragmentInteractionListener != null) {
            onFragmentInteractionListener.onFragmentInteraction(json, id);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            onFragmentInteractionListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onFragmentInteractionListener = null;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, requestCode);

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
                FileInputStream fileInputStream = new FileInputStream(picturePath);
                byte[] bytes = new byte[fileInputStream.available()];
                fileInputStream.read(bytes);
                $_JSON_Change_Image change_image = new $_JSON_Change_Image("Change_Image", $_Client.getEmail(), $_Client.getUserName(), bytes.length);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put($_JSONAttributes.Id.toString(), change_image.getIdFrom());
                jsonObject.put($_JSONAttributes.Type.toString(), change_image.getType());
                jsonObject.put($_JSONAttributes.User_Name.toString(), change_image.getUser_name());
                jsonObject.put($_JSONAttributes.Message.toString(), bytes.length);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            $_Client.getDataOutputStreamMessage().writeUTF(jsonObject.toString());
                            $_Client.getDataOutputStreamMessage().write(bytes);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                $_Client.getDataOutputStreamMessage().flush();

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final $_CheckReciveData checkReciveData = new $_CheckReciveData();
                        checkReciveData.excute();
                        if (checkReciveData.getResult() != null) {
                            Decode_JSON(checkReciveData);
                        }
                    }
                });
                thread.start();


                System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTT = " + $_Client.getEmail());

                Glide.with(SecondActivity.fragmentActivity)
                        .load(bytes)
                        .asBitmap()
                        .into(
                                imageView
                        );
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
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

    private void init_UI(View view) {
        imageView = view.findViewById(R.id.imgview_photo);
        txt_state_signup = view.findViewById(R.id.txt_state_signup);
        btn_signup = view.findViewById(R.id.btn_signup);
        floatingActionButton = view.findViewById(R.id.floatingbtn_add_image);
    }

    private void action_UI() {
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        send_Sign_In();
                    }
                });
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FromCard();
            }
        });
    }

    private void send_Sign_In() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put($_JSONAttributes.Type.toString(), "Sign_Up_Tow");
            jsonObject.put($_JSONAttributes.Id.toString(), $_Client.getEmail());

            jsonObject.put("State", txt_state_signup.getText());
            jsonObject.put("Image", my_image);
            $_Client.getDataOutputStreamMessage().writeUTF(jsonObject.toString());


            final $_CheckReciveData checkReciveData = new $_CheckReciveData();
            checkReciveData.excute();
            if (checkReciveData.getResult() != null) {
                Decode_JSON(checkReciveData);
            }
            System.out.println("AAAAAAAAAAAAAAAAAAAAA");
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("error send data sign up");

        }

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
