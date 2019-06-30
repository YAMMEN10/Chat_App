package com.myhexaville.UI.Adapter.AdapterMainChat;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.myhexaville.UI.Adapter.AdapterMainChat.Client_Room.$_Holder_Client;
import com.myhexaville.UI.Adapter.AdapterMainChat.Client_Room.$_Value_Item_Main_Chat;
import com.myhexaville.UI.Adapter.AdapterMainChat.Group_Room.$_Holder_Group;
import com.myhexaville.UI.Adapter.AdapterMainChat.Group_Room.$_Value_Item_Main_Chat_Group;
import com.myhexaville.login.R;
import com.myhexaville.login.SecondActivity;

import java.util.List;

public class $_Recycle_View_Main_Chat_Adapter extends RecyclerView.Adapter<$_Abstruct_Holder> {

    List<$_Abstruct_Value_Item_Main_Chat> rooms;

    public $_Recycle_View_Main_Chat_Adapter(List rooms) {
        this.rooms = rooms;
        this.rooms.toArray();
    }

    //Overrided Method
    @NonNull
    @Override
    public $_Abstruct_Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        if (i == $_Chat_Type.CLIENT_CHAT) {
            View view = LayoutInflater.from(SecondActivity.context).inflate(R.layout.item_recycle_view_main_chat_client, viewGroup, false);
            $_Holder_Client myHolder = new $_Holder_Client(view);
            return myHolder;
        } else {
            View view = LayoutInflater.from(SecondActivity.context).inflate(R.layout.item_recycle_view_main_chat_group, viewGroup, false);
            $_Holder_Group myHoldergroup = new $_Holder_Group(view);
            return myHoldergroup;
        }
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull $_Abstruct_Holder abstruct_holder, int i) {
        int type = getItemViewType(i);
        $_Abstruct_Value_Item_Main_Chat abstruct_value_item_main_chat = rooms.get(i);
        if (type == $_Chat_Type.CLIENT_CHAT) {
            $_Holder_Client myHolder = ($_Holder_Client) abstruct_holder;
            $_Value_Item_Main_Chat value_item_main_chat;
            value_item_main_chat = ($_Value_Item_Main_Chat) abstruct_value_item_main_chat;
            myHolder.abstruct_item_main_chat.getRecycle_view_main_chat_message().setText(value_item_main_chat.getMessage());
            myHolder.abstruct_item_main_chat.getRecycle_view_main_chat_name().setText(value_item_main_chat.getName());
            myHolder.abstruct_item_main_chat.getRecycle_view_main_chat_email().setText(value_item_main_chat.getEmail());
            Glide.with(SecondActivity.fragmentActivity)
                    .load(value_item_main_chat.getImage())
                    .asBitmap()
                    .into(
                            myHolder.abstruct_item_main_chat.getRecycle_view_main_chat_image()
                    );


            //holder_client.item_main_chat.getRecycle_view_main_chat_image().setImageResource(value_item_main_chat.getId_image());
            //holder_client.item_main_chat.getRecycle_view_main_chat_image().setBackgroundColor(Color.RED);
        } else {
            $_Holder_Group myHoldergroup = ($_Holder_Group) abstruct_holder;
            $_Value_Item_Main_Chat_Group value_item_main_chat_group;
            value_item_main_chat_group = ($_Value_Item_Main_Chat_Group) rooms.get(i);
            myHoldergroup.abstruct_item_main_chat.getRecycle_view_main_chat_message().setText(value_item_main_chat_group.getMessage());
            myHoldergroup.abstruct_item_main_chat.getRecycle_view_main_chat_name().setText(value_item_main_chat_group.getName());
            myHoldergroup.abstruct_item_main_chat.getRecycle_view_main_chat_email().setText(value_item_main_chat_group.getEmail());
            Glide.with(SecondActivity.fragmentActivity)
                    .load(value_item_main_chat_group.getImage())
                    .asBitmap()
                    .into(
                            myHoldergroup.abstruct_item_main_chat.getRecycle_view_main_chat_image()
                    );

        }
    }

    @Override
    public int getItemCount() {
        return rooms.size();
    }

    @Override
    public int getItemViewType(int position) {
        $_Abstruct_Value_Item_Main_Chat abstruct_value_item_main_chat = rooms.get(position);
        if (abstruct_value_item_main_chat.getType().equals("client")) {
            return $_Chat_Type.CLIENT_CHAT;
        } else return $_Chat_Type.GROUP_CHAT;
    }


}
