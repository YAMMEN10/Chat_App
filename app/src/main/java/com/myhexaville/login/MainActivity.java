package com.myhexaville.login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;

import com.myhexaville.Logic.Client.$_Client;
import com.myhexaville.Logic.Friend.$_FriendInfo;
import com.myhexaville.Logic.Friend.$_FriendStorgeMangement;
import com.myhexaville.Logic.JSONData.$_JSON;
import com.myhexaville.Logic.JSONData.$_JSONAttributes;
import com.myhexaville.Logic.JSONData.$_JSON_Accept_Friend_Respons;
import com.myhexaville.Logic.JSONData.$_JSON_Add_Friend_Response;
import com.myhexaville.Logic.JSONData.$_JSON_Change_Image_Successful;
import com.myhexaville.Logic.JSONData.$_JSON_Friend_Accept_Response;
import com.myhexaville.Logic.JSONData.$_JSON_Friend_Refusal_Request;
import com.myhexaville.Logic.JSONData.$_JSON_Friend_Remove;
import com.myhexaville.Logic.JSONData.$_JSON_Friend_Request;
import com.myhexaville.Logic.JSONData.$_JSON_Login_Successful;
import com.myhexaville.Logic.JSONData.$_JSON_Message_Image;
import com.myhexaville.Logic.JSONData.$_JSON_Message_Text;
import com.myhexaville.Logic.JSONData.$_JSON_Message_Voice;
import com.myhexaville.Logic.JSONData.$_JSON_Online_Friend_Respons;
import com.myhexaville.Logic.JSONData.$_JSON_Refusal_Friend_Response;
import com.myhexaville.Logic.JSONData.$_JSON_Remove_Friend_Response;
import com.myhexaville.Logic.JSONData.$_JSON_Remove_Request_Response;
import com.myhexaville.Logic.JSONData.$_JSON_Search_User_Successful;
import com.myhexaville.Logic.JSONData.$_JSON_SignUp_Successful;
import com.myhexaville.Logic.JSONData.$_JSON_SignUp_Tow_Successful;
import com.myhexaville.Logic.MessagesChats.$_ChatMessageMangment;
import com.myhexaville.Logic.ServerManagment.$_CheckOnline;
import com.myhexaville.Logic.ServerManagment.$_CheckReciveData;
import com.myhexaville.Logic.Tools.$_SharedPreferences;
import com.myhexaville.UI.$_Static_Class;
import com.myhexaville.UI.Account.signin_fragment;
import com.myhexaville.UI.Account.signup_fragment;
import com.myhexaville.UI.Account.signup_fragment_tow;
import com.myhexaville.UI.Adapter.AdapterFriend.$_Value_Item_Friend;
import com.myhexaville.UI.Adapter.AdapterMainChat.$_Value_Item_Main_Chat;
import com.myhexaville.UI.Adapter.AdapterRoomChat.$_Recycle_View_Room_Chat_Adapter;
import com.myhexaville.UI.Adapter.AdapterRoomChat.Message.$_Message;
import com.myhexaville.UI.Adapter.AdapterRoomChat.Message.MessageImage.$_Message_Image;
import com.myhexaville.UI.Adapter.AdapterRoomChat.Message.MessageText.$_Message_Text;
import com.myhexaville.UI.Adapter.AdapterRoomChat.Message.MessageVoice.$_Message_Voice;
import com.myhexaville.UI.Chat.MainFragment.MainChat.main_chat_fragment;
import com.myhexaville.UI.Chat.MainFragment.RoomChat.room_chat;
import com.myhexaville.UI.Chat.MainFragment.main_fragment;
import com.myhexaville.UI.Chat.SearchFragment.search_fragment;
import com.myhexaville.UI.Friend.friend_fragment;
import com.myhexaville.UI.Notification.notification_fragment;
import com.myhexaville.UI.ToolStorage.$_Store_Friend;
import com.myhexaville.UI.ToolStorage.$_Store_Message;
import com.myhexaville.UI.ToolStorage.FriendPathMangment;
import com.myhexaville.login.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;
import static com.myhexaville.login.FlexibleFrameLayout.ORDER_LOGIN_STATE;
import static com.myhexaville.login.FlexibleFrameLayout.ORDER_SIGN_UP_STATE;


