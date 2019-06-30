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
import android.support.v7.widget.DividerItemDecoration;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;

import com.myhexaville.Logic.Client.$_ClientStatic;
import com.myhexaville.Logic.Client.$_MyAccountStorgeMangement;
import com.myhexaville.Logic.Friend.$_FriendInfo;
import com.myhexaville.Logic.Friend.$_FriendStorgeMangement;
import com.myhexaville.Logic.Information.$_AccountInformation;
import com.myhexaville.Logic.Information.$_AccountInformationById;
import com.myhexaville.Logic.Information.$_GroupInformation;
import com.myhexaville.Logic.JSONData.$_JSON;
import com.myhexaville.Logic.JSONData.$_JSONAttributes;
import com.myhexaville.Logic.JSONData.$_JSON_Accept_Friend_Respons;
import com.myhexaville.Logic.JSONData.$_JSON_Add_Friend_Response;
import com.myhexaville.Logic.JSONData.$_JSON_Change_Image_Successful;
import com.myhexaville.Logic.JSONData.$_JSON_Create_Group_Successful;
import com.myhexaville.Logic.JSONData.$_JSON_Friend_Accept_Response;
import com.myhexaville.Logic.JSONData.$_JSON_Friend_Refusal_Request;
import com.myhexaville.Logic.JSONData.$_JSON_Friend_Remove;
import com.myhexaville.Logic.JSONData.$_JSON_Friend_Request;
import com.myhexaville.Logic.JSONData.$_JSON_Login_Successful;
import com.myhexaville.Logic.JSONData.$_JSON_Message_Image_Client;
import com.myhexaville.Logic.JSONData.$_JSON_Message_Image_Client_In_Group;
import com.myhexaville.Logic.JSONData.$_JSON_Message_Text_Client;
import com.myhexaville.Logic.JSONData.$_JSON_Message_Text_Client_In_Group;
import com.myhexaville.Logic.JSONData.$_JSON_Message_Voice_Client;
import com.myhexaville.Logic.JSONData.$_JSON_Online_Friend_Respons;
import com.myhexaville.Logic.JSONData.$_JSON_Refusal_Friend_Response;
import com.myhexaville.Logic.JSONData.$_JSON_Remove_Friend_Response;
import com.myhexaville.Logic.JSONData.$_JSON_Remove_Group_Successful;
import com.myhexaville.Logic.JSONData.$_JSON_Remove_Request_Response;
import com.myhexaville.Logic.JSONData.$_JSON_Search_User_Successful;
import com.myhexaville.Logic.JSONData.$_JSON_SignUp_Successful;
import com.myhexaville.Logic.JSONData.$_JSON_SignUp_Tow_Successful;
import com.myhexaville.Logic.JSONData.$_JSON_login;
import com.myhexaville.Logic.MessagesChats.$_ChatMessageGroupMangment;
import com.myhexaville.Logic.MessagesChats.$_ChatMessageMangment;
import com.myhexaville.Logic.Room.$_Group;
import com.myhexaville.Logic.ServerManagment.$_CheckOnline;
import com.myhexaville.Logic.ServerManagment.$_CheckReciveData;
import com.myhexaville.Logic.ServerManagment.$_SendData;
import com.myhexaville.Logic.Tools.$_SharedPreferences;
import com.myhexaville.UI.$_Static_Class;
import com.myhexaville.UI.Account.signin_fragment;
import com.myhexaville.UI.Account.signup_fragment;
import com.myhexaville.UI.Account.signup_fragment_tow;
import com.myhexaville.UI.Adapter.AdapterCreateGroup.$_Value_Item_Create_Group;
import com.myhexaville.UI.Adapter.AdapterFriend.$_Value_Item_Friend;
import com.myhexaville.UI.Adapter.AdapterMainChat.$_Abstruct_Value_Item_Main_Chat;
import com.myhexaville.UI.Adapter.AdapterMainChat.Client_Room.$_Value_Item_Main_Chat;
import com.myhexaville.UI.Adapter.AdapterMainChat.Group_Room.$_Value_Item_Main_Chat_Group;
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
import com.myhexaville.UI.ToolStorage.$_Store_Message_Group;
import com.myhexaville.UI.ToolStorage.$_Store_My_Account;
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
import static com.myhexaville.UI.Chat.MainFragment.MainChat.main_chat_fragment.recycle_view_main_chat;
import static com.myhexaville.UI.Chat.MainFragment.MainChat.main_chat_fragment.rooms;
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
        friend_fragment.OnFragmentInteractionListener {

    private static final String TAG = "MainActivity";
    public static FragmentManager fragmentManager;
    public static FragmentActivity fragmentActivity;
    public static Context context;
    public static Fragment fragment;
    public static $_Store_Friend store_friend;
    public static $_Store_Message store_message;
    public static $_Store_Message_Group store_message_group;
    public static $_Store_My_Account store_my_account;
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
    private FiveActivity fiveActivity;

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

    public static void Decode_JSON($_CheckReciveData checkReciveData) {
        JSONObject jsonObject = null;
        $_JSON my_json = null;
        try {
            if (checkReciveData.getResult() instanceof String)
                jsonObject = new JSONObject((String) checkReciveData.getResult());
            else {
                byte[] bytes = new byte[100];
                $_ClientStatic.getDataInputStreamMessage().read(bytes);

            }


            switch (jsonObject.getString("Type")) {
                case "Login_User_Successful": {
                    List<Integer> length_photo = fill_length_photo(jsonObject);

                    $_JSON finalMy_json10 = my_json;
                    List<byte[]> bytes1 = new ArrayList<>();
                    List<$_Group> groups = new ArrayList<>();
                    if (jsonObject.getBoolean($_JSONAttributes.Done.toString())) {

                        JSONObject finalJsonObject2 = jsonObject;
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {

                                    DataInputStream dataInputStream = null;
                                    dataInputStream = new DataInputStream($_ClientStatic.getSocketMessage().getInputStream());
                                    byte[] bytes = new byte[0];
                                    try {
                                        bytes = new byte[Integer.parseInt(finalJsonObject2.getString($_JSONAttributes.Message.toString()))];
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    dataInputStream.readFully(bytes);
                                    $_ClientStatic.setPersonalImage(bytes);
                                    for (int i = 0; i < length_photo.size(); i++) {
                                        byte[] one_photo = new byte[length_photo.get(i)];
                                        dataInputStream.readFully(one_photo);
                                        bytes1.add(one_photo);
                                        System.out.println(" i = " + i);
                                    }
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

                        groups = fill_groups(jsonObject, bytes1);
                        $_ClientStatic.setAll_groups(groups);

                        my_json = new $_JSON_Login_Successful("Login_User_Successful", jsonObject.getString($_JSONAttributes.IdRecive.toString()), jsonObject.getString($_JSONAttributes.User_Name.toString()), jsonObject.getString($_JSONAttributes.State.toString()), jsonObject.getString($_JSONAttributes.Message.toString()), groups, length_photo, jsonObject.getBoolean($_JSONAttributes.Done.toString()));
                        final $_JSON finalMy_json = my_json;

                        fragmentActivity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                          /*  $_Client.setEmail($_Client.getSharedPreferences().getObject("id_project"));
                            $_Client.setUserName($_Client.getSharedPreferences().getObject("username_project"));*/
                                if ((($_JSON_Login_Successful) finalMy_json).isDone()) {
                                    Toast.makeText(context, "Login_User_Successful", Toast.LENGTH_SHORT).show();
                                    $_ClientStatic.setEmail((($_JSON_Login_Successful) finalMy_json).getIdReceived());
                                    $_ClientStatic.setUserName((($_JSON_Login_Successful) finalMy_json).getUsername());
                                    $_ClientStatic.setState((($_JSON_Login_Successful) finalMy_json).getState());


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

                                    Bundle bundle = new Bundle();
                                    bundle.putString("fragment", "main_fragment");

                                    Intent intent = new Intent(MainActivity.context, SecondActivity.class);
                                    intent.putExtras(bundle);
                                    MainActivity.fragmentActivity.startActivity(intent);
                                } else {

                                }
                            }
                        });
                    } else {
                        fragmentActivity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context, "Sign Up UN Successfully", Toast.LENGTH_SHORT).show();
                                $_ClientStatic.getSharedPreferences().removeObject("id");
                                $_ClientStatic.getSharedPreferences().removeObject("username");
                                $_ClientStatic.getSharedPreferences().removeObject("password");
                                /*if ($_Client.getSharedPreferences().isExist("data_signup").equals(""))
                                    $_Client.getSharedPreferences().removeObject("username");*/
                                /*$_Client.setEmail("Email");
                                $_Client.setUserName("Username");*/
                            }
                        });

                    }
                    break;
                }
                case "Sign_Up_Successful": {
                    my_json = new $_JSON_SignUp_Successful("Sign_Up_Successful", jsonObject.getString($_JSONAttributes.IdRecive.toString()), jsonObject.getBoolean($_JSONAttributes.Done.toString()), jsonObject.getString($_JSONAttributes.User_Name.toString()), jsonObject.getString($_JSONAttributes.Password.toString()));
                    final $_JSON finalMy_json = my_json;
                    fragmentActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                          /*  $_Client.setEmail($_Client.getSharedPreferences().getObject("id_project"));
                            $_Client.setUserName($_Client.getSharedPreferences().getObject("username_project"));*/
                            if ((($_JSON_SignUp_Successful) finalMy_json).isDone()) {
                                Toast.makeText(context, "Sign Up Successfully", Toast.LENGTH_SHORT).show();
                                $_ClientStatic.setEmail((($_JSON_SignUp_Successful) finalMy_json).getIdReceived());
                                $_ClientStatic.setUserName((($_JSON_SignUp_Successful) finalMy_json).getUser_name());

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

                                intent.putExtras(bundle);
                                MainActivity.fragmentActivity.startActivity(intent);
                                // getOnline();
                            } else {
                                Toast.makeText(context, "Sign Up UN Successfully", Toast.LENGTH_SHORT).show();
                                $_ClientStatic.getSharedPreferences().removeObject("id");
                                $_ClientStatic.getSharedPreferences().removeObject("username");
                                $_ClientStatic.getSharedPreferences().removeObject("password");
                                $_ClientStatic.getSharedPreferences().removeObject("id_project");
                                $_ClientStatic.getSharedPreferences().removeObject("username_project");
                            }
                        }
                    });
                    break;
                }
                case "Sign_Up_Tow_Successful": {
                    my_json = new $_JSON_SignUp_Tow_Successful("Sign_Up_Tow_Successful", jsonObject.getString($_JSONAttributes.IdRecive.toString()), jsonObject.getBoolean($_JSONAttributes.Done.toString()), jsonObject.getString($_JSONAttributes.State.toString()));
                    final $_JSON finalMy_json = my_json;
                    final JSONObject finalJsonObject1 = jsonObject;
                    fragmentActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if ((($_JSON_SignUp_Tow_Successful) finalMy_json).isDone()) {
                                Toast.makeText(context, "Sign Up AAAAAL Successfully", Toast.LENGTH_SHORT).show();
                                $_ClientStatic.setState((($_JSON_SignUp_Tow_Successful) finalMy_json).getState());
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
                                $_ClientStatic.setEmail($_ClientStatic.getSharedPreferences().getObject("id"));
                                $_ClientStatic.setUserName($_ClientStatic.getSharedPreferences().getObject("username"));
                                main_fragment main_fragment = new main_fragment();
                                SecondActivity.fragmentManager.beginTransaction().replace(R.id.container_main_second, main_fragment).commit();
                            } else {
                                Toast.makeText(context, "Sign Up AAAAAL UN Successfully", Toast.LENGTH_SHORT).show();
                                $_ClientStatic.getSharedPreferences().removeObject("id");
                                $_ClientStatic.getSharedPreferences().removeObject("username");
                                $_ClientStatic.getSharedPreferences().removeObject("password");
                            }
                        }
                    });
                    break;
                }

                case "Create_Group_Successful": {
                    List<Integer> length_photo = fill_length_photo(jsonObject);
                    DataInputStream dataInputStream = null;
                    dataInputStream = new DataInputStream($_ClientStatic.getSocketMessage().getInputStream());
                    List<byte[]> bytes1 = new ArrayList<>();

                    for (int i = 0; i < length_photo.size(); i++) {
                        byte[] one_photo = new byte[length_photo.get(i)];
                        dataInputStream.readFully(one_photo);
                        bytes1.add(one_photo);
                        System.out.println(" i = " + i);
                    }

                    $_Group group = fill_group(jsonObject, bytes1);

                    my_json = new $_JSON_Create_Group_Successful(
                            jsonObject.getString($_JSONAttributes.Type.toString()),
                            jsonObject.getString($_JSONAttributes.IdRecive.toString()),
                            group,
                            length_photo,
                            jsonObject.getBoolean($_JSONAttributes.Done.toString())
                    );
                    $_JSON finalMy_json9 = my_json;
                    fragmentActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if ((($_JSON_Create_Group_Successful) finalMy_json9).isDone()) {
                                Toast.makeText(context, "Create Group Successfully", Toast.LENGTH_SHORT).show();
                                Toast.makeText(context, group.getGroup_information().getID(), Toast.LENGTH_SHORT).show();

                                List<String> client_id = new ArrayList<>();
                                for (int i = 0; i < group.getClients().size(); i++) {
                                    client_id.add(group.getClients().get(i).getID());
                                }
                                $_Value_Item_Main_Chat_Group value_item_create_group = new $_Value_Item_Main_Chat_Group(
                                        "Message",
                                        group.getGroup_information().getName(),
                                        group.getGroup_information().getID(),
                                        group.getClients().get(0).getPicture(),
                                        "group",
                                        client_id,
                                        group.getGroup_information(),
                                        group.getClients()
                                );
                                addChat(value_item_create_group);
                            } else {
                                Toast.makeText(context, "Create Group UN Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                    break;
                }
                case "Remove_Group_Successful": {
                    my_json = new $_JSON_Remove_Group_Successful(
                            jsonObject.getString($_JSONAttributes.Type.toString()),
                            jsonObject.getString($_JSONAttributes.IdRecive.toString()),
                            jsonObject.getString($_JSONAttributes.IdGroup.toString()),
                            jsonObject.getBoolean($_JSONAttributes.Done.toString())
                    );
                    $_JSON finalMy_json11 = my_json;
                    $_JSON finalMy_json12 = my_json;
                    fragmentActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if ((($_JSON_Remove_Group_Successful) finalMy_json11).isDone()) {
                                Toast.makeText(context, "Remove Group Successfully", Toast.LENGTH_SHORT).show();
                                for (int i = 0; i < rooms.size(); i++) {
                                    if (rooms.get(i).getEmail().equals((($_JSON_Remove_Group_Successful) finalMy_json12).getIdGroup())) {
                                        rooms.remove(i);
                                        main_chat_fragment.recycleAdapter.notifyDataSetChanged();
                                        break;
                                    }
                                }

                            } else {
                                Toast.makeText(context, "Remove Group UN Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    break;
                }
                case "Message_Text": {
                    my_json = new $_JSON_Message_Text_Client("Message_Text", jsonObject.getString($_JSONAttributes.Id.toString()), jsonObject.getString($_JSONAttributes.IdRecive.toString()), jsonObject.getString("MType"), jsonObject.getString("Message"), jsonObject.getString("Time"), jsonObject.getString($_JSONAttributes.User_Name.toString()));
                    if (jsonObject.getString($_JSONAttributes.Id.toString()).equals(jsonObject.getString($_JSONAttributes.IdRecive.toString()))) {

                        fragmentActivity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context, "Create Group Successfully", Toast.LENGTH_SHORT).show();
                            }
                        });


                    } else {
                        $_Message message = new $_Message_Text((($_JSON_Message_Text_Client) my_json).getIdFrom(), (($_JSON_Message_Text_Client) my_json).getUsername(), "3", (($_JSON_Message_Text_Client) my_json).getTime(), jsonObject.getString("Message"));
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

                case "Message_Text_Group": {
                    my_json = new $_JSON_Message_Text_Client_In_Group("Message_Text_Group", jsonObject.getString($_JSONAttributes.Id.toString()), jsonObject.getString($_JSONAttributes.IdRecive.toString()), jsonObject.getString($_JSONAttributes.IdGroup.toString()), jsonObject.getString("MType"), jsonObject.getString("Message"), jsonObject.getString("Time"), jsonObject.getString($_JSONAttributes.User_Name.toString()));
                    System.out.println("NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN = = = " + (($_JSON_Message_Text_Client_In_Group) my_json).getIdGroup());
                    if (jsonObject.getString($_JSONAttributes.Id.toString()).equals(jsonObject.getString($_JSONAttributes.IdRecive.toString()))) {

                        fragmentActivity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context, "Create Group Successfully", Toast.LENGTH_SHORT).show();
                            }
                        });


                    } else {
                        $_Message message = new $_Message_Text((($_JSON_Message_Text_Client_In_Group) my_json).getIdGroup(), (($_JSON_Message_Text_Client_In_Group) my_json).getUsername(), "3", (($_JSON_Message_Text_Client_In_Group) my_json).getTime(), jsonObject.getString("Message"));
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
                        $_JSON finalMy_json13 = my_json;
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                MainActivity.store_message_group.setMessageGroupFile(message.getId());
                                MainActivity.store_message_group.getChatMessageGroupMangment().setMessageFile(message.getId());

                                MainActivity.store_message_group.storeMessage((($_JSON_Message_Text_Client_In_Group) finalMy_json13).getIdFrom(), message.getId(), MainActivity.allMessages.get(message.getId()).second);
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
                    my_json = new $_JSON_Message_Image_Client("Message_Image", jsonObject.getString($_JSONAttributes.Id.toString()), jsonObject.getString($_JSONAttributes.IdRecive.toString()), jsonObject.getString("MType"), jsonObject.getString("Message"), $_Static_Class.getCurrentTime(), jsonObject.getString($_JSONAttributes.User_Name.toString()));
                    if (jsonObject.getString($_JSONAttributes.Id.toString()).equals(jsonObject.getString($_JSONAttributes.IdRecive.toString()))) {
                    } else {

                        if (jsonObject.get("MType").equals("R")) {
                            DataInputStream dataInputStream = new DataInputStream($_ClientStatic.getSocketMessage().getInputStream());
                            byte[] bytes = new byte[Integer.parseInt((($_JSON_Message_Image_Client) my_json).getBytes().toLowerCase())];
                            dataInputStream.readFully(bytes);

                            $_Message message = new $_Message_Image((($_JSON_Message_Image_Client) my_json).getIdFrom(), (($_JSON_Message_Image_Client) my_json).getUsername(), "4", $_Static_Class.getCurrentTime(), bytes);
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
                case "Message_Image_Group": {
                    my_json = new $_JSON_Message_Image_Client_In_Group("Message_Image_Group", jsonObject.getString($_JSONAttributes.Id.toString()), jsonObject.getString($_JSONAttributes.IdRecive.toString()), jsonObject.getString($_JSONAttributes.IdGroup.toString()), jsonObject.getString("MType"), $_Static_Class.getCurrentTime(), jsonObject.getString("Message"), jsonObject.getString($_JSONAttributes.User_Name.toString()));
                    if (jsonObject.getString($_JSONAttributes.Id.toString()).equals(jsonObject.getString($_JSONAttributes.IdRecive.toString()))) {
                    } else {

                        if (jsonObject.get("MType").equals("R")) {
                            DataInputStream dataInputStream = new DataInputStream($_ClientStatic.getSocketMessage().getInputStream());
                            byte[] bytes = new byte[Integer.parseInt((($_JSON_Message_Image_Client_In_Group) my_json).getBytes().toLowerCase())];
                            dataInputStream.readFully(bytes);
                            System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB =  " + bytes.length);

                            $_Message message = new $_Message_Image((($_JSON_Message_Image_Client_In_Group) my_json).getIdGroup(), (($_JSON_Message_Image_Client_In_Group) my_json).getUsername(), "4", $_Static_Class.getCurrentTime(), bytes);
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
                            $_JSON finalMy_json14 = my_json;
                            Thread thread = new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    MainActivity.store_message_group.setMessageGroupFile(message.getId());
                                    MainActivity.store_message_group.getChatMessageGroupMangment().setMessageFile(message.getId());
                                    MainActivity.store_message_group.storeMessage((($_JSON_Message_Image_Client_In_Group) finalMy_json14).getIdFrom(), (($_JSON_Message_Image_Client_In_Group) finalMy_json14).getIdGroup(), MainActivity.allMessages.get(message.getId()).second);
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
                        my_json = new $_JSON_Message_Voice_Client("Message_Voice", jsonObject.getString($_JSONAttributes.Id.toString()), jsonObject.getString($_JSONAttributes.IdRecive.toString()), "R", jsonObject.getString("Message"), $_Static_Class.getCurrentTime(), jsonObject.getString($_JSONAttributes.User_Name.toString()));
                        DataInputStream dataInputStream = new DataInputStream($_ClientStatic.getSocketMessage().getInputStream());
                        byte[] bytes = new byte[Integer.parseInt((($_JSON_Message_Voice_Client) my_json).getBytes().toLowerCase())];
                        dataInputStream.readFully(bytes);
                        $_Message message = new $_Message_Voice((($_JSON_Message_Voice_Client) my_json).getIdFrom(), (($_JSON_Message_Voice_Client) my_json).getUsername(), "6", (($_JSON_Message_Voice_Client) my_json).getTime(), 0, bytes);

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
                    my_json = new $_JSON_Change_Image_Successful("Change_Message_Successful", jsonObject.getString($_JSONAttributes.IdRecive.toString()), jsonObject.getBoolean($_JSONAttributes.Done.toString()), jsonObject.getString($_JSONAttributes.User_Name.toString()), jsonObject.getString($_JSONAttributes.Message.toString()));
                    $_JSON finalMy_json2 = my_json;

                    SecondActivity.fragmentActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if ((($_JSON_Change_Image_Successful) finalMy_json2).isDone()) {
                                Toast.makeText(SecondActivity.context, "Add Picture Successfully", Toast.LENGTH_SHORT).show();
                                System.out.println("AAAAAAccepted");
                                Thread thread = new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {

                                            DataInputStream dataInputStream = null;

                                            dataInputStream = new DataInputStream($_ClientStatic.getSocketMessage().getInputStream());
                                            byte[] bytes = new byte[Integer.parseInt((($_JSON_Change_Image_Successful) finalMy_json2).getBytes().toLowerCase())];
                                            dataInputStream.readFully(bytes);
                                            $_ClientStatic.setPersonalImage(bytes);

                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                                thread.start();



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
                                $_ClientStatic.getSharedPreferences().removeObject("id");
                                $_ClientStatic.getSharedPreferences().removeObject("username");
                                $_ClientStatic.getSharedPreferences().removeObject("password");
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
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            for (int i = 0; i < jsonArray_Ids.length(); i++) {


                                try {
                                    byte[] temp = new byte[jsonArray_lenthes.getInt(i)];
                                    System.out.println("Photo");
                                    $_ClientStatic.getDataInputStreamMessage().readFully(temp);
                                    photos.add(temp);

                                } catch (IOException e) {
                                    e.printStackTrace();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            ThirdActivity.fragmentActivity.runOnUiThread(new Runnable() {
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
                    my_json = new $_JSON_Accept_Friend_Respons("Accept_Friend_Response", jsonObject.getString($_JSONAttributes.IdRecive.toString()), jsonObject.getBoolean($_JSONAttributes.Done.toString()), jsonObject.getString($_JSONAttributes.Accept_Friend_Id.toString()), jsonObject.getString($_JSONAttributes.User_Name.toString()), jsonObject.getInt("ImageLength"));

                    $_JSON_Accept_Friend_Respons finalMy_json2 = ($_JSON_Accept_Friend_Respons) my_json;
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                DataInputStream dataInputStream = new DataInputStream($_ClientStatic.getSocketMessage().getInputStream());
                                bytes = new byte[finalMy_json2.getImagelenth()];
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
                    $_Value_Item_Main_Chat value_item_main_chat = new $_Value_Item_Main_Chat("null", finalMy_json2.getUser_name(), finalMy_json2.getId_user(), bytes, "client");

                    SecondActivity.fragmentActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            addChat(value_item_main_chat);
                            ThirdActivity.search_fragment.Edit_button(finalMy_json2.getId_user(), "Remove");
                            SecondActivity.friend_fragment.getValueItemFriends().add(new $_Value_Item_Friend(finalMy_json2.getId_user(), finalMy_json2.getUser_name(), "state", bytes));
                            SecondActivity.friend_fragment.getRecycleViewFriend().notifyDataSetChanged();
                            FiveActivity.value_item_create_groups.add(new $_Value_Item_Create_Group(finalMy_json2.getId_user(), finalMy_json2.getUser_name(), "state", bytes, false));

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
                                DataInputStream dataInputStream = new DataInputStream($_ClientStatic.getSocketMessage().getInputStream());
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
                    $_Value_Item_Main_Chat value_item_main_chat = new $_Value_Item_Main_Chat("null", (($_JSON_Friend_Accept_Response) finalMy_json6).getUser_name(), (($_JSON_Friend_Accept_Response) finalMy_json6).getId_user(), bytes, "client");
                    SecondActivity.fragmentActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            addChatFriend(value_item_main_chat);
                            SecondActivity.friend_fragment.getValueItemFriends().add(new $_Value_Item_Friend(finalMy_json3.getId_user(), finalMy_json3.getUser_name(), "state", bytes));
                            SecondActivity.friend_fragment.getRecycleViewFriend().notifyDataSetChanged();
                            FiveActivity.value_item_create_groups.add(new $_Value_Item_Create_Group(finalMy_json3.getId_user(), finalMy_json3.getUser_name(), "state", bytes, false));

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
                            $_Value_Item_Main_Chat value_item_main_chat = ($_Value_Item_Main_Chat) getValueItemMainChat(finalMy_json4.getId_user());
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
                            $_Value_Item_Main_Chat value_item_main_chat = ($_Value_Item_Main_Chat) getValueItemMainChat(finalMy_json8.getId_user());
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
                case "Online_Friends_Response": {
                    JSONArray jsonArray_Ids = jsonObject.getJSONArray("Ids");
                    JSONArray jsonArray_OnlineState = jsonObject.getJSONArray("OnlineState");
                    ArrayList<String> Ids = new ArrayList<>();
                    ArrayList<String> OnlineState = new ArrayList<>();
                    for (int i = 0; i < jsonArray_Ids.length(); i++) {
                        Ids.add(jsonArray_Ids.getString(i));
                        OnlineState.add(jsonArray_OnlineState.getString(i));
                    }
                    System.out.println("MMMMM");

                    my_json = new $_JSON_Online_Friend_Respons("Online_Friends_Response", jsonObject.getString($_JSONAttributes.IdRecive.toString()), true, Ids, OnlineState);
                    SecondActivity.fragmentActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("MMMMM");

                            SecondActivity.onlineFriendFragment.add_Online(Ids, OnlineState);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        secondActivity = new SecondActivity();
        thirdActivity = new ThirdActivity();
        fourActivity = new FourActivity();
        fiveActivity = new FiveActivity(1);
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
        store_message_group = new $_Store_Message_Group(new $_ChatMessageGroupMangment());
        store_my_account = new $_Store_My_Account(new $_MyAccountStorgeMangement());
        $_ClientStatic.setSharedPreferences(new $_SharedPreferences("RememberMe"));
        /*$_ClientStatic.getSharedPreferences().removeObject("id");
        $_ClientStatic.getSharedPreferences().removeObject("username");
        $_ClientStatic.getSharedPreferences().removeObject("password");*/
        //messages = new ArrayList<>();
        if (findViewById(R.id.container_main) != null) {
            if (savedInstanceState != null) return;
            if ($_ClientStatic.getSharedPreferences().isExist("id") == "") {
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
                            $_ClientStatic client = new $_ClientStatic(context);
                            send_Sign_In();
                            $_ClientStatic.setCheckOnline(new $_CheckOnline($_ClientStatic.getEmail(), "Check", "online"));
                            //  }
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
        String email = $_ClientStatic.getSharedPreferences().getObject("id");
        String username = $_ClientStatic.getSharedPreferences().getObject("username");
        String password = $_ClientStatic.getSharedPreferences().getObject("password");
        if (email != null) {
            try {
                $_JSON_login json_login = new $_JSON_login(
                        "Login_User",
                        email,
                        password,
                        "UserName : Login"
                );
                $_SendData sendData = new $_SendData(json_login, "Login_User");
                sendData.excute();
                $_ClientStatic.getDataOutputStreamMessage().writeUTF(sendData.getJson_object().toString());
                $_ClientStatic.setEmail(email);

                final $_CheckReciveData checkReciveData = new $_CheckReciveData();
                checkReciveData.excute();
                if (checkReciveData.getResult() != null) {
                    Decode_JSON(checkReciveData);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.err.println("error send data sign up");
            }

        } else {

        }

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private static List<Integer> fill_length_photo(JSONObject jsonObject) {
        try {
            JSONArray L_photo = new JSONArray(jsonObject.getString("length_photo"));
            List<Integer> temp_length_photo = new ArrayList<>();
            for (int i = 0; i < L_photo.length(); i++) {
                temp_length_photo.add(L_photo.getInt(i));
            }
            return temp_length_photo;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

    private static List<$_Group> fill_groups(JSONObject jsonObject, List<byte[]> bytes1) {
        try {
            List<$_Group> temp_group = new ArrayList<>();
            JSONArray all_group = new JSONArray(jsonObject.getString($_JSONAttributes.Group.toString()));
            JSONArray group_information = new JSONArray(all_group.getString(0));
            JSONArray groups_clients_information_for_all = new JSONArray(all_group.getString(1));
            for (int i = 0; i < group_information.length(); i++) {
                JSONObject information = new JSONObject(group_information.getString(i));
                $_GroupInformation inf = new $_GroupInformation(
                        information.getString($_JSONAttributes.State.toString()),
                        bytes1.get(0), "name",
                        information.getString($_JSONAttributes.IdGroup.toString()),
                        information.getString($_JSONAttributes.User_Name.toString()));

                List<$_AccountInformation> accountInformations = new ArrayList<>();
                JSONArray groups_clients_information_for_one = new JSONArray(groups_clients_information_for_all.getString(i));

                for (int j = 0; j < groups_clients_information_for_one.length(); j++) {
                    JSONObject clientinfo = new JSONObject(groups_clients_information_for_one.getString(j));
                    accountInformations.add(new $_AccountInformationById(
                            clientinfo.getString($_JSONAttributes.IdRecive.toString()),
                            clientinfo.getString($_JSONAttributes.State.toString()),
                            bytes1.get(j + 1),
                            clientinfo.getString($_JSONAttributes.User_Name.toString()),
                            clientinfo.getString($_JSONAttributes.Password.toString())));
                }
                $_Group group = new $_Group(inf, accountInformations);
                temp_group.add(group);
            }
            return temp_group;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;

        }
    }

    private static $_Group fill_group(JSONObject jsonObject, List<byte[]> bytes1) {
        try {
            JSONArray all_group = new JSONArray(jsonObject.getString($_JSONAttributes.Group.toString()));
            JSONObject group_information = new JSONObject(all_group.getString(0));

            JSONArray groups_clients_information_for_all = new JSONArray(all_group.getString(1));

            $_GroupInformation inf = new $_GroupInformation(
                    group_information.getString($_JSONAttributes.State.toString()),
                    bytes1.get(0),
                    "name",
                    group_information.getString($_JSONAttributes.IdGroup.toString()),
                    group_information.getString($_JSONAttributes.User_Name.toString()));


            List<$_AccountInformation> accountInformations = new ArrayList<>();

            for (int j = 0; j < groups_clients_information_for_all.length(); j++) {
                JSONObject clientinfo = new JSONObject(groups_clients_information_for_all.getString(j));
                accountInformations.add(new $_AccountInformationById(
                        clientinfo.getString($_JSONAttributes.IdRecive.toString()),
                        clientinfo.getString($_JSONAttributes.State.toString()),
                        bytes1.get(j + 1),
                        clientinfo.getString($_JSONAttributes.User_Name.toString()),
                        clientinfo.getString($_JSONAttributes.Password.toString())));
            }
            $_Group group = new $_Group(inf, accountInformations);
            return group;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;

        }
    }

    private static $_Abstruct_Value_Item_Main_Chat getValueItemMainChat(String id_user) {
        for ($_Abstruct_Value_Item_Main_Chat value_item_main_chat : main_chat_fragment.rooms) {
            if (value_item_main_chat.getEmail().equals(id_user)) {
                return value_item_main_chat;
            }
        }
        return null;
    }

    public static void addChatFriend($_Abstruct_Value_Item_Main_Chat abstruct_value_item_main_chat) {
        if (abstruct_value_item_main_chat instanceof $_Value_Item_Main_Chat) {

            //FragmentTransaction fragmentTransaction = SecondActivity.fragmentActivity.getSupportFragmentManager().beginTransaction();
            //fragmentTransaction.add(R.id.container_main_second, room_chat).addToBackStack(null).hide(room_chat).addToBackStack(null).commitAllowingStateLoss();
            main_chat_fragment.rooms.add(abstruct_value_item_main_chat);
            recycle_view_main_chat.addItemDecoration(new DividerItemDecoration(SecondActivity.context,
                    DividerItemDecoration.VERTICAL));
            main_chat_fragment.recycleAdapter.notifyDataSetChanged();
            List<$_Message> list = new ArrayList();
            MainActivity.allMessages.put(abstruct_value_item_main_chat.getEmail(), new Pair<>(new $_Recycle_View_Room_Chat_Adapter(list, FourActivity.context), list));

            //MainActivity.allMessages.put(value_item_main_chat.getEmail(),new ArrayList<>());
        } else {

            //FragmentTransaction fragmentTransaction = SecondActivity.fragmentActivity.getSupportFragmentManager().beginTransaction();
            //fragmentTransaction.add(R.id.container_main_second, room_chat).addToBackStack(null).hide(room_chat).addToBackStack(null).commitAllowingStateLoss();
            main_chat_fragment.rooms.add(abstruct_value_item_main_chat);
            recycle_view_main_chat.addItemDecoration(new DividerItemDecoration(SecondActivity.context,
                    DividerItemDecoration.VERTICAL));
            main_chat_fragment.recycleAdapter.notifyDataSetChanged();
            List<$_Message> list = new ArrayList();
            MainActivity.allMessages.put(abstruct_value_item_main_chat.getEmail(), new Pair<>(new $_Recycle_View_Room_Chat_Adapter(list, FourActivity.context), list));

            //MainActivity.allMessages.put(value_item_main_chat.getEmail(),new ArrayList<>());
        }

    }

    public static void addChat($_Abstruct_Value_Item_Main_Chat abstruct_value_item_main_chat) {
        //FragmentTransaction fragmentTransaction = SecondActivity.fragmentActivity.getSupportFragmentManager().beginTransaction();
        //fragmentTransaction.add(R.id.container_main_second, room_chat).hide(room_chat).addToBackStack(null).commitAllowingStateLoss();
        if (abstruct_value_item_main_chat instanceof $_Value_Item_Main_Chat) {
            main_chat_fragment.rooms.add(abstruct_value_item_main_chat);
            recycle_view_main_chat.addItemDecoration(new DividerItemDecoration(SecondActivity.context,
                    DividerItemDecoration.VERTICAL));
            main_chat_fragment.recycleAdapter.notifyDataSetChanged();
            List<$_Message> list = new ArrayList();
            MainActivity.allMessages.put(abstruct_value_item_main_chat.getEmail(), new Pair<>(new $_Recycle_View_Room_Chat_Adapter(list, FourActivity.context), list));
            //MainActivity.allMessages.put(value_item_main_chat.getEmail(),new ArrayList<>());
        } else {
            main_chat_fragment.rooms.add(abstruct_value_item_main_chat);
            recycle_view_main_chat.addItemDecoration(new DividerItemDecoration(SecondActivity.context,
                    DividerItemDecoration.VERTICAL));
            main_chat_fragment.recycleAdapter.notifyDataSetChanged();
            List<$_Message> list = new ArrayList();
            System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE === " + abstruct_value_item_main_chat.getEmail());
            MainActivity.allMessages.put(abstruct_value_item_main_chat.getEmail(), new Pair<>(new $_Recycle_View_Room_Chat_Adapter(list, FourActivity.context), list));
            //MainActivity.allMessages.put(value_item_main_chat.getEmail(),new ArrayList<>());
        }

    }

    public static ArrayList<String> getFriends(String path) {
        File all_friend = new File(path);
        $_FriendInfo friendInfo;
        ArrayList<String> temp = new ArrayList<>();
        for (File temp_file : all_friend.listFiles()) {
            friendInfo = ($_FriendInfo) MainActivity.store_friend.retriveFriend(temp_file.getName());
            temp.add(friendInfo.getId());
        }

        return temp;
    }

    public static void getOnline() {


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {

                        Thread.sleep(15000);
                        ArrayList<String> friends = getFriends(FriendPathMangment.FriendPath + "/");
                        JSONObject jsonObject1 = new JSONObject();
                        jsonObject1.put($_JSONAttributes.Type.toString(), "Online_Friends");
                        jsonObject1.put($_JSONAttributes.Id.toString(), $_ClientStatic.getEmail());
                        jsonObject1.put($_JSONAttributes.User_Name.toString(), $_ClientStatic.getUserName());
                        jsonObject1.put("Friends", new JSONArray(friends));
                        $_ClientStatic.getDataOutputStreamMessage().writeUTF(jsonObject1.toString());
                        $_ClientStatic.getDataOutputStreamMessage().flush();
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


}