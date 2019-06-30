package com.myhexaville.Logic.Friend;

import com.myhexaville.Logic.Client.$_ClientStatic;
import com.myhexaville.Logic.JSONData.$_JSONAttributes;
import com.myhexaville.Logic.JSONData.$_JSON_Accept_Friend;
import com.myhexaville.Logic.JSONData.$_JSON_Add_Friend;
import com.myhexaville.Logic.JSONData.$_JSON_Refusal_Friend;
import com.myhexaville.Logic.JSONData.$_JSON_Remove_Friend;
import com.myhexaville.Logic.JSONData.$_JSON_Remove_Request;
import com.myhexaville.Logic.ServerManagment.$_SendData;

import org.json.JSONException;

import java.io.IOException;

public class Friendship_sender {

    public void send_To(final String id, String username, byte[] image, final String Type, final String Type_ID) {
        try {
            $_SendData sendData = null;
            if (Type.equals($_JSONAttributes.Refusal_friend.toString())) {
                $_JSON_Refusal_Friend json_refusal_friend = new $_JSON_Refusal_Friend(
                        Type,
                        $_ClientStatic.getEmail(),
                        $_ClientStatic.getUserName(),
                        username,
                        id
                );
                sendData = new $_SendData(json_refusal_friend, Type);


            } else if (Type.equals($_JSONAttributes.Add_friend.toString())) {
                $_JSON_Add_Friend json_add_friend = new $_JSON_Add_Friend(
                        Type,
                        $_ClientStatic.getEmail(),
                        $_ClientStatic.getUserName(),
                        username,
                        id
                );
                sendData = new $_SendData(json_add_friend, Type);


            } else if (Type.equals($_JSONAttributes.Remove_Friend.toString())) {
                $_JSON_Remove_Friend json_remove_friend = new $_JSON_Remove_Friend(
                        Type,
                        $_ClientStatic.getEmail(),
                        $_ClientStatic.getUserName(),
                        username,
                        id
                );
                sendData = new $_SendData(json_remove_friend, Type);


            } else if (Type.equals($_JSONAttributes.Remove_Request.toString())) {
                $_JSON_Remove_Request json_remove_request = new $_JSON_Remove_Request(
                        Type,
                        $_ClientStatic.getEmail(),
                        $_ClientStatic.getUserName(),
                        username,
                        id
                );
                sendData = new $_SendData(json_remove_request, Type);

            } else if (Type.equals($_JSONAttributes.Accept_Friend.toString())) {
                $_JSON_Accept_Friend json_accept_friend = new $_JSON_Accept_Friend(
                        Type,
                        $_ClientStatic.getEmail(),
                        $_ClientStatic.getUserName(),
                        username,
                        id
                );
                sendData = new $_SendData(json_accept_friend, Type);

            }
            sendData.excute();
            $_SendData finalSendData = sendData;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        $_ClientStatic.getDataOutputStreamMessage().writeUTF(finalSendData.getJson_object().toString());
                        // $_Client.getDataOutputStreamMessage().write(image);
                        //$_Client.getDataOutputStreamMessage().flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });
            thread.start();
            thread.join();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    //   if (Type.equals($_JSONAttributes.Accept_Friend.toString())) {


}
           /* } else {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            $_ClientStatic.getDataOutputStreamMessage().writeUTF(jsonObject1.toString());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });
                thread.start();
                thread.join();

            }


        } catch (JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}*/
