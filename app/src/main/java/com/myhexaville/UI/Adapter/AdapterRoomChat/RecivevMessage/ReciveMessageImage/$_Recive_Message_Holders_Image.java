package com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageImage;

import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.view.View;

import com.github.chrisbanes.photoview.PhotoView;
import com.myhexaville.Logic.Client.$_ClientStatic;
import com.myhexaville.UI.Adapter.AdapterRoomChat.Message.MessageImage.$_Message_Image;
import com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageAbstruct.$_Recive_Message_Holders_Abstruct;
import com.myhexaville.login.MainActivity;
import com.myhexaville.login.R;
import com.myhexaville.login.SecondActivity;

public class $_Recive_Message_Holders_Image extends $_Recive_Message_Holders_Abstruct implements View.OnClickListener {

    private $_Item_Recive_Room_Chat_Message_Image item_recive_room_chat_message_image;


    public $_Recive_Message_Holders_Image(@NonNull View itemView) {
        super(itemView);
        item_recive_room_chat_message_image = new $_Item_Recive_Room_Chat_Message_Image(itemView);
        initAction();
    }

    public $_Item_Recive_Room_Chat_Message_Image getItem_send_room_chat_message_image() {
        return item_recive_room_chat_message_image;
    }

    public void setItem_send_room_chat_message_image($_Item_Recive_Room_Chat_Message_Image item_send_room_chat_message_image) {
        this.item_recive_room_chat_message_image = item_send_room_chat_message_image;
    }


    @Override
    public void onClick(View v) {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(SecondActivity.fragmentActivity);
        View mView = SecondActivity.fragmentActivity.getLayoutInflater().inflate(R.layout.dialog_custom_layout, null);
        PhotoView photoView = mView.findViewById(R.id.imageView);
        Bitmap bmp = null;
        if ($_ClientStatic.getType().equals("ClientChat")) {
            bmp = BitmapFactory.decodeByteArray((($_Message_Image) MainActivity.allMessages.get($_ClientStatic.idRecived).second.get(getAdapterPosition())).getBytes(), 0, (($_Message_Image) MainActivity.allMessages.get($_ClientStatic.idRecived).second.get(getAdapterPosition())).getBytes().length);

        } else {
            bmp = BitmapFactory.decodeByteArray((($_Message_Image) MainActivity.allMessages.get($_ClientStatic.getIdGroup()).second.get(getAdapterPosition())).getBytes(), 0, (($_Message_Image) MainActivity.allMessages.get($_ClientStatic.getIdGroup()).second.get(getAdapterPosition())).getBytes().length);

        }
        photoView.setImageBitmap(bmp);
        mBuilder.setView(mView);
        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }


    private void initAction() {
        //itemView.setOnClickListener(this::onClick);
        item_recive_room_chat_message_image.getMessage_recive_image().setOnClickListener(this::onClick);

    }
}
