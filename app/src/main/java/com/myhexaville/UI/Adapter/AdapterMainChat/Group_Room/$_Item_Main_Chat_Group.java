package com.myhexaville.UI.Adapter.AdapterMainChat.Group_Room;

import android.view.View;

import com.myhexaville.UI.Adapter.AdapterMainChat.$_Abstruct_Item_Main_Chat;
import com.myhexaville.login.R;


public class $_Item_Main_Chat_Group extends $_Abstruct_Item_Main_Chat {


    public $_Item_Main_Chat_Group(View view) {
        recycle_view_main_chat_image = view.findViewById(R.id.recycle_view_main_chat_image_group);
        recycle_view_main_chat_name = view.findViewById(R.id.recycle_view_main_chat_name_group);
        recycle_view_main_chat_message = view.findViewById(R.id.recycle_view_main_chat_message_group);
        recycle_view_main_chat_email = view.findViewById(R.id.recycle_view_main_chat_email_group);
        id_popup_menu = view.findViewById(R.id.id_popup_menu_group);

    }


}
