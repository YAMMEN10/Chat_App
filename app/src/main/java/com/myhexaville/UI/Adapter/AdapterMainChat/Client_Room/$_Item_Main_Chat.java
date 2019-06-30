package com.myhexaville.UI.Adapter.AdapterMainChat.Client_Room;

import android.view.View;

import com.myhexaville.UI.Adapter.AdapterMainChat.$_Abstruct_Item_Main_Chat;
import com.myhexaville.login.R;


public class $_Item_Main_Chat extends $_Abstruct_Item_Main_Chat {


    public $_Item_Main_Chat(View view) {
        recycle_view_main_chat_image = view.findViewById(R.id.recycle_view_main_chat_image);
        recycle_view_main_chat_name = view.findViewById(R.id.recycle_view_main_chat_name);
        recycle_view_main_chat_message = view.findViewById(R.id.recycle_view_main_chat_message);
        recycle_view_main_chat_email = view.findViewById(R.id.recycle_view_main_chat_email);
        id_popup_menu = view.findViewById(R.id.id_popup_menu_client);
    }


}
