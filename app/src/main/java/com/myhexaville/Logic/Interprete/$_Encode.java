package com.myhexaville.Logic.Interprete;

import com.myhexaville.Logic.Client.$_ClientStatic;
import com.myhexaville.Logic.JSONData.$_JSON;
import com.myhexaville.Logic.JSONData.$_JSONAttributes;
import com.myhexaville.Logic.JSONData.$_JSON_Accept_Friend;
import com.myhexaville.Logic.JSONData.$_JSON_Add_Friend;
import com.myhexaville.Logic.JSONData.$_JSON_Change_Image;
import com.myhexaville.Logic.JSONData.$_JSON_Check_Online;
import com.myhexaville.Logic.JSONData.$_JSON_Create_Group;
import com.myhexaville.Logic.JSONData.$_JSON_Message_Image_Client;
import com.myhexaville.Logic.JSONData.$_JSON_Message_Image_Group;
import com.myhexaville.Logic.JSONData.$_JSON_Message_Text_Client;
import com.myhexaville.Logic.JSONData.$_JSON_Message_Text_Group;
import com.myhexaville.Logic.JSONData.$_JSON_Message_Voice_Client;
import com.myhexaville.Logic.JSONData.$_JSON_Refusal_Friend;
import com.myhexaville.Logic.JSONData.$_JSON_Remove_Friend;
import com.myhexaville.Logic.JSONData.$_JSON_Remove_Group;
import com.myhexaville.Logic.JSONData.$_JSON_Remove_Request;
import com.myhexaville.Logic.JSONData.$_JSON_Search_User;
import com.myhexaville.Logic.JSONData.$_JSON_SignUp;
import com.myhexaville.Logic.JSONData.$_JSON_SignUp_Tow;
import com.myhexaville.Logic.JSONData.$_JSON_login;
import com.myhexaville.Logic.Room.$_Group;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 */
public class $_Encode extends $_Interprete {

    /**
     * Default constructor
     */
    public $_Encode($_JSON my_json, String type) {
        this.my_json = my_json;
        this.type = type;
    }