public class MainActivity extends AppCompatActivity implements signup_fragment.OnFragmentInteractionListener,
        signin_fragment.OnFragmentInteractionListener,
        signup_fragment_tow.OnFragmentInteractionListener,
        main_fragment.OnFragmentInteractionListener,
        main_chat_fragment.OnFragmentInteractionListener,
        room_chat.OnFragmentInteractionListener,
        search_fragment.OnFragmentInteractionListener,
        notification_fragment.OnFragmentInteractionListener,
        friend_fragment.OnFragmentInteractionListener{


    public static final int REQUEST_AUDIO_PERMISSION_CODE = 1;
    private static final String TAG = "MainActivity";
    public static FragmentManager fragmentManager;
    public static FragmentActivity fragmentActivity;
    public static Context context;
    public static Fragment fragment;
    //public static List<$_Message> messages;
    public static $_Store_Friend store_friend;
    //public static $_FriendStorgeMangement mangementFriend = new $_FriendStorgeMangement();
    public static $_Store_Message store_message;
    public static notification_fragment fragment_notifiction;
    public static Map<String, Pair<$_Recycle_View_Room_Chat_Adapter, List<$_Message>>> allMessages;
    public static byte[] bytes = null;
    private static FragmentTransaction fragmentTransaction;
    private ActivityMainBinding binding;
    private boolean isLogin = true;
    //All Fragment
    private SecondActivity secondActivity;
    private ThirdActivity thirdActivity;
    private FourActivity fourActivity;

    public static void Decode_JSON($_CheckReciveData checkReciveData) {
        JSONObject jsonObject = null;
        $_JSON my_json = null;
        try {
            if (checkReciveData.getResult() instanceof String)
                jsonObject = new JSONObject((String) checkReciveData.getResult());
            else {
                byte[] bytes = new byte[100];
                $_Client.getDataInputStreamMessage().read(bytes);
                System.out.println("BITMAP = " + bytes);

            }
            System.out.println(jsonObject.toString());

            switch (jsonObject.getString("Type")) {
                case "Login_User_Successful": {
                    my_json = new $_JSON_Login_Successful("Login_User_Successful", jsonObject.getString($_JSONAttributes.IdRecive.toString()), jsonObject.getBoolean($_JSONAttributes.Done.toString()));
                    final $_JSON finalMy_json = my_json;
                    fragmentActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                          /*  $_Client.setEmail($_Client.getSharedPreferences().getObject("id_project"));
                            $_Client.setUserName($_Client.getSharedPreferences().getObject("username_project"));*/
                            System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY = " + $_Client.getEmail());
                            if ((($_JSON_Login_Successful) finalMy_json).isDone()) {
                                Toast.makeText(context, "Login_User_Successful", Toast.LENGTH_SHORT).show();
                                $_Client.setEmail($_Client.getSharedPreferences().getObject("id_project"));
                                $_Client.setUserName($_Client.getSharedPreferences().getObject("username_project"));
                              /*  fragmentTransaction = fragmentManager.beginTransaction();
                                main_fragment main_fragment = new main_fragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("data", finalMy_json.toString());
                                main_fragment.setArguments(bundle);
                                main_fragment.setArguments(bundle);
                                fragmentTransaction.replace(R.id.continer_main, main_fragment).commit();*/


                                //  mangementChatMessage.setMessageChatPath(FriendPathMangment.FriendPath);

                               /* $_Client.setEmail($_Client.getSharedPreferences().getObject("id"));
                                $_Client.setUserName($_Client.getSharedPreferences().getObject("username"));*/
                                System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY = " + $_Client.getEmail());

                                Bundle bundle = new Bundle();
                                bundle.putString("fragment", "main_fragment");
                                SecondActivity.res = "main_fragment";

                                Intent intent = new Intent(MainActivity.context, SecondActivity.class);
                                intent.putExtras(bundle);
                                MainActivity.fragmentActivity.startActivity(intent);
                               // getOnline();
                            } else {
                                Toast.makeText(context, "Sign Up UN Successfully", Toast.LENGTH_SHORT).show();
                                $_Client.getSharedPreferences().removeObject("username");
                                $_Client.getSharedPreferences().removeObject("password");
                                $_Client.getSharedPreferences().removeObject("id");
                                /*if ($_Client.getSharedPreferences().isExist("data_signup").equals(""))
                                    $_Client.getSharedPreferences().removeObject("username");*/
                                $_Client.setEmail("Email");
                                $_Client.setUserName("Username");
                            }
                        }
                    });
                    break;
                }
                case "Sign_Up_Successful": {
                    my_json = new $_JSON_SignUp_Successful("Sign_Up_Successful", jsonObject.getString($_JSONAttributes.IdRecive.toString()), jsonObject.getBoolean($_JSONAttributes.Done.toString()), jsonObject.getString($_JSONAttributes.User_Name.toString()), jsonObject.getString($_JSONAttributes.Password.toString()));
                    final $_JSON finalMy_json = my_json;
                    final JSONObject finalJsonObject = new JSONObject();
                    fragmentActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                          /*  $_Client.setEmail($_Client.getSharedPreferences().getObject("id_project"));
                            $_Client.setUserName($_Client.getSharedPreferences().getObject("username_project"));*/
                            if ((($_JSON_SignUp_Successful) finalMy_json).isDone()) {
                                Toast.makeText(context, "Sign Up Successfully", Toast.LENGTH_SHORT).show();
                                $_Client.setEmail($_Client.getSharedPreferences().getObject("id_project"));
                                $_Client.setUserName($_Client.getSharedPreferences().getObject("username_project"));
                               /* Bundle bundle = new Bundle();
                                fragmentTransaction = fragmentManager.beginTransaction();
                                signup_fragment_tow signup_fragment_tow = new signup_fragment_tow();
                                final JSONObject jsonObject1 = new JSONObject();
                                try {
                                    finalJsonObject.put($_JSONAttributes.Id.toString(), (($_JSON_SignUp_Successful) finalMy_json).getIdReceived());
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                bundle.putString("data", finalJsonObject.toString());
                                signup_fragment_tow.setArguments(bundle);
                                fragmentTransaction.replace(R.id.container_main, signup_fragment_tow).commit();*/


                                //mangementChatMessage.setMessageChatPath(FriendPathMangment.FriendPath);


                                /*$_Client.getSharedPreferences().storeObject("id", (($_JSON_SignUp_Successful) finalMy_json).getIdReceived());
                                $_Client.getSharedPreferences().storeObject("username", (($_JSON_SignUp_Successful) finalMy_json).getUser_name());
                                $_Client.getSharedPreferences().storeObject("password", (($_JSON_SignUp_Successful) finalMy_json).getPassword());
*/

                                Intent intent = new Intent(MainActivity.context, SecondActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("fragment", "signup_fragment_tow");
                                SecondActivity.res = "signup_fragment_tow";

                                intent.putExtras(bundle);
                                MainActivity.fragmentActivity.startActivity(intent);
                               // getOnline();
                            } else {
                                Toast.makeText(context, "Sign Up UN Successfully", Toast.LENGTH_SHORT).show();
                                $_Client.getSharedPreferences().removeObject("id");
                                $_Client.getSharedPreferences().removeObject("username");
                                $_Client.getSharedPreferences().removeObject("password");
                                $_Client.getSharedPreferences().removeObject("id_project");
                                $_Client.getSharedPreferences().removeObject("username_project");
                            }
                        }
                    });
                    break;
                }
                case "Sign_Up_Tow_Successful": {
                    my_json = new $_JSON_SignUp_Tow_Successful("Sign_Up_Tow_Successful", jsonObject.getString($_JSONAttributes.IdRecive.toString()), jsonObject.getBoolean($_JSONAttributes.Done.toString()), jsonObject.getString("Password"), jsonObject.getString("Image"));
                    final $_JSON finalMy_json = my_json;
                    final JSONObject finalJsonObject1 = jsonObject;
                    fragmentActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if ((($_JSON_SignUp_Tow_Successful) finalMy_json).isDone()) {
                                Toast.makeText(context, "Sign Up AAAAAL Successfully", Toast.LENGTH_SHORT).show();
                             /*   JSONObject jsonObject1 = new JSONObject();
                                try {
                                    jsonObject1.put("Id", (($_JSON_SignUp_Tow_Successful) finalMy_json).getIdReceived());
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                Bundle bundle = new Bundle();
                                fragmentTransaction = SecondActivity.fragmentManager.beginTransaction();
                                JSONObject jsonObject2 = new JSONObject();
                                try {
                                    finalJsonObject1.put($_JSONAttributes.Id.toString(), $_Client.getEmail());
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                bundle.putString("data", finalJsonObject1.toString());
                                main_fragment.setArguments(bundle);*/
                                System.out.println("WWWWWWWWWWWWWWWWWWWWWWWW");
                                $_Client.setEmail($_Client.getSharedPreferences().getObject("id"));
                                $_Client.setUserName($_Client.getSharedPreferences().getObject("username"));
                                main_fragment main_fragment = new main_fragment();
                                SecondActivity.fragmentManager.beginTransaction().replace(R.id.container_main_second, main_fragment).commit();
                            } else {
                                Toast.makeText(context, "Sign Up AAAAAL UN Successfully", Toast.LENGTH_SHORT).show();
                                $_Client.getSharedPreferences().removeObject("id");
                                $_Client.getSharedPreferences().removeObject("username");
                                $_Client.getSharedPreferences().removeObject("password");
                            }
                        }
                    });
                    break;
                }
                case "Message_Text": {
                    my_json = new $_JSON_Message_Text("Message_Text", jsonObject.getString($_JSONAttributes.Id.toString()), jsonObject.getString($_JSONAttributes.IdRecive.toString()), jsonObject.getString("Message"), jsonObject.getString("Time"), jsonObject.getString($_JSONAttributes.User_Name.toString()));
                    if (jsonObject.getString($_JSONAttributes.Id.toString()).equals(jsonObject.getString($_JSONAttributes.IdRecive.toString()))) {

                    } else {
                        $_Message message = new $_Message_Text((($_JSON_Message_Text) my_json).getIdFrom(), (($_JSON_Message_Text) my_json).getUsername(), "3", (($_JSON_Message_Text) my_json).getTime(), jsonObject.getString("Message"));
                        //     if (main_chat_fragment.rooms == null) {
                        // messages.add(message);
                        //   } else {
                        //  if (main_chat_fragment.rooms.size() == 0) {
                        //      messages.add(message);
                        //   } else {
                        //      int size = messages.size();
                        ///      if (size > 0) {
                        //            for (int i = 0; i < size; i++) {
                        //              System.out.println("EEEEEEEE = "  + messages.get(i));
                        //              main_chat_fragment.rooms.get(0).second.addMessage(messages.get(i));
                        //               messages.remove(i);
                        //           }
                        //       }
                  /*      while (main_chat_fragment.rooms == null){

                        }

                        while (main_chat_fragment.rooms.size() == 0){

                        }*/
                     /*   if (main_chat_fragment.rooms == null) {
                            messages.add(message);
                        } else {
                            if (main_chat_fragment.rooms.size() == 0) {
                                messages.add(message);

                            } else {
                                int size = messages.size();
                                System.out.println("SIZE = " + size);
                                for (int i = 0; i < size; i++) {
                                    main_chat_fragment.rooms.get(0).second.addMessage(messages.get(0));
                                    messages.remove(0);
                                }
                                main_chat_fragment.rooms.get(0).second.addMessage(message);

                            }
                        }*/
                        //messages.add(message);
                        allMessages.get(message.getId()).second.add(message);
                        FourActivity.fragmentActivity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                allMessages.get(message.getId()).first.notifyDataSetChanged();

                            }
                        });
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                MainActivity.store_message.storeMessage(message.getId(), MainActivity.allMessages.get(message.getId()).second);
                            }
                        });
                        thread.start();

                        //  mangementChatMessage.setFileOutputFriend(context.openFileOutput(FriendPathMangment.FriendPath + File.separator + message.getId() + File.separator + message.getId() + ".Fi", MODE_PRIVATE));
                        // mangementChatMessage.add(message);


                        //          }//
                        //     }
                    }
                    break;
                }

                case "Message_Image": {
                    my_json = new $_JSON_Message_Image("Message_Image", jsonObject.getString($_JSONAttributes.Id.toString()), jsonObject.getString($_JSONAttributes.IdRecive.toString()), jsonObject.getString("Message"), $_Static_Class.getCurrentTime(), jsonObject.getString($_JSONAttributes.User_Name.toString()));
                    if (jsonObject.getString($_JSONAttributes.Id.toString()).equals(jsonObject.getString($_JSONAttributes.IdRecive.toString()))) {
                    } else {

                        if (jsonObject.get("MType").equals("R")) {
                            DataInputStream dataInputStream = new DataInputStream($_Client.getSocketMessage().getInputStream());
                            byte[] bytes = new byte[Integer.parseInt((($_JSON_Message_Image) my_json).getBytes().toLowerCase())];
                            dataInputStream.readFully(bytes);

                            $_Message message = new $_Message_Image((($_JSON_Message_Image) my_json).getIdFrom(), (($_JSON_Message_Image) my_json).getUsername(), "4", $_Static_Class.getCurrentTime(), bytes);
                          /*  if (main_chat_fragment.rooms == null) {
                                messages.add(message);
                            } else {
                                if (main_chat_fragment.rooms.size() == 0) {
                                    messages.add(message);
                                } else {
                                    int size = messages.size();
                                    System.out.println("SIZE = " + size);
                                    for (int i = 0; i < size; i++) {
                                        main_chat_fragment.rooms.get(0).second.addMessage(messages.get(0));
                                        messages.remove(0);
                                    }
                                    main_chat_fragment.rooms.get(0).second.addMessage(message);
                                }
                            }*/
                            //messages.add(message);
                            allMessages.get(message.getId()).second.add(message);
                            FourActivity.fragmentActivity.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    allMessages.get(message.getId()).first.notifyDataSetChanged();
                                }
                            });
                            Thread thread = new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    MainActivity.store_message.storeMessage(message.getId(), MainActivity.allMessages.get(message.getId()).second);
                                }
                            });
                            thread.start();
                            //   mangementChatMessage.setFileOutputFriend(context.openFileOutput(FriendPathMangment.FriendPath + File.separator + message.getId() + File.separator + message.getId() + ".Fi", MODE_PRIVATE));
                            //   mangementChatMessage.add(message);
                        }
                        //          }//
                        //     }
                    }
                    break;
                }

                case "Message_Voice": {
                    if (jsonObject.getString($_JSONAttributes.Id.toString()).equals(jsonObject.getString($_JSONAttributes.IdRecive.toString()))) {
                    } else {
                        System.out.println("QQQQ = " + jsonObject);
                        my_json = new $_JSON_Message_Voice("Message_Voice", jsonObject.getString($_JSONAttributes.Id.toString()), jsonObject.getString($_JSONAttributes.IdRecive.toString()), jsonObject.getString("Message"), $_Static_Class.getCurrentTime(), jsonObject.getString($_JSONAttributes.User_Name.toString()));
                        DataInputStream dataInputStream = new DataInputStream($_Client.getSocketMessage().getInputStream());
                        byte[] bytes = new byte[Integer.parseInt((($_JSON_Message_Voice) my_json).getBytes().toLowerCase())];
                        dataInputStream.readFully(bytes);
                        $_Message message = new $_Message_Voice((($_JSON_Message_Voice) my_json).getIdFrom(), (($_JSON_Message_Voice) my_json).getUsername(), "6", (($_JSON_Message_Voice) my_json).getTime(), 0, bytes);

                        allMessages.get(message.getId()).second.add(message);
                        FourActivity.fragmentActivity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                allMessages.get(message.getId()).first.notifyDataSetChanged();
                                Toast.makeText(FourActivity.context, "OOOOOOOOOOOKKKKK", Toast.LENGTH_LONG).show();
                            }
                        });
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                MainActivity.store_message.storeMessage(message.getId(), MainActivity.allMessages.get(message.getId()).second);
                            }
                        });
                        thread.start();
