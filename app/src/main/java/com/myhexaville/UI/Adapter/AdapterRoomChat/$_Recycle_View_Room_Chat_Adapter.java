package com.myhexaville.UI.Adapter.AdapterRoomChat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.myhexaville.UI.Adapter.AdapterRoomChat.Message.$_Message;
import com.myhexaville.UI.Adapter.AdapterRoomChat.Message.$_Message_Type;
import com.myhexaville.UI.Adapter.AdapterRoomChat.Message.MessageImage.$_Message_Image;
import com.myhexaville.UI.Adapter.AdapterRoomChat.Message.MessageText.$_Message_Text;
import com.myhexaville.UI.Adapter.AdapterRoomChat.Message.MessageVoice.$_Message_Voice;
import com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageImage.$_Recive_Message_Holders_Image;
import com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageImage.$_Value_Recive_Item_Room_Chat_Message_Image;
import com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageText.$_Recive_Message_Holders_Text;
import com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageText.$_Value_Recive_Item_Room_Chat_Text;
import com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageVoice.$_Recive_Message_Holders_Voice;
import com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageVoice.$_Value_Recive_Item_Room_Chat_Message_Voice;
import com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessageImage.$_Send_Message_Holders_Image;
import com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessageImage.$_Value_Send_Item_Room_Chat_Message_Image;
import com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessageVoice.$_Send_Message_Holders_Voice;
import com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessageVoice.$_Value_Send_Item_Room_Chat_Message_Voice;
import com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessgaeText.$_Send_Message_Holders_Text;
import com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessgaeText.$_Value_Send_Item_Room_Chat_Message_Text;
import com.myhexaville.login.FourActivity;
import com.myhexaville.login.R;

import java.util.List;


