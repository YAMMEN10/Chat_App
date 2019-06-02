package com.myhexaville.Logic.Friend;

import com.myhexaville.Logic.Client.$_Client;
import com.myhexaville.Logic.JSONData.$_JSONAttributes;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Friendship_sender {

    public void send_To(final String id, String username, byte[] image, final String Type, final String Type_ID) {
        try {
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put($_JSONAttributes.Type.toString(), Type);
            jsonObject1.put($_JSONAttributes.Id.toString(), $_Client.getEmail());
            jsonObject1.put(Type_ID, id);
            jsonObject1.put($_JSONAttributes.user_friend_request.toString(), username);
            jsonObject1.put($_JSONAttributes.User_Name.toString(), $_Client.getUserName());
            if (Type.equals($_JSONAttributes.Accept_Friend.toString())) {
                jsonObject1.put($_JSONAttributes.Message.toString(), image.length);


                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            $_Client.getDataOutputStreamMessage().writeUTF(jsonObject1.toString());
                            $_Client.getDataOutputStreamMessage().write(image);
                            $_Client.getDataOutputStreamMessage().flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });
                thread.start();
                thread.join();
            } else {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            $_Client.getDataOutputStreamMessage().writeUTF(jsonObject1.toString());
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
}
