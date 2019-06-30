package com.myhexaville.UI.Account;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import com.myhexaville.Logic.Client.$_ClientStatic;
import com.myhexaville.Logic.JSONData.$_JSON_login;
import com.myhexaville.Logic.ServerManagment.$_CheckOnline;
import com.myhexaville.Logic.ServerManagment.$_CheckReciveData;
import com.myhexaville.Logic.ServerManagment.$_SendData;
import com.myhexaville.login.R;
import com.myhexaville.login.login.OnLoginListener;

import java.io.IOException;

import static com.myhexaville.login.MainActivity.Decode_JSON;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link signin_fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link signin_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class signin_fragment extends Fragment implements OnLoginListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener onFragmentInteractionListener;

    //Attribute
    //private Button btn_signin;
    private EditText txt_email_signin, txt_password_signin;
    private CheckBox check_remember_me_signin;


    public signin_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment signin_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static signin_fragment newInstance(String param1, String param2) {
        signin_fragment fragment = new signin_fragment();
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
        //$_Client.checkOnline.future.cancel(true);

        View view = inflater.inflate(R.layout.fragment_signin_fragment, container, false);
        init_UI(view);

        signin();
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


    private void init_UI(View view) {
        //btn_signin = view.findViewById(R.id.btn_signin);
        check_remember_me_signin = view.findViewById(R.id.check_remember_me_signin);
        txt_email_signin = view.findViewById(R.id.txt_email_signin);
        txt_password_signin = view.findViewById(R.id.txt_password_signin);
    }


    private void action_UI() {


    }

    private void signin() {
        /*btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //  if (validateEmail() && validatePassword() && validateConfirmPassword()) {
                            $_Client client = new $_Client(getContext());
                            send_Sign_In();

                        } catch (IOException e) {
                            System.err.println("error connect to internet");

                        }
                    }
                });
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                $_Client.checkOnline = new $_CheckOnline(txt_email_signin.getText().toString(), "Check", "online");
                MainActivity.get_Recive_Data_And_Apply();
                //  }


            }
        });*/
    }

    private void send_Sign_In() {
        try {

            $_JSON_login json_login = new $_JSON_login(
                    "Login_User",
                    txt_email_signin.getText().toString(),
                    txt_password_signin.getText().toString(),
                    "UserName : Login"
            );
            $_SendData sendData = new $_SendData(json_login, "Login_User");
            sendData.excute();
            $_ClientStatic.getDataOutputStreamMessage().writeUTF(sendData.getJson_object().toString());


            if (check_remember_me_signin.isChecked()) {
                $_ClientStatic.getSharedPreferences().storeObject("id", txt_email_signin.getText().toString());
                $_ClientStatic.getSharedPreferences().storeObject("username", $_ClientStatic.getSharedPreferences().getObject("username"));
                $_ClientStatic.getSharedPreferences().storeObject("password", txt_password_signin.getText().toString());
            }
           /* $_Client.getSharedPreferences().storeObject("id_project", txt_email_signin.getText().toString());
            $_Client.getSharedPreferences().storeObject("username_project",$_Client.getSharedPreferences().getObject("username"));
*/


            final $_CheckReciveData checkReciveData = new $_CheckReciveData();
            checkReciveData.excute();
            if (checkReciveData.getResult() != null) {
                Decode_JSON(checkReciveData);
            }


        } catch (IOException e) {
            System.err.println("error send data sign up");

        }

    }


    @Override
    public void login() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //  if (validateEmail() && validatePassword() && validateConfirmPassword()) {
                    $_ClientStatic client = new $_ClientStatic(getContext());
                    send_Sign_In();

                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("error connect to internet");

                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        $_ClientStatic.setCheckOnline(new $_CheckOnline(txt_email_signin.getText().toString(), "Check", "online"));
        //MainActivity.get_Recive_Data_And_Apply();


    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String json, String id);
    }
}
