package com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageAbstruct;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.myhexaville.Logic.Client.$_ClientStatic;
import com.myhexaville.UI.Adapter.AdapterRoomChat.Message.MessageText.$_Message_Text;
import com.myhexaville.UI.ToolSpeech.$_Arabic_TTS;
import com.myhexaville.login.FourActivity;
import com.myhexaville.login.MainActivity;
import com.myhexaville.login.R;

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
                            //break;


                        } else if (item.getTitle().equals("Speech")) {
                            String text = (($_Message_Text) MainActivity.allMessages.get($_ClientStatic.idRecived).second.get(getAdapterPosition())).getMessage_text();
                            if (text != null && !text.equals("")) {
                                // To read the text inserted
                                arabic_tts.talk(text);
                            }

                            return true;

                        } else {
                            return false;
                        }

                        //break;
                    }

                    case "GroupChat": {

                        if (item.getTitle().equals("Delete")) {
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
                            return true;

                        } else if (item.getTitle().equals("Speech")) {
                            String text = (($_Message_Text) MainActivity.allMessages.get($_ClientStatic.idGroup).second.get(getAdapterPosition())).getMessage_text();
                            if (text != null && !text.equals("")) {
                                // To read the text inserted
                                arabic_tts.talk(text);
                            }

                            return true;

                        } else {
                            return false;
                        }


                        //break;
                    }
                    default: {
                        //breack;
                        return false;
                    }
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
