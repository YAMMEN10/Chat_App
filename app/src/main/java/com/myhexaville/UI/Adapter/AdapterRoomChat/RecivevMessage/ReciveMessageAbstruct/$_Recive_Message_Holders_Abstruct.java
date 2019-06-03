package com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageAbstruct;

import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.myhexaville.Logic.Client.$_Client;
import com.myhexaville.UI.Adapter.AdapterRoomChat.Message.MessageText.$_Message_Text;
import com.myhexaville.UI.ToolSpeech.$_Arabic_TTS;
import com.myhexaville.login.FourActivity;
import com.myhexaville.login.MainActivity;
import com.myhexaville.login.R;

import java.util.Locale;

public abstract class $_Recive_Message_Holders_Abstruct extends RecyclerView.ViewHolder implements View.OnLongClickListener {
    private $_Item_Recive_Room_Chat_Message_Abstruct item_recive_room_chat_message_abstruct;

    private $_Arabic_TTS arabic_tts;

    public $_Item_Recive_Room_Chat_Message_Abstruct getItem_recive_room_chat_message_abstruct() {
        return item_recive_room_chat_message_abstruct;
    }

    public void setItem_recive_room_chat_message_abstruct($_Item_Recive_Room_Chat_Message_Abstruct item_recive_room_chat_message_abstruct) {
        this.item_recive_room_chat_message_abstruct = item_recive_room_chat_message_abstruct;
    }


    public $_Recive_Message_Holders_Abstruct(@NonNull View itemView) {
        super(itemView);
        initAction();
    }

    private void initAction() {
        itemView.setOnLongClickListener(this::onLongClick);
    }

    @Override
    public boolean onLongClick(View view) {
        /*final AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setTitle("Hello Dialog")
                .setMessage("LONG CLICK DIALOG WINDOW FOR ICON " + String.valueOf(getAdapterPosition()))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        builder.create().show();*/
        initSpeech(view);
        PopupMenu popupMenu = new PopupMenu(FourActivity.context, view);
        if (view.getTag().equals("item_view_send_message_text") || view.getTag().equals("item_view_recive_message_text")) {
            popupMenu.getMenu().add("Speech");
        }
        MenuInflater menuInflater = popupMenu.getMenuInflater();
        menuInflater.inflate(R.menu.message_popup_menu, popupMenu.getMenu());
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getTitle().equals("Delete")) {
                    MainActivity.allMessages.get($_Client.idRecived).second.remove(getAdapterPosition());
                    MainActivity.allMessages.get($_Client.idRecived).first.notifyDataSetChanged();
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            MainActivity.store_message.updateMessage($_Client.idRecived, MainActivity.allMessages.get($_Client.idRecived).second);
                        }
                    });
                    thread.start();
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return true;
                } else if (item.getTitle().equals("Speech")) {
                    System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ = " + FourActivity.context);
                    mTTS.speak((($_Message_Text) MainActivity.allMessages.get($_Client.idRecived).second.get(getAdapterPosition())).getMessage_text(), TextToSpeech.QUEUE_FLUSH, null);


                    return true;

                } else {
                    return false;
                }
            }
        });
        return true;
    }

    private void initSpeech(View view) {
        // Creating a new object of the ArabicTTS librrary
        arabic_tts = new $_Arabic_TTS();
        // Preparing the language
        arabic_tts.prepare(FourActivity.context);

    }
}
