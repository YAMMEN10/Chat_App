package com.myhexaville.UI.Adapter.AdapterMainChat.Client_Room;

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
import com.myhexaville.UI.Adapter.AdapterMainChat.$_Abstruct_Holder;
import com.myhexaville.login.FourActivity;
import com.myhexaville.login.R;
import com.myhexaville.login.SecondActivity;

import static com.myhexaville.UI.Chat.MainFragment.MainChat.main_chat_fragment.rooms;

public class $_Holder_Client extends $_Abstruct_Holder {
    public $_Holder_Client(@NonNull View itemView) {
        super(itemView);
        abstruct_item_main_chat = new $_Item_Main_Chat(itemView);
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
            if (abstruct_item_main_chat.getId_popup_menu().getTag().equals("client_item")) {
                //creating a popup menu
                PopupMenu popup = new PopupMenu(SecondActivity.context, v);
                //inflating menu from xml resource
                popup.inflate(R.menu.popup_menu_client);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getTitle().toString()) {
                            case "view profile": {

                                break;
                            }
                            case "remove friend": {

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
            }
        } else {
            //Toast.makeText(v.getContext(), "ROW PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
            $_ClientStatic.idRecived = rooms.get(getAdapterPosition()).getEmail();
            Intent intent = new Intent(SecondActivity.context, FourActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("Type", "ClientChat");
            $_ClientStatic.setType("ClientChat");
            intent.putExtras(bundle);
            SecondActivity.fragmentActivity.startActivity(intent);
        }

    }
}