    public void run() {
        this.json_object = new JSONObject();
        try {

            switch (type) {
                case "Check": {
                    $_JSON_Check_Online json_check_online = ($_JSON_Check_Online) my_json;
                    json_object.put($_JSONAttributes.Id.toString(), json_check_online.getIdFrom());
                    json_object.put($_JSONAttributes.Type.toString(), json_check_online.getType());
                    json_object.put("Value", json_check_online.getValue());
                    break;
                }

                case "Login_User": {
                    $_JSON_login json_login = ($_JSON_login) my_json;
                    json_object.put($_JSONAttributes.Type.toString(), json_login.getType());
                    json_object.put($_JSONAttributes.Id.toString(), json_login.getIdFrom());
                    json_object.put($_JSONAttributes.Password.toString(), json_login.getPassword());
                    break;
                }

                case "Sign_Up": {
                    $_JSON_SignUp json_signUp = ($_JSON_SignUp) my_json;
                    json_object.put($_JSONAttributes.Type.toString(), json_signUp.getType());
                    json_object.put($_JSONAttributes.Id.toString(), json_signUp.getIdFrom());
                    json_object.put($_JSONAttributes.Password.toString(), json_signUp.getPassword());
                    json_object.put($_JSONAttributes.User_Name.toString(), json_signUp.getUser_name());
                    break;
                }

                case "Sign_Up_Tow": {
                    $_JSON_SignUp_Tow json_signUp_tow = ($_JSON_SignUp_Tow) my_json;
                    json_object.put($_JSONAttributes.Type.toString(), json_signUp_tow.getType());
                    json_object.put($_JSONAttributes.Id.toString(), json_signUp_tow.getIdFrom());
                    json_object.put($_JSONAttributes.State.toString(), json_signUp_tow.getState());
                    //jsonObject.put($_JSONAttributes.Message.toString(), bytes.length);
                    break;
                }

                case "Change_Image": {
                    $_JSON_Change_Image json_change_image = ($_JSON_Change_Image) my_json;
                    json_object.put($_JSONAttributes.Id.toString(), json_change_image.getIdFrom());
                    json_object.put($_JSONAttributes.Type.toString(), json_change_image.getType());
                    json_object.put($_JSONAttributes.User_Name.toString(), json_change_image.getUser_name());
                    json_object.put($_JSONAttributes.Message.toString(), json_change_image.getBytes());
                    break;
                }

                case "Message_Text": {
                    $_JSON_Message_Text_Client json_message_text_client = ($_JSON_Message_Text_Client) my_json;
                    json_object.put($_JSONAttributes.Id.toString(), json_message_text_client.getIdFrom());
                    json_object.put("Time", json_message_text_client.getTime());
                    json_object.put($_JSONAttributes.User_Name.toString(), json_message_text_client.getUsername());
                    json_object.put("Message", json_message_text_client.getMessage());
                    json_object.put("MType", json_message_text_client.getMType());
                    json_object.put($_JSONAttributes.Type.toString(), json_message_text_client.getType());
                    json_object.put($_JSONAttributes.IdRecive.toString(), json_message_text_client.getIdTo());
                    break;
                }

                case "Message_Text_Group": {
                    $_JSON_Message_Text_Group json_message_text_group = ($_JSON_Message_Text_Group) my_json;
                    json_object.put($_JSONAttributes.Id.toString(), json_message_text_group.getIdFrom());
                    json_object.put("Time", json_message_text_group.getTime());
                    json_object.put($_JSONAttributes.User_Name.toString(), json_message_text_group.getUsername());
                    json_object.put("Message", json_message_text_group.getMessage());
                    json_object.put("MType", json_message_text_group.getMType());
                    json_object.put($_JSONAttributes.Type.toString(), json_message_text_group.getType());
                    JSONArray json_clients_ids = new JSONArray();
                    for (int i = 0; i < json_message_text_group.getIdTos().size(); i++) {
                        json_clients_ids.put($_ClientStatic.getIdsRecived().get(i));
                    }
                    json_object.put($_JSONAttributes.IdRecive.toString(), json_clients_ids.toString());
                    json_object.put($_JSONAttributes.IdGroup.toString(), json_message_text_group.getIdGroup());
                    break;
                }

                case "Message_Image": {
                    $_JSON_Message_Image_Client json_message_image_client = ($_JSON_Message_Image_Client) my_json;
                    json_object.put($_JSONAttributes.Type.toString(), json_message_image_client.getType());
                    json_object.put($_JSONAttributes.Id.toString(), json_message_image_client.getIdFrom());
                    json_object.put($_JSONAttributes.IdRecive.toString(), json_message_image_client.getIdTo());
                    json_object.put($_JSONAttributes.User_Name.toString(), json_message_image_client.getUsername());
                    json_object.put("Time", json_message_image_client.getTime());
                    // String s = Base64.encodeToString(bytes, Base64.DEFAULT);
                    json_object.put("Message", json_message_image_client.getBytes());
                    json_object.put("MType", json_message_image_client.getMType());
                    break;
                }

                case "Message_Image_Group": {
                    $_JSON_Message_Image_Group json_message_image_group = ($_JSON_Message_Image_Group) my_json;
                    json_object.put($_JSONAttributes.Type.toString(), json_message_image_group.getType());
                    json_object.put($_JSONAttributes.Id.toString(), json_message_image_group.getIdFrom());
                    JSONArray json_clients_ids = new JSONArray();
                    for (int i = 0; i < json_message_image_group.getIdTos().size(); i++) {
                        json_clients_ids.put(json_message_image_group.getIdTos().get(i));
                    }
                    json_object.put($_JSONAttributes.IdRecive.toString(), json_clients_ids.toString());
                    json_object.put($_JSONAttributes.User_Name.toString(), json_message_image_group.getUsername());
                    json_object.put("Time", json_message_image_group.getTime());
                    // String s = Base64.encodeToString(bytes, Base64.DEFAULT);
                    json_object.put("Message", json_message_image_group.getBytes());
                    json_object.put("MType", json_message_image_group.getMType());
                    json_object.put($_JSONAttributes.IdGroup.toString(), $_ClientStatic.idGroup);
                    break;
                }
                case "Message_Voice": {
                    $_JSON_Message_Voice_Client json_message_voice_client = ($_JSON_Message_Voice_Client) my_json;
                    json_object.put($_JSONAttributes.Id.toString(), json_message_voice_client.getIdFrom());
                    json_object.put($_JSONAttributes.IdRecive.toString(), json_message_voice_client.getIdTo());
                    json_object.put($_JSONAttributes.Type.toString(), json_message_voice_client.getType());
                    json_object.put("Time", json_message_voice_client.getTime());
                    json_object.put($_JSONAttributes.User_Name.toString(), json_message_voice_client.getUsername());
                    json_object.put("MType", json_message_voice_client.getMType());
                    json_object.put("Message", json_message_voice_client.getBytes());
                    break;
                }

                case "Create_Group": {
                    $_JSON_Create_Group json_create_group = ($_JSON_Create_Group) my_json;
                    json_object.put($_JSONAttributes.Type.toString(), json_create_group.getType());
                    json_object.put($_JSONAttributes.Id.toString(), json_create_group.getIdFrom());
                    JSONArray jsonArray = createJSONObject(json_create_group.getGroup());
                    json_object.put($_JSONAttributes.Group.toString(), jsonArray.toString());
                    break;
                }

                case "Remove_Group": {
                    $_JSON_Remove_Group json_remove_group = ($_JSON_Remove_Group) my_json;
                    JSONArray json_client_id = new JSONArray();

                    for (int i = 0; i < json_remove_group.getClients_id().size(); i++) {
                        JSONObject one_id = new JSONObject();
                        try {
                            one_id.put($_JSONAttributes.Id.toString(), json_remove_group.getClients_id().get(i));
                            json_client_id.put(one_id.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    json_object.put($_JSONAttributes.Type.toString(), json_remove_group.getType());
                    json_object.put($_JSONAttributes.Id.toString(), json_remove_group.getIdFrom());
                    json_object.put($_JSONAttributes.IdGroup.toString(), json_remove_group.getIdGroup());
                    json_object.put($_JSONAttributes.Client_Group.toString(), json_client_id.toString());
                    break;
                }

                case "Search_Of_User": {
                    $_JSON_Search_User json_search_user = ($_JSON_Search_User) my_json;
                    json_object.put($_JSONAttributes.Type.toString(), json_search_user.getType());
                    json_object.put($_JSONAttributes.Id.toString(), json_search_user.getIdFrom());
                    json_object.put($_JSONAttributes.Search_User.toString(), json_search_user.getSearch_User());
                    break;
                }

                case "Refusal_friend": {
                    $_JSON_Refusal_Friend json_refusal_friend = ($_JSON_Refusal_Friend) my_json;

                    json_object.put($_JSONAttributes.Type.toString(), json_refusal_friend.getType());
                    json_object.put($_JSONAttributes.Id.toString(), json_refusal_friend.getIdFrom());
                    json_object.put($_JSONAttributes.Refusal_Friend_Id.toString(), json_refusal_friend.getIdTo());
                    json_object.put($_JSONAttributes.user_friend_request.toString(), json_refusal_friend.getUser_friend_request());
                    json_object.put($_JSONAttributes.User_Name.toString(), json_refusal_friend.getUser_name());
                    break;
                }

                case "Add_friend": {
                    $_JSON_Add_Friend json_add_friend = ($_JSON_Add_Friend) my_json;
                    json_object.put($_JSONAttributes.Type.toString(), json_add_friend.getType());
                    json_object.put($_JSONAttributes.Id.toString(), json_add_friend.getIdFrom());
                    json_object.put($_JSONAttributes.Add_Friend_Id.toString(), json_add_friend.getIdTo());
                    json_object.put($_JSONAttributes.user_friend_request.toString(), json_add_friend.getUser_friend_request());
                    json_object.put($_JSONAttributes.User_Name.toString(), json_add_friend.getUser_name());

                    break;
                }

                case "Remove_Friend": {
                    $_JSON_Remove_Friend json_remove_friend = ($_JSON_Remove_Friend) my_json;
                    json_object.put($_JSONAttributes.Type.toString(), json_remove_friend.getType());
                    json_object.put($_JSONAttributes.Id.toString(), json_remove_friend.getIdFrom());
                    json_object.put($_JSONAttributes.Remove_Friend_Id.toString(), json_remove_friend.getIdTo());
                    json_object.put($_JSONAttributes.user_friend_request.toString(), json_remove_friend.getUser_friend_request());
                    json_object.put($_JSONAttributes.User_Name.toString(), json_remove_friend.getUser_name());
                    break;
                }

                case "Remove_Request": {
                    $_JSON_Remove_Request json_remove_request = ($_JSON_Remove_Request) my_json;
                    json_object.put($_JSONAttributes.Type.toString(), json_remove_request.getType());
                    json_object.put($_JSONAttributes.Id.toString(), json_remove_request.getIdFrom());
                    json_object.put($_JSONAttributes.Remove_Request_Id.toString(), json_remove_request.getIdTo());
                    json_object.put($_JSONAttributes.user_friend_request.toString(), json_remove_request.getUser_friend_request());
                    json_object.put($_JSONAttributes.User_Name.toString(), json_remove_request.getUser_name());

                    break;
                }

                case "Accept_Friend": {
                    $_JSON_Accept_Friend json_accept_friend = ($_JSON_Accept_Friend) my_json;
                    json_object.put($_JSONAttributes.Type.toString(), json_accept_friend.getType());
                    json_object.put($_JSONAttributes.Id.toString(), json_accept_friend.getIdFrom());
                    json_object.put($_JSONAttributes.Accept_Friend_Id.toString(), json_accept_friend.getIdTo());
                    json_object.put($_JSONAttributes.user_friend_request.toString(), json_accept_friend.getUser_friend_request());
                    json_object.put($_JSONAttributes.User_Name.toString(), json_accept_friend.getUser_name());
                    break;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private JSONArray createJSONObject($_Group group) {
        // Information Of Group
        JSONArray groups_clients_information_for_one = new JSONArray();
        JSONObject item_group_information = new JSONObject();
        try {
            item_group_information.
                    put($_JSONAttributes.User_Name.toString(), group.getGroup_information().getUser_name()).
                    put($_JSONAttributes.State.toString(), group.getGroup_information().getState()).
                    put($_JSONAttributes.IdGroup.toString(), group.getGroup_information().getID()).
                    put($_JSONAttributes.Message.toString(), group.getGroup_information().getPicture().length);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        //Client for group
        for (int j = 0; j < group.getClients().size(); j++) {
            JSONObject item_client_information = new JSONObject();
            try {
                item_client_information.put($_JSONAttributes.User_Name.toString(), group.getClients().get(j).getUser_name()).
                        put($_JSONAttributes.State.toString(), group.getClients().get(j).getState()).
                        put($_JSONAttributes.Id.toString(), group.getClients().get(j).getID()).
                        put($_JSONAttributes.Password.toString(), group.getClients().get(j).getPassword()).
                        put($_JSONAttributes.Message.toString(), group.getClients().get(j).getPicture().length);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            groups_clients_information_for_one.put(item_client_information.toString());
        }
        JSONArray all_group = new JSONArray();
        all_group.put(item_group_information.toString());
        all_group.put(groups_clients_information_for_one.toString());
        return all_group;
    }


}