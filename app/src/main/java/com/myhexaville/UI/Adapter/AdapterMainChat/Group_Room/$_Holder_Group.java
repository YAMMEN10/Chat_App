package com.myhexaville.UI.Adapter.AdapterMainChat.Group_Room;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.github.chrisbanes.photoview.PhotoView;
import com.myhexaville.Logic.Client.$_ClientStatic;
import com.myhexaville.Logic.JSONData.$_JSONAttributes;
import com.myhexaville.UI.Adapter.AdapterMainChat.$_Abstruct_Holder;
import com.myhexaville.login.FourActivity;
import com.myhexaville.login.R;
import com.myhexaville.login.SecondActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import static com.myhexaville.UI.Chat.MainFragment.MainChat.main_chat_fragment.rooms;

public class $_Holder_Group extends $_Abstruct_Holder {
    public $_Holder_Group(@NonNull View itemView) {
        super(itemView);
        abstruct_item_main_chat = new $_Item_Main_Chat_Group(itemView);
        initAction();

    }

    private void initAction() {
        itemView.setOnClickListener(this::onClick);
        abstruct_item_main_chat.getRecycle_view_main_chat_image().setOnClickListener(this::onClick);
        abstruct_item_main_chat.getId_popup_menu().setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == abstruct_item_main_chat.getRecycle_view_main_chat_image().getId()) {
            //Toast.makeText(v.getContext(), "ITEM PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(SecondActivity.fragmentActivity);
            View mView = SecondActivity.fragmentActivity.getLayoutInflater().inflate(R.layout.dialog_custom_layout, null);
            PhotoView photoView = mView.findViewById(R.id.imageView);
            Bitmap bmp = BitmapFactory.decodeByteArray(rooms.get(getAdapterPosition()).getImage(), 0, rooms.get(getAdapterPosition()).getImage().length);
            photoView.setImageBitmap(bmp);
            mBuilder.setView(mView);
            AlertDialog mDialog = mBuilder.create();
            mDialog.show();

        } else if (v.getId() == abstruct_item_main_chat.getId_popup_menu().getId()) {
            //creating a popup menu
            PopupMenu popup = new PopupMenu(SecondActivity.context, v);
            //inflating menu from xml resource
            popup.inflate(R.menu.popup_menu_group);
            //adding click listener
            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getTitle().toString()) {
                        case "view profile group": {

                            break;
                        }
                        case "remove group": {
                            JSONObject jsonObject = new JSONObject();
                            JSONArray json_client_id = new JSONArray();
                            $_Value_Item_Main_Chat_Group value_item_main_chat_group = ($_Value_Item_Main_Chat_Group) rooms.get(getAdapterPosition());
                            for (int i = 0; i < value_item_main_chat_group.getAccountInformations().size(); i++) {
                                JSONObject one_id = new JSONObject();
                                try {
                                    one_id.put($_JSONAttributes.Id.toString(), value_item_main_chat_group.getAccountInformations().get(i).getID());
                                    json_client_id.put(one_id.toString());
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            try {
                                jsonObject.
                                        put($_JSONAttributes.Type.toString(), "Remove_Group").
                                        put($_JSONAttributes.Id.toString(), $_ClientStatic.getEmail()).
                                        put($_JSONAttributes.IdGroup.toString(), rooms.get(getAdapterPosition()).getEmail()).
                                        put($_JSONAttributes.Client_Group.toString(), json_client_id.toString());
                                Thread thread = new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            $_ClientStatic.getDataOutputStreamMessage().writeUTF(jsonObject.toString());
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

                            break;
                        }
                        case "Cancel": {

                            break;
                        }
                    }
                    return true;
                }
            });
            //displaying the popup
            popup.show();
        } else {
            //Toast.makeText(v.getContext(), "ROW PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
            $_ClientStatic.setIdsRecived(new ArrayList<>());
            for (int i = 0; i < (($_Value_Item_Main_Chat_Group) rooms.get(getAdapterPosition())).getAccountInformations().size(); i++) {
                $_ClientStatic.getIdsRecived().add((($_Value_Item_Main_Chat_Group) rooms.get(getAdapterPosition())).getAccountInformations().get(i).getID());
            }
            $_ClientStatic.setIdGroup((($_Value_Item_Main_Chat_Group) rooms.get(getAdapterPosition())).getGroupInformation().getID());
            Intent intent = new Intent(SecondActivity.context, FourActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("Type", "GroupChat");
            $_ClientStatic.setType("GroupChat");
            intent.putExtras(bundle);
            SecondActivity.fragmentActivity.startActivity(intent);
        }

    }
}