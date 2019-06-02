package com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageAbstruct;

import android.view.View;
import android.widget.TextView;

public abstract class $_Item_Recive_Room_Chat_Message_Abstruct {
    protected TextView name_recive;
    protected TextView date_recive;

    public $_Item_Recive_Room_Chat_Message_Abstruct(View view) {


    }


    public TextView getName_recive() {
        return name_recive;
    }

    public void setName_recive(TextView name_recive) {
        this.name_recive = name_recive;
    }

    public TextView getDate_recive() {
        return date_recive;
    }

    public void setDate_recive(TextView date_recive) {
        this.date_recive = date_recive;
    }
}