public class $_Recycle_View_Room_Chat_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<$_Message> list;
    private Context context;


    public $_Recycle_View_Room_Chat_Adapter(List list, Context context) {
        this.list = list;
        this.list.toArray();
        this.context = context;
    }


    //Overrided Method
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == $_Message_Type.SENT_TEXT) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_send_recycle_view_room_chat_text, viewGroup, false);
            $_Send_Message_Holders_Text send_message_holders_text = new $_Send_Message_Holders_Text(view);
            return send_message_holders_text;
        } else if (i == $_Message_Type.SENT_IMAGE) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_send_recycle_view_room_chat_image, viewGroup, false);
            $_Send_Message_Holders_Image send_message_holders_image = new $_Send_Message_Holders_Image(view);
            return send_message_holders_image;
        } else if (i == $_Message_Type.RECIVE_TEXT) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recive_recycle_view_room_chat_text, viewGroup, false);
            $_Recive_Message_Holders_Text recive_message_holders_text = new $_Recive_Message_Holders_Text(view);
            return recive_message_holders_text;

        } else if (i == $_Message_Type.RECIVE_IMAGE) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recive_recycle_view_room_chat_image, viewGroup, false);
            $_Recive_Message_Holders_Image recive_message_holders_image = new $_Recive_Message_Holders_Image(view);
            return recive_message_holders_image;
        } else if (i == $_Message_Type.SENT_VOICE) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_send_recycle_view_room_chat_voice, viewGroup, false);
            $_Send_Message_Holders_Voice send_message_holders_voice = new $_Send_Message_Holders_Voice(view);
            return send_message_holders_voice;
        } else {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recive_recycle_view_room_chat_voice, viewGroup, false);
            $_Recive_Message_Holders_Voice recive_message_holders_voice = new $_Recive_Message_Holders_Voice(view);
            return recive_message_holders_voice;

        }
        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder myHolder, int i) {
        int type = getItemViewType(i);

        $_Message message = list.get(i);
        if (type == $_Message_Type.SENT_TEXT) {
            $_Message_Text message_text = ($_Message_Text) message;
            $_Value_Send_Item_Room_Chat_Message_Text value_send_item_room_chat_message_text = new $_Value_Send_Item_Room_Chat_Message_Text(message_text.getMessage_text(), message_text.getTime());
            $_Send_Message_Holders_Text send_message_holders_text = ($_Send_Message_Holders_Text) myHolder;
            send_message_holders_text.getItem_room_chat_text_send().getMessage_send().setText(value_send_item_room_chat_message_text.getMessage());
            send_message_holders_text.getItem_room_chat_text_send().getDate_send().setText(value_send_item_room_chat_message_text.getDate());
        } else if (type == $_Message_Type.SENT_IMAGE) {
            $_Message_Image message_image = ($_Message_Image) message;
            $_Value_Send_Item_Room_Chat_Message_Image value_send_item_room_chat_message_image = new $_Value_Send_Item_Room_Chat_Message_Image(message_image.getBytes(), message_image.getTime());
            $_Send_Message_Holders_Image send_message_holders_image = ($_Send_Message_Holders_Image) myHolder;
            //byte[] bytes = Base64.decode(message_image.getBytes(), Base64.DEFAULT);
            // down sizing image as it throws OutOfMemory Exception for larger
            // images
            //   BufferedImage bufferedImage = null;
            Glide.with(FourActivity.fragmentActivity)
                    .load(message_image.getBytes())
                    .asBitmap()
                    .into(
                            send_message_holders_image.getItem_send_room_chat_message_image().getMessage_send_image()
                    );
            /*byte [] encodeByte=Base64.decode(message_image.getBytes(),Base64.DEFAULT);
            InputStream inputStream  = new ByteArrayInputStream(encodeByte);
            Bitmap bitmap  = BitmapFactory.decodeStream(inputStream);
            send_message_holders_image.getItem_send_room_chat_message_image().getMessage_send_image().setImageBitmap(bitmap);*/
            send_message_holders_image.getItem_send_room_chat_message_image().getDate_send().setText(value_send_item_room_chat_message_image.getDate());
        } else if (type == $_Message_Type.RECIVE_TEXT) {
            $_Message_Text message_text = ($_Message_Text) message;
            $_Recive_Message_Holders_Text reciveTextHolder = ($_Recive_Message_Holders_Text) myHolder;
            $_Value_Recive_Item_Room_Chat_Text value_recive_item_room_chat_text = new $_Value_Recive_Item_Room_Chat_Text(message_text.getName(), message_text.getMessage_text(), message_text.getTime());
            reciveTextHolder.getItem_recive_room_chat_text().getName_recive().setText(value_recive_item_room_chat_text.getName());
            reciveTextHolder.getItem_recive_room_chat_text().getMessage_recive().setText(value_recive_item_room_chat_text.getContent());
            reciveTextHolder.getItem_recive_room_chat_text().getDate_recive().setText(value_recive_item_room_chat_text.getDate());

        } else if (type == $_Message_Type.RECIVE_IMAGE) {
            $_Message_Image message_image = ($_Message_Image) message;
            $_Value_Recive_Item_Room_Chat_Message_Image value_recive_item_room_chat_message_image = new $_Value_Recive_Item_Room_Chat_Message_Image(message_image.getBytes(), message_image.getName(), message_image.getTime());
            $_Recive_Message_Holders_Image recive_message_holders_image = ($_Recive_Message_Holders_Image) myHolder;
            recive_message_holders_image.getItem_send_room_chat_message_image().getName_recive().setText(value_recive_item_room_chat_message_image.getName());
            // down sizing image as it throws OutOfMemory Exception for larger
            // images

            //byte[] bytes = Base64.decode(message_image.getBytes(), Base64.DEFAULT);
            // down sizing image as it throws OutOfMemory Exception for larger
            // images

            Glide.with(FourActivity.fragmentActivity)
                    .load(message_image.getBytes())
                    .asBitmap()
                    .into(recive_message_holders_image.getItem_send_room_chat_message_image().getMessage_recive_image());
           /* byte [] encodeByte=Base64.decode(message_image.getBytes(),Base64.DEFAULT);
            InputStream inputStream  = new ByteArrayInputStream(encodeByte);
            Bitmap bitmap  = BitmapFactory.decodeStream(inputStream);
            recive_message_holders_image.getItem_send_room_chat_message_image().getMessage_send_image().setImageBitmap(bitmap);
            recive_message_holders_image.getItem_send_room_chat_message_image().getDate_recive().setText(value_recive_item_room_chat_message_image.getDate());*/

        } else if (type == $_Message_Type.SENT_VOICE) {
            //init
            $_Message_Voice message_voice = ($_Message_Voice) message;
            $_Value_Send_Item_Room_Chat_Message_Voice value_send_item_room_chat_message_voice = new $_Value_Send_Item_Room_Chat_Message_Voice(message_voice.getVoice_bar(), message_voice.getTime());
            $_Send_Message_Holders_Voice send_message_holders_voice = ($_Send_Message_Holders_Voice) myHolder;

            //push value
            send_message_holders_voice.getItem_send_room_chat_message_voice().getDate_send().setText(value_send_item_room_chat_message_voice.getDate());
            send_message_holders_voice.getItem_send_room_chat_message_voice().getMessage_send_voice_seek_bar().setProgress((int) message_voice.getVoice_bar());
            send_message_holders_voice.getItem_send_room_chat_message_voice().getMessage_send_voice().setImageResource(R.drawable.play_voice);

           /* TextView message_send_value = send_message_holders_voice.getItem_send_room_chat_message_voice().getMessage_send_value();
            ImageButton message_send_voice = send_message_holders_voice.getItem_send_room_chat_message_voice().getMessage_send_voice();
            SeekBar seekBar = send_message_holders_voice.getItem_send_room_chat_message_voice().getMessage_send_voice_seek_bar();
   */


        } else if (type == $_Message_Type.RECIVE_VOICE) {
            $_Message_Voice message_voice = ($_Message_Voice) message;
            $_Value_Recive_Item_Room_Chat_Message_Voice value_recive_item_room_chat_message_voice = new $_Value_Recive_Item_Room_Chat_Message_Voice(message_voice.getVoice_bar(), message.getName(), message_voice.getTime());
            $_Recive_Message_Holders_Voice recive_message_holders_voice = ($_Recive_Message_Holders_Voice) myHolder;

            //push value
            recive_message_holders_voice.getItem_recive_room_chat_message_voice().getDate_recive().setText(value_recive_item_room_chat_message_voice.getDate());
            recive_message_holders_voice.getItem_recive_room_chat_message_voice().getMessage_recive_voice_seek_bar().setProgress((int) message_voice.getVoice_bar());
            recive_message_holders_voice.getItem_recive_room_chat_message_voice().getMessage_recived_voice().setImageResource(R.drawable.play_voice);


            TextView message_recive_value = recive_message_holders_voice.getItem_recive_room_chat_message_voice().getMessage_recive_value();
            ImageButton message_recive_voice = recive_message_holders_voice.getItem_recive_room_chat_message_voice().getMessage_recived_voice();
            SeekBar seekBar = recive_message_holders_voice.getItem_recive_room_chat_message_voice().getMessage_recive_voice_seek_bar();

       /*     recive_message_holders_voice.getItem_recive_room_chat_message_voice().getMessage_recived_voice().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playSounds(message.getName(), (($_Message_Voice) message).getVoice_data(), seekBar, message_recive_voice);
                }
            });
            recive_message_holders_voice.getItem_recive_room_chat_message_voice().getMessage_recive_voice_seek_bar().setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    message_recive_value.setVisibility(View.VISIBLE);
                    int x = (int) Math.ceil(progress / 1000f);

                    if (x < 10)
                        message_recive_value.setText("0:0" + x);
                    else
                        message_recive_value.setText("0:" + x);

                    double percent = progress / (double) seekBar.getMax();
                    int offset = seekBar.getThumbOffset();
                    int seekWidth = seekBar.getWidth();
                    int val = (int) Math.round(percent * (seekWidth - 2 * offset));
                    int labelWidth = message_recive_value.getWidth();
                    message_recive_value.setX(offset + seekBar.getX() + val
                            - Math.round(percent * offset)
                            - Math.round(percent * labelWidth / 2));

                    if (progress > 0 && mPlayer != null && !mPlayer.isPlaying()) {
                        clearMediaPlayer();
                        message_recive_voice.setImageResource(R.drawable.play_voice);
                        seekBar.setProgress(0);
                    }


                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    message_recive_value.setVisibility(View.VISIBLE);
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    if (mPlayer != null && mPlayer.isPlaying()) {
                        mPlayer.seekTo(seekBar.getProgress());
                    }
                }
            });
*/
        }

    }




    @Override
    public int getItemViewType(int position) {
        $_Message message = list.get(position);
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA === " + message.getType());
        //   if ($_ClientStatic.getEmail().equals(message.getId())) {
            if (message.getType().equals("1")) {
                return $_Message_Type.SENT_TEXT;
            } else if (message.getType().equals("2")) {
                return $_Message_Type.SENT_IMAGE;
            } else if (message.getType().equals("5")) {
                return $_Message_Type.SENT_VOICE;
            }
            //  } else {
            else if (message.getType().equals("3")) {
                return $_Message_Type.RECIVE_TEXT;
            } else if (message.getType().equals("4")) {
                return $_Message_Type.RECIVE_IMAGE;
            } else if (message.getType().equals("6")) {
                return $_Message_Type.RECIVE_VOICE;
            }
        // }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);

        void onDeleteClick(int position);
    }


}