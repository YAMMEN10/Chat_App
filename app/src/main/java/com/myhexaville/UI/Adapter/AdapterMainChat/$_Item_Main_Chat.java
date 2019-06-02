package com.myhexaville.UI.Adapter.AdapterMainChat;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.myhexaville.login.R;


public class $_Item_Main_Chat {
    private TextView recycle_view_main_chat_message;
    private TextView recycle_view_main_chat_name;
    private TextView recycle_view_main_chat_email;
    private ImageView recycle_view_main_chat_image;

    public $_Item_Main_Chat(View view) {
        recycle_view_main_chat_image = view.findViewById(R.id.recycle_view_main_chat_image);
        recycle_view_main_chat_name = view.findViewById(R.id.recycle_view_main_chat_name);
        recycle_view_main_chat_message = view.findViewById(R.id.recycle_view_main_chat_message);
        recycle_view_main_chat_email = view.findViewById(R.id.recycle_view_main_chat_email);
    }

    public TextView getRecycle_view_main_chat_message() {
        return recycle_view_main_chat_message;
    }

    public void setRecycle_view_main_chat_message(TextView recycle_view_main_chat_message) {
        this.recycle_view_main_chat_message = recycle_view_main_chat_message;
    }

    public TextView getRecycle_view_main_chat_name() {
        return recycle_view_main_chat_name;
    }

    public void setRecycle_view_main_chat_name(TextView recycle_view_main_chat_name) {
        this.recycle_view_main_chat_name = recycle_view_main_chat_name;
    }

    public ImageView getRecycle_view_main_chat_image() {
        return recycle_view_main_chat_image;
    }

    public void setRecycle_view_main_chat_image(ImageView recycle_view_main_chat_image) {
        this.recycle_view_main_chat_image = recycle_view_main_chat_image;
    }

    public TextView getRecycle_view_main_chat_email() {
        return recycle_view_main_chat_email;
    }

    public void setRecycle_view_main_chat_email(TextView recycle_view_main_chat_email) {
        this.recycle_view_main_chat_email = recycle_view_main_chat_email;
    }
}
