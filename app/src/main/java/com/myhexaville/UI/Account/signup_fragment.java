package com.myhexaville.UI.Account;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import com.myhexaville.Logic.Client.$_ClientStatic;
import com.myhexaville.Logic.JSONData.$_JSONAttributes;
import com.myhexaville.Logic.ServerManagment.$_CheckOnline;
import com.myhexaville.Logic.ServerManagment.$_CheckReciveData;
import com.myhexaville.UI.RegularExpressions.$_Rex;
import com.myhexaville.login.R;
import com.myhexaville.login.login.OnSignUpListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static com.myhexaville.login.MainActivity.Decode_JSON;


public class signup_fragment extends Fragment implements OnSignUpListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static Socket socket = null;
    public static Context context;
    DataOutputStream dataOutputStream = null;
    DataInputStream dataInputStream = null;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;
    //my Attributes
    private EditText txt_email_signup, txt_name_signup, txt_password_signup, txt_confirm_password_signup;
    /*private RadioButton rdo_female, rdo_male;
    private Button btn_next;*/
    private CheckBox check_remember_me_signup;
    private OnFragmentInteractionListener onFragmentInteractionListener;


    public signup_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment signup_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static signup_fragment newInstance(String param1, String param2) {
        signup_fragment fragment = new signup_fragment();
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
        context = getContext();
        View view = inflater.inflate(R.layout.fragment_signup_fragment, container, false);
        onFragmentInteractionListener = (OnFragmentInteractionListener) getActivity();
        init_UI(view);
        Next();
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

    @Override
    public void signUp() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //  if (validateEmail() && validatePassword() && validateConfirmPassword()) {
                    $_ClientStatic client = new $_ClientStatic(getContext());
                    send_Sign_Up();
                    $_ClientStatic.setCheckOnline(new $_CheckOnline(txt_email_signup.getText().toString(), "Check", "online"));
                    //MainActivity.get_Recive_Data_And_Apply();
                    final $_CheckReciveData checkReciveData = new $_CheckReciveData();
                    checkReciveData.excute();
                    if (checkReciveData.getResult() != null) {
                        Decode_JSON(checkReciveData);
                    }
                    //  }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("error connect to internet");

                }

            }
        });
        thread.start();
    }

    private void action_UI() {
        txt_email_signup.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateEmail();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        txt_password_signup.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validatePassword();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        txt_confirm_password_signup.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateConfirmPassword();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    // Function

    private void Next() {
        /*btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //  if (validateEmail() && validatePassword() && validateConfirmPassword()) {
                            $_Client client = new $_Client(getContext());
                            send_Sign_Up();
                            $_Client.checkOnline = new $_CheckOnline(txt_email_signup.getText().toString(), "Check", "online");
                            MainActivity.get_Recive_Data_And_Apply();
                            //  }
                        } catch (IOException e) {
                            System.err.println("error connect to internet");

                        }

                    }
                });
                thread.start();
            }
        });*/
    }

    private void init_UI(View view) {
        txt_email_signup = view.findViewById(R.id.txt_email_signup);
        txt_name_signup = view.findViewById(R.id.txt_name_signup);
        txt_password_signup = view.findViewById(R.id.txt_password_signup);
        txt_confirm_password_signup = view.findViewById(R.id.txt_confirm_password_signup);
      /*  rdo_female = view.findViewById(R.id.rdo_female);
        rdo_male = view.findViewById(R.id.rdo_male);
        btn_next = view.findViewById(R.id.btn_next);*/
        check_remember_me_signup = view.findViewById(R.id.check_remember_me_signup);
    }

    private void send_Sign_Up() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put($_JSONAttributes.Type.toString(), "Sign_Up");
            jsonObject.put($_JSONAttributes.Id.toString(), txt_email_signup.getText().toString());
            jsonObject.put($_JSONAttributes.Password.toString(), txt_password_signup.getText().toString());
            jsonObject.put($_JSONAttributes.User_Name.toString(), txt_name_signup.getText().toString());
            $_ClientStatic.getDataOutputStreamMessage().writeUTF(jsonObject.toString());
            if (check_remember_me_signup.isChecked()) {
                $_ClientStatic.getSharedPreferences().storeObject("id", txt_email_signup.getText().toString());
                $_ClientStatic.getSharedPreferences().storeObject("username", txt_name_signup);
                $_ClientStatic.getSharedPreferences().storeObject("password", txt_password_signup.getText().toString());
            }


        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("error send data sign up");

        }

    }

    private boolean validateEmail() {

        String email_input = txt_email_signup.getText().toString().trim();
        if (email_input.isEmpty()) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    txt_email_signup.setError("Field Can'nt be empty");
                }
            });
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email_input).matches()) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    txt_email_signup.setError("Please enter a valid email address");
                }
            });
            return false;
        } else {
            return true;
        }
    }

    private boolean validatePassword() {
        String password_input = txt_password_signup.getText().toString().trim();
        if (password_input.isEmpty()) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    txt_password_signup.setError("Field Can'nt be empty");
                }
            });
            return false;
        } else if (!$_Rex.PASSWORD_PATTERN.matcher(password_input).matches()) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    txt_password_signup.setError("Please enter a valid password");
                }
            });
            return false;
        } else {
            return true;
        }
    }

    private boolean validateConfirmPassword() {
        String password_confirm__input = txt_confirm_password_signup.getText().toString().trim();
        if (password_confirm__input.isEmpty()) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    txt_confirm_password_signup.setError("Field Can'nt be empty");
                }
            });
            return false;
        } else if (!$_Rex.PASSWORD_PATTERN.matcher(password_confirm__input).matches() || !password_confirm__input.equals(txt_password_signup.getText())) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    txt_confirm_password_signup.setError("Please enter a valid password");
                }
            });
            return false;
        } else {
            return true;
        }
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String json, String id);
    }


}