/*
                        //play voice
                        FileOutputStream fileOutputStream = new FileOutputStream( Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator +  message.getId() + ".3gp");
                        fileOutputStream.write(bytes);

                         MediaPlayer mPlayer;

                        mPlayer = new MediaPlayer();
                        try {
                            mPlayer.setDataSource(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator +  message.getId() + ".3gp");
                            mPlayer.prepare();
                            mPlayer.start();
                        } catch (IOException e) {
                        }
*/

                    }


                    break;
                }
                case "Change_Message_Successful": {
                    my_json = new $_JSON_Change_Image_Successful("Change_Message_Successful", jsonObject.getString($_JSONAttributes.IdRecive.toString()), jsonObject.getBoolean($_JSONAttributes.Done.toString()), jsonObject.getString($_JSONAttributes.User_Name.toString()));
                    $_JSON finalMy_json2 = my_json;

                    SecondActivity.fragmentActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if ((($_JSON_Change_Image_Successful) finalMy_json2).isDone()) {
                                Toast.makeText(SecondActivity.context, "Add Picture Successfully", Toast.LENGTH_SHORT).show();
                                System.out.println("AAAAAAccepted");

                             /*   JSONObject jsonObject1 = new JSONObject();
                                try {
                                    jsonObject1.put("Id", (($_JSON_SignUp_Tow_Successful) finalMy_json).getIdReceived());
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                Bundle bundle = new Bundle();
                                fragmentTransaction = SecondActivity.fragmentManager.beginTransaction();
                                JSONObject jsonObject2 = new JSONObject();
                                try {
                                    finalJsonObject1.put($_JSONAttributes.Id.toString(), $_Client.getEmail());
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                bundle.putString("data", finalJsonObject1.toString());
                                main_fragment.setArguments(bundle);*/
                                // main_fragment main_fragment = new main_fragment();
                                //SecondActivity.fragmentManager.beginTransaction().replace(R.id.container_main_second, main_fragment).commit();
                            } else {
                                Toast.makeText(SecondActivity.context, "App Picture UN Successfully", Toast.LENGTH_SHORT).show();
                                $_Client.getSharedPreferences().removeObject("id");
                                $_Client.getSharedPreferences().removeObject("username");
                                $_Client.getSharedPreferences().removeObject("password");
                            }
                        }
                    });
                    break;
                }

                case "Search_User_Successful": {
                    JSONArray jsonArray_Ids = jsonObject.getJSONArray("Ids");
                    JSONArray jsonArray_Users_name = jsonObject.getJSONArray("Users_Name");
                    JSONArray jsonArray_State_Users = jsonObject.getJSONArray("State_Users");
                    JSONArray jsonArray_lenthes = jsonObject.getJSONArray("Photos_lenths");
                    ArrayList<String> Ids = new ArrayList<>();
                    ArrayList<String> Users_name = new ArrayList<>();
                    ArrayList<String> State_Users = new ArrayList<>();
                    ArrayList<Integer> lenthes = new ArrayList<>();
                    ArrayList<byte[]> photos = new ArrayList<>();

                    for (int i = 0; i < jsonArray_Ids.length(); i++) {
                        Ids.add(jsonArray_Ids.getString(i));
                        Users_name.add(jsonArray_Users_name.getString(i));
                        State_Users.add(jsonArray_State_Users.getString(i));
                        lenthes.add(jsonArray_lenthes.getInt(i));



                    }
                    Thread thread=new Thread(new Runnable() {
                        @Override
                        public void run() {
                            for (int i = 0; i < jsonArray_Ids.length(); i++) {


                            try {
                                byte[] temp = new byte[jsonArray_lenthes.getInt(i)];
                                System.out.println("Photo");
                                $_Client.getDataInputStreamMessage().readFully(temp);
                                photos.add(temp);

                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                                 }
                                 ThirdActivity .fragmentActivity.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    ThirdActivity.search_fragment.Edit_Image(photos);
                                }
                            });
                            System.out.println("photo2");
                        }
                    });
                    thread.start();

                    my_json = new $_JSON_Search_User_Successful("Search_User_Successful", jsonObject.getString($_JSONAttributes.IdRecive.toString()), jsonObject.getBoolean($_JSONAttributes.Done.toString()), Ids, Users_name, State_Users, lenthes);
                    final $_JSON_Search_User_Successful finalMy_json = ($_JSON_Search_User_Successful) my_json;
                    final JSONObject finalJsonObject = jsonObject;
                    SecondActivity.fragmentActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ThirdActivity.search_fragment.set_list_show(finalMy_json);
                        }
                    });
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Friend_Request": {
                    System.out.println(jsonObject.toString());
                    my_json = new $_JSON_Friend_Request("Friend_Request", jsonObject.getString($_JSONAttributes.IdRecive.toString()), jsonObject.getString($_JSONAttributes.Id_Friend_Request.toString()), jsonObject.getString($_JSONAttributes.user_friend_request.toString()));
                    final $_JSON_Friend_Request finalMy_json1 = ($_JSON_Friend_Request) my_json;
                    SecondActivity.fragmentActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            MainActivity.fragment_notifiction.prepare_friend_request_notifiction(finalMy_json1);
                            Toast.makeText(context, "Friend_Request", Toast.LENGTH_SHORT).show();

                        }
                    });


                    break;
                }
                case "Add_Friend_Response": {
                    my_json = new $_JSON_Add_Friend_Response("Add_Friend_Response", jsonObject.getString($_JSONAttributes.IdRecive.toString()), jsonObject.getBoolean($_JSONAttributes.Done.toString()), jsonObject.getString($_JSONAttributes.Add_Friend_Id.toString()));
                    final $_JSON finalMy_json1 = my_json;
                    ThirdActivity.fragmentActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ThirdActivity.search_fragment.Edit_button((($_JSON_Add_Friend_Response) finalMy_json1).getId_user(), "Remove Request");
                        }
                    });
                    break;
                }
                case "Friend_Refusal_Request": {
                    my_json = new $_JSON_Friend_Refusal_Request("Friend_Refusal_Request", jsonObject.getString($_JSONAttributes.IdRecive.toString()), jsonObject.getString($_JSONAttributes.Id_Friend_Refusal_Request.toString()), jsonObject.getString($_JSONAttributes.user_friend_request.toString()));
                    SecondActivity.fragmentActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });
                    break;
                }
                case "Refusal_Friend_Response": {
                    my_json = new $_JSON_Refusal_Friend_Response("Refusal_Friend_Response", jsonObject.getString($_JSONAttributes.IdRecive.toString()), jsonObject.getBoolean($_JSONAttributes.Done.toString()), jsonObject.getString($_JSONAttributes.Refusal_Friend_Id.toString()));
                    $_JSON finalMy_json7 = my_json;
                    ThirdActivity.fragmentActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ThirdActivity.search_fragment.Edit_button((($_JSON_Refusal_Friend_Response) finalMy_json7).getId_user(), "Add");


                        }
                    });
                    break;
                }
                case "Accept_Friend_Response": {
                    my_json = new $_JSON_Accept_Friend_Respons("Accept_Friend_Response", jsonObject.getString($_JSONAttributes.IdRecive.toString()), jsonObject.getBoolean($_JSONAttributes.Done.toString()), jsonObject.getString($_JSONAttributes.Accept_Friend_Id.toString()), jsonObject.getString($_JSONAttributes.User_Name.toString()),jsonObject.getInt("ImageLength"));

                    $_JSON_Accept_Friend_Respons finalMy_json2 = ($_JSON_Accept_Friend_Respons) my_json;
                   Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                DataInputStream dataInputStream = new DataInputStream($_Client.getSocketMessage().getInputStream());
                                System.out.println("tttttttttttttttttttttt"+finalMy_json2.getImagelenth());
                                bytes = new byte[ finalMy_json2.getImagelenth()];
                                dataInputStream.readFully(bytes);

                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                    thread.start();
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    store_friend.storeFriend(finalMy_json2.getId_user(), finalMy_json2.getUser_name(), "State", bytes);
                    $_Value_Item_Main_Chat value_item_main_chat = new $_Value_Item_Main_Chat("null", finalMy_json2.getUser_name(), finalMy_json2.getId_user(),bytes);

                    SecondActivity.fragmentActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            addChat(finalMy_json2, value_item_main_chat);
                            ThirdActivity.search_fragment.Edit_button(finalMy_json2.getId_user(), "Remove");
                            SecondActivity.friend_fragment.getValueItemFriends().add(new $_Value_Item_Friend(finalMy_json2.getId_user(),finalMy_json2.getUser_name(),"state",bytes));
                            SecondActivity.friend_fragment.getRecycleViewFriend().notifyDataSetChanged();


                        }
                    });

                    break;
                }
                case "Friend_Accept_Response": {
                    my_json = new $_JSON_Friend_Accept_Response("Friend_Accept_Response", jsonObject.getString($_JSONAttributes.IdRecive.toString()), jsonObject.getString($_JSONAttributes.Id_Friend_Accept_Response.toString()), jsonObject.getString($_JSONAttributes.User_Name.toString()), jsonObject.getInt($_JSONAttributes.Message.toString()));

                    $_JSON_Friend_Accept_Response finalMy_json3 = ($_JSON_Friend_Accept_Response) my_json;
                    $_JSON finalMy_json6 = my_json;
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                DataInputStream dataInputStream = new DataInputStream($_Client.getSocketMessage().getInputStream());
                                System.out.println("1111111111111111111111111111111");
                                bytes = new byte[(($_JSON_Friend_Accept_Response) finalMy_json6).getImagelenth()];
                                dataInputStream.readFully(bytes);
                                System.out.println("2222222222222222222222222222222222 = " + bytes);

                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                    thread.start();
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    store_friend.storeFriend(finalMy_json3.getId_user(), finalMy_json3.getUser_name(), "State", bytes);
                    $_Value_Item_Main_Chat value_item_main_chat = new $_Value_Item_Main_Chat("null", (($_JSON_Friend_Accept_Response) finalMy_json6).getUser_name(), (($_JSON_Friend_Accept_Response) finalMy_json6).getId_user(), bytes);
                    SecondActivity.fragmentActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            addChatFriend(finalMy_json3, value_item_main_chat);
                            SecondActivity.friend_fragment.getValueItemFriends().add(new $_Value_Item_Friend(finalMy_json3.getId_user(),finalMy_json3.getUser_name(),"state",bytes));
                            SecondActivity.friend_fragment.getRecycleViewFriend().notifyDataSetChanged();
                        }
                    });

                    break;
                }
                case "Remove_Friend_Response": {
                    my_json = new $_JSON_Remove_Friend_Response("Remove_Friend_Response", jsonObject.getString($_JSONAttributes.IdRecive.toString()), jsonObject.getBoolean($_JSONAttributes.Done.toString()), jsonObject.getString($_JSONAttributes.Remove_Friend_Id.toString()));
                    $_JSON_Remove_Friend_Response finalMy_json4 = ($_JSON_Remove_Friend_Response) my_json;
                    SecondActivity.fragmentActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ThirdActivity.search_fragment.Edit_button(finalMy_json4.getId_user(), "Add");
                            store_friend.removeFriend(finalMy_json4.getId_user());
                            $_Value_Item_Main_Chat value_item_main_chat = getValueItemMainChat(finalMy_json4.getId_user());
                            main_chat_fragment.rooms.remove(value_item_main_chat);
                            main_chat_fragment.recycleAdapter.notifyDataSetChanged();
                            SecondActivity.friend_fragment.remove(finalMy_json4.getId_user());
                        }
                    });
                    break;
                }
                case "Friend_Remove_Response": {
                    my_json = new $_JSON_Friend_Remove("Friend_Remove_Response", jsonObject.getString($_JSONAttributes.IdRecive.toString()), jsonObject.getString($_JSONAttributes.Id_Friend_Remove_Response.toString()), jsonObject.getString($_JSONAttributes.user_friend_request.toString()));
                    $_JSON_Friend_Remove finalMy_json8 = ($_JSON_Friend_Remove) my_json;
                    SecondActivity.fragmentActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context, "Test", Toast.LENGTH_SHORT).show();
                            store_friend.removeFriend(finalMy_json8.getId_user());
                            $_Value_Item_Main_Chat value_item_main_chat = getValueItemMainChat(finalMy_json8.getId_user());
                            main_chat_fragment.rooms.remove(value_item_main_chat);
                            main_chat_fragment.recycleAdapter.notifyDataSetChanged();
                            SecondActivity.friend_fragment.remove(finalMy_json8.getId_user());

                        }
                    });
                    break;
                }
                case "Remove_Request_Response": {
                    my_json = new $_JSON_Remove_Request_Response("Remove_Request_Response", jsonObject.getString($_JSONAttributes.IdRecive.toString()), jsonObject.getBoolean($_JSONAttributes.Done.toString()), jsonObject.getString($_JSONAttributes.Remove_Request_Id.toString()));
                    $_JSON_Remove_Request_Response finalMy_json5 = ($_JSON_Remove_Request_Response) my_json;
                    SecondActivity.fragmentActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ThirdActivity.search_fragment.Edit_button(finalMy_json5.getId_user(), "Add");

                        }
                    });
                    break;
                }
                case "Friend_Remove_Request": {
                    my_json = new $_JSON_Friend_Remove("Friend_Remove_Request", jsonObject.getString($_JSONAttributes.IdRecive.toString()), jsonObject.getString($_JSONAttributes.Id_Request_Remove_Response.toString()), jsonObject.getString($_JSONAttributes.user_friend_request.toString()));
                    SecondActivity.fragmentActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });

                    break;
                }
                case  "Online_Friends_Response":
                {
                    JSONArray jsonArray_Ids = jsonObject.getJSONArray("Ids");
                    JSONArray jsonArray_OnlineState = jsonObject.getJSONArray("OnlineState");
                    ArrayList<String> Ids=new ArrayList<>();
                    ArrayList<String> OnlineState=new ArrayList<>();
                    for (int i = 0; i < jsonArray_Ids.length(); i++) {
                        Ids.add(jsonArray_Ids.getString(i));
                        OnlineState.add(jsonArray_OnlineState.getString(i));
                    }
                    System.out.println("MMMMM");

                    my_json=new $_JSON_Online_Friend_Respons("Online_Friends_Response",jsonObject.getString($_JSONAttributes.IdRecive.toString()),true,Ids,OnlineState);
                    SecondActivity.fragmentActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("MMMMM");

                            SecondActivity.onlineFriendFragment.add_Online(Ids,OnlineState);
                        }
                    });

                    break;
                }

                default:
                    break;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static $_Value_Item_Main_Chat getValueItemMainChat(String id_user) {
        for ($_Value_Item_Main_Chat value_item_main_chat : main_chat_fragment.rooms) {
            if (value_item_main_chat.getEmail().equals(id_user)) {
                return value_item_main_chat;
            }
        }
        return null;
    }

    private static void addChatFriend($_JSON_Friend_Accept_Response finalMy_json6, $_Value_Item_Main_Chat value_item_main_chat) {
        room_chat room_chat = new room_chat();
        //FragmentTransaction fragmentTransaction = SecondActivity.fragmentActivity.getSupportFragmentManager().beginTransaction();
        //fragmentTransaction.add(R.id.container_main_second, room_chat).addToBackStack(null).hide(room_chat).addToBackStack(null).commitAllowingStateLoss();
        System.out.println("RRRRRRR = " + value_item_main_chat.getId_image());
        main_chat_fragment.rooms.add(value_item_main_chat);
        main_chat_fragment.recycleAdapter.notifyDataSetChanged();
        List<$_Message> list = new ArrayList();
        MainActivity.allMessages.put(value_item_main_chat.getEmail(), new Pair<>(new $_Recycle_View_Room_Chat_Adapter(list, FourActivity.context), list));

        //MainActivity.allMessages.put(value_item_main_chat.getEmail(),new ArrayList<>());


    }


    public static void addChat($_JSON_Accept_Friend_Respons finalMy_json2, $_Value_Item_Main_Chat value_item_main_chat) {
        room_chat room_chat = new room_chat();
        //FragmentTransaction fragmentTransaction = SecondActivity.fragmentActivity.getSupportFragmentManager().beginTransaction();
        //fragmentTransaction.add(R.id.container_main_second, room_chat).hide(room_chat).addToBackStack(null).commitAllowingStateLoss();
        main_chat_fragment.rooms.add(value_item_main_chat);
        main_chat_fragment.recycleAdapter.notifyDataSetChanged();
        List<$_Message> list = new ArrayList();
        MainActivity.allMessages.put(value_item_main_chat.getEmail(), new Pair<>(new $_Recycle_View_Room_Chat_Adapter(list, FourActivity.context), list));

        //MainActivity.allMessages.put(value_item_main_chat.getEmail(),new ArrayList<>());


    }


    public static void get_Recive_Data_And_Apply() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    final $_CheckReciveData checkReciveData = new $_CheckReciveData();
                    checkReciveData.excute();

                    if (checkReciveData.getResult() != null) {
                        Decode_JSON(checkReciveData);
                    }
                }
            }
        }).start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        secondActivity = new SecondActivity();
        thirdActivity = new ThirdActivity();
        fourActivity = new FourActivity();
        allMessages = new HashMap<>();

        signin_fragment topLoginFragment = new signin_fragment();
        signup_fragment topSignUpFragment = new signup_fragment();


        binding.loginFragment.setRotation(-90);

        binding.button.setOnSignUpListener(topSignUpFragment);
        binding.button.setOnLoginListener(topLoginFragment);

        binding.button.setOnButtonSwitched(isLogin -> {
            binding.getRoot()
                    .setBackgroundColor(ContextCompat.getColor(
                            this,
                            isLogin ? R.color.colorPrimary : R.color.secondPage));
        });

        binding.loginFragment.setVisibility(INVISIBLE);


        fragmentActivity = this;
        context = this;
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        store_friend = new $_Store_Friend(new $_FriendStorgeMangement());
        store_message = new $_Store_Message(new $_ChatMessageMangment());
        $_Client.setSharedPreferences(new $_SharedPreferences("RememberMe"));
        //$_Client.getSharedPreferences().removeObject("data_signup");
        //messages = new ArrayList<>();
        if (findViewById(R.id.container_main) != null) {
            if (savedInstanceState != null) return;
            if ($_Client.getSharedPreferences().isExist("id") == "") {
                //  fragmentTransaction.add(R.id.continer_main, new signin_fragment(), null).addToBackStack(null).commit();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.login_fragment, topLoginFragment)
                        .replace(R.id.sign_up_fragment, topSignUpFragment)
                        .commit();
            } else {
                //fragmentTransaction.add(R.id.container_main, new main_fragment(), null).addToBackStack(null).commit();
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //  if (validateEmail() && validatePassword() && validateConfirmPassword()) {
                            $_Client client = new $_Client(context);
                            send_Sign_In();
                            $_Client.setCheckOnline(new $_CheckOnline($_Client.getEmail(), "Check", "online"));
                            get_Recive_Data_And_Apply();
                            //  }
                        } catch (IOException e) {
                            System.err.println("error connect to internet");
                        }
                    }
                });
                thread.start();

                Bundle bundle = new Bundle();
                bundle.putString("fragment", "main_fragment");
                Intent intent = new Intent(MainActivity.context, SecondActivity.class);
                intent.putExtras(bundle);
                MainActivity.fragmentActivity.startActivity(intent);
            }
        }
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        binding.loginFragment.setPivotX(binding.loginFragment.getWidth() / 2);
        binding.loginFragment.setPivotY(binding.loginFragment.getHeight());
        binding.signUpFragment.setPivotX(binding.signUpFragment.getWidth() / 2);
        binding.signUpFragment.setPivotY(binding.signUpFragment.getHeight());
    }

    public void switchFragment(View v) {
        if (isLogin) {
            binding.loginFragment.setVisibility(VISIBLE);
            binding.loginFragment.animate().rotation(0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    binding.signUpFragment.setVisibility(INVISIBLE);
                    binding.signUpFragment.setRotation(90);
                    binding.wrapper.setDrawOrder(ORDER_LOGIN_STATE);
                }
            });
        } else {
            binding.signUpFragment.setVisibility(VISIBLE);
            binding.signUpFragment.animate().rotation(0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    binding.loginFragment.setVisibility(INVISIBLE);
                    binding.loginFragment.setRotation(-90);
                    binding.wrapper.setDrawOrder(ORDER_SIGN_UP_STATE);
                }
            });
        }

        isLogin = !isLogin;
        binding.button.startAnimation();
    }

    @Override
    public void onFragmentInteraction(String json, String id) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private void send_Sign_In() {
        String email = $_Client.getSharedPreferences().getObject("id");
        String username = $_Client.getSharedPreferences().getObject("username");
        String password = $_Client.getSharedPreferences().getObject("password");
        JSONObject jsonObject = new JSONObject();
        if (email != null) {
            try {
                jsonObject.put($_JSONAttributes.Type.toString(), "Login_User");
                jsonObject.put($_JSONAttributes.Id.toString(), username);
                jsonObject.put($_JSONAttributes.Password.toString(), password);
                $_Client.getDataOutputStreamOnline().writeUTF(jsonObject.toString());
                $_Client.setEmail(email);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.err.println("error send data sign up");
            }

        } else {

        }

    }
     public static ArrayList<String> getFriends(String path)
     {
         File all_friend = new File(path);
         $_FriendInfo friendInfo;
         ArrayList<String > temp=new ArrayList<>();
         for (File temp_file : all_friend.listFiles()){
             friendInfo = ($_FriendInfo) MainActivity.store_friend.retriveFriend(temp_file.getName());
             temp.add(friendInfo.getId());
         }

         return temp;
     }

    public static void getOnline()
    {


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        ArrayList<String> friends=getFriends(FriendPathMangment.FriendPath + "/");

                        Thread.sleep(5000);
                        JSONObject jsonObject1 = new JSONObject();
                        jsonObject1.put($_JSONAttributes.Type.toString(), "Online_Friends");
                        jsonObject1.put($_JSONAttributes.Id.toString(), $_Client.getEmail());
                        jsonObject1.put($_JSONAttributes.User_Name.toString(), $_Client.getUserName());
                        jsonObject1.put("Friends", new JSONArray(friends));
                        $_Client.getDataOutputStreamMessage().writeUTF(jsonObject1.toString());
                        $_Client.getDataOutputStreamMessage().flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();


    }
    @Override
    protected void onStop() {
        super.onStop();
    }


}