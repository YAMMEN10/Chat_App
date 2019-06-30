package com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessageAbstruct;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.myhexaville.Logic.Client.$_ClientStatic;
import com.myhexaville.login.FourActivity;
import com.myhexaville.login.MainActivity;
import com.myhexaville.login.R;

public class $_Send_Message_Holders_Abstruct extends RecyclerView.ViewHolder implements View.OnLongClickListener {
    private $_Item_Send_Room_Chat_Message_Abstruct item_send_room_chat_message_abstruct;

    public $_Send_Message_Holders_Abstruct(@NonNull View itemView) {
        super(itemView);
        initAction();
    }

    public $_Item_Send_Room_Chat_Message_Abstruct getItem_send_room_chat_message_abstruct() {
        return item_send_room_chat_message_abstruct;
    }

    public void setItem_send_room_chat_message_abstruct($_Item_Send_Room_Chat_Message_Abstruct item_send_room_chat_message_abstruct) {
        this.item_send_room_chat_message_abstruct = item_send_room_chat_message_abstruct;
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
        PopupMenu popupMenu = new PopupMenu(FourActivity.context, view);
        MenuInflater menuInflater = popupMenu.getMenuInflater();
        menuInflater.inflate(R.menu.message_popup_menu, popupMenu.getMenu());
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch ($_ClientStatic.getType()) {
                    case "ClientChat": {
                        if (item.getTitle().equals("Delete")) {
                            MainActivity.allMessages.get($_ClientStatic.idRecived).second.remove(getAdapterPosition());
                            MainActivity.allMessages.get($_ClientStatic.idRecived).first.notifyDataSetChanged();
                            Thread thread = new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    MainActivity.store_message.updateMessage($_ClientStatic.idRecived, MainActivity.allMessages.get($_ClientStatic.idRecived).second);
                                }
                            });
                            thread.start();
                            try {
                                thread.join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                return false;
                            }
                            return true;

                        } else {
                            return false;
                        }
                    }
                    case "GroupChat": {
                        MainActivity.allMessages.get($_ClientStatic.idGroup).second.remove(getAdapterPosition());
                        MainActivity.allMessages.get($_ClientStatic.idGroup).first.notifyDataSetChanged();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < $_ClientStatic.getIdsRecived().size(); i++)
                                    MainActivity.store_message.updateMessage($_ClientStatic.getIdsRecived().get(i), MainActivity.allMessages.get($_ClientStatic.idGroup).second);
                            }
                        });
                        thread.start();
                        try {
                            thread.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return false;
                        }
                        //break;
                        return true;
                    }
                    default: {
                        return false;
                    }
                }
            }
        });
        return true;
    }

    private void initAction() {
        itemView.setOnLongClickListener(this::onLongClick);

    }

}
