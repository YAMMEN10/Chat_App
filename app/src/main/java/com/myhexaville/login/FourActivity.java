package com.myhexaville.login;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.myhexaville.Logic.Client.$_ClientStatic;
import com.myhexaville.Logic.JSONData.$_JSON_Message_Image_Client;
import com.myhexaville.Logic.JSONData.$_JSON_Message_Image_Group;
import com.myhexaville.Logic.JSONData.$_JSON_Message_Text_Client;
import com.myhexaville.Logic.JSONData.$_JSON_Message_Text_Group;
import com.myhexaville.Logic.ServerManagment.$_SendData;
import com.myhexaville.UI.$_Static_Class;
import com.myhexaville.UI.Adapter.AdapterRoomChat.Message.$_Message;
import com.myhexaville.UI.Adapter.AdapterRoomChat.Message.MessageImage.$_Message_Image;
import com.myhexaville.UI.Adapter.AdapterRoomChat.Message.MessageText.$_Message_Text;
import com.myhexaville.UI.Chat.VoiceFragment.voice_fragment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import hani.momanii.supernova_emoji_library.Actions.EmojIconActions;
import hani.momanii.supernova_emoji_library.Helper.EmojiconEditText;

public class FourActivity extends AppCompatActivity implements voice_fragment.OnFragmentInteractionListener {


    public static final int PICK_IMAGE_REQUEST = 100;
    private static final String TAG = FourActivity.class.getSimpleName();
    //Attribute
    public static RecyclerView recycle_view_room_chat;
    public static voice_fragment voice_fragment;
    public static FragmentManager fragmentManager;
    public static FragmentActivity fragmentActivity;
    public static Context context;
    public static Fragment fragment;
    private static FragmentTransaction fragmentTransaction;
    private static String mFileName = null;
    EmojIconActions emojIcon;
    //private $_Recycle_View_Room_Chat_Adapter recycle_view_room_chat_adapter;
    //private List<$_Message> list;
    RecyclerView.LayoutManager layoutManager;
    private ImageButton item_recycle_view_room_chat_studio;
    private ImageButton txt_message_send;
    private ImageButton item_recycle_view_room_chat_record_voice;
    private ImageView btn_emoji;
    private View rootView;
    private SeekBar seekBar;
    private EmojiconEditText txt_message_input;
    // for audio
    public static boolean wasPlaying = false;
    public static MediaPlayer mPlayer = null;

    private String type;

    //Constructor
    public FourActivity() {
        //list = new ArrayList<>();
        //recycle_view_room_chat_adapter = new $_Recycle_View_Room_Chat_Adapter(MainActivity.allMessages.get($_Client.idRecived), this);
        fragmentActivity = this;
        context = this;
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        voice_fragment = new voice_fragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        type = getIntent().getExtras().getString("Type");
        System.out.println("TTTYYYPPEE = " + type);
        /* FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
         fragmentTransaction.add(R.id.container_main_four,new room_chat()).commit();*/
        /*for(int i = 0 ; i < MainActivity.messages.size(); i++){
            System.out.println("ID = " + MainActivity.messages.get(i).getId() + "    ID Recive =  " + $_Client.idRecived);
            if(MainActivity.messages.get(i).getId().equals($_Client.idRecived)){
                list.add(MainActivity.messages.get(i));
            }
        }*/
        /*for(int i = 0; i < MainActivity.allMessages.get($_Client.idRecived).second.size(); i++){
            //list.add(MainActivity.allMessages.get($_Client.idRecived).get(i));
            MainActivity.allMessages.get($_Client.idRecived).second.add(MainActivity.allMessages.get($_Client.idRecived).second.get(i));

        }*/
        //recycle_view_room_chat_adapter.notifyDataSetChanged();
        if (type.equals("ClientChat"))
            MainActivity.allMessages.get($_ClientStatic.idRecived).first.notifyDataSetChanged();
        else MainActivity.allMessages.get($_ClientStatic.idGroup).first.notifyDataSetChanged();


        initUI();
        action_UI();
        if (type.equals("ClientChat")) {
            recycle_view_room_chat.scrollToPosition(MainActivity.allMessages.get($_ClientStatic.idRecived).first.getItemCount() - 1);

            mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
            mFileName += "/" + $_ClientStatic.idRecived + ".3gp";
        } else {
            recycle_view_room_chat.scrollToPosition(MainActivity.allMessages.get($_ClientStatic.idGroup).first.getItemCount() - 1);
            mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
            mFileName += "/" + $_ClientStatic.idGroup + ".3gp";

        }


    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ActivityCompat.requestPermissions(FourActivity.fragmentActivity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, requestCode);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = this.getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            try {
                final FileInputStream file;
                file = new FileInputStream(picturePath);
                final byte[] bytes = new byte[file.available()];
                file.read(bytes);


                $_Message_Image message_image = null;

                if (type.equals("ClientChat")) {
                    $_JSON_Message_Image_Client json_message_image_client = new $_JSON_Message_Image_Client(
                            "Message_Image",
                            $_ClientStatic.getEmail(),
                            $_ClientStatic.idRecived,
                            "2",
                            String.valueOf(bytes.length),
                            $_Static_Class.getCurrentTime(),
                            $_ClientStatic.getUserName()
                    );

                    $_SendData sendData = new $_SendData(json_message_image_client, "Message_Image");
                    sendData.excute();
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                $_ClientStatic.getDataOutputStreamMessage().writeUTF(sendData.getJson_object().toString());
                                $_ClientStatic.getDataOutputStreamMessage().write(bytes);
                                $_ClientStatic.getDataOutputStreamMessage().flush();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                    thread.start();
                    thread.join();
                    message_image = new $_Message_Image($_ClientStatic.getEmail(), $_ClientStatic.getUserName(), "2", "", bytes);
                    addMessage(message_image);
                    storeMessage(MainActivity.allMessages.get($_ClientStatic.idRecived).second);

                } else {
                    $_JSON_Message_Image_Group json_message_image_group = new $_JSON_Message_Image_Group(
                            "Message_Image_Group",
                            $_ClientStatic.getEmail(),
                            $_ClientStatic.getIdsRecived(),
                            $_ClientStatic.idGroup,
                            "2",
                            String.valueOf(bytes.length),
                            $_Static_Class.getCurrentTime(),
                            $_ClientStatic.getUserName()
                    );

                    $_SendData sendData = new $_SendData(json_message_image_group, "Message_Image_Group");
                    sendData.excute();
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                $_ClientStatic.getDataOutputStreamMessage().writeUTF(sendData.getJson_object().toString());
                                $_ClientStatic.getDataOutputStreamMessage().write(bytes);
                                $_ClientStatic.getDataOutputStreamMessage().flush();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                    thread.start();
                    thread.join();
                    message_image = new $_Message_Image($_ClientStatic.idGroup, $_ClientStatic.getUserName(), "2", $_Static_Class.getCurrentTime(), bytes);
                    addMessage(message_image);
                    storeMessage(MainActivity.allMessages.get($_ClientStatic.idGroup).second);

                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    protected void onStop() {
        super.onStop();
        // sendSaveImage();
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    // My Function
    public void initUI() {
        recycle_view_room_chat = findViewById(R.id.recycle_view_room_chat);
        layoutManager = new LinearLayoutManager(this);
        if (type.equals("ClientChat"))
            recycle_view_room_chat.setAdapter(MainActivity.allMessages.get($_ClientStatic.idRecived).first);
        else
            recycle_view_room_chat.setAdapter(MainActivity.allMessages.get($_ClientStatic.idGroup).first);


        recycle_view_room_chat.setLayoutManager(layoutManager);
        recycle_view_room_chat.setHasFixedSize(true);

        //item_recycle_view_room_chat_studio = findViewById(R.id.item_recycle_view_room_chat_studio);
        txt_message_send = findViewById(R.id.txt_message_send);
        item_recycle_view_room_chat_studio = findViewById(R.id.item_recycle_view_room_chat_studio);
        item_recycle_view_room_chat_record_voice = findViewById(R.id.item_recycle_view_room_chat_record_voice);

        //emoji
        rootView = findViewById(R.id.container_main_fourty);
        txt_message_input = findViewById(R.id.txt_message_input);
        btn_emoji = findViewById(R.id.btn_emoji);

        emojIcon = new EmojIconActions(this, rootView, txt_message_input, btn_emoji);
        emojIcon.ShowEmojIcon();
        emojIcon.setIconsIds(R.drawable.ic_action_keyboard, R.drawable.smiley);
        emojIcon.setKeyboardListener(new EmojIconActions.KeyboardListener() {
            @Override
            public void onKeyboardOpen() {
                Log.e(TAG, "Keyboard opened!");
            }

            @Override
            public void onKeyboardClose() {
                Log.e(TAG, "Keyboard closed");
            }
        });


    }


    public void action_UI() {
        txt_message_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    $_Message message_text = null;

                    if (type.equals("ClientChat")) {
                        $_JSON_Message_Text_Client json_message_text_client = new $_JSON_Message_Text_Client(
                                "Message_Text",
                                $_ClientStatic.getEmail(),
                                $_ClientStatic.idRecived,
                                "1",
                                txt_message_input.getText().toString(),
                                $_Static_Class.getCurrentTime(),
                                $_ClientStatic.getUserName()
                        );
                        $_SendData sendData = new $_SendData(json_message_text_client, "Message_Text");
                        sendData.excute();

                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    $_ClientStatic.getDataOutputStreamMessage().writeUTF(sendData.getJson_object().toString());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }
                        });
                        thread.start();
                        thread.join();
                        message_text = new $_Message_Text($_ClientStatic.getEmail(), $_ClientStatic.getUserName(), "1", $_Static_Class.getCurrentTime(), txt_message_input.getText().toString());
                        addMessage(message_text);
                        storeMessage(MainActivity.allMessages.get($_ClientStatic.idRecived).second);


                    } else {
                        $_JSON_Message_Text_Group json_message_text_group = new $_JSON_Message_Text_Group(
                                "Message_Text_Group",
                                $_ClientStatic.getEmail(),
                                $_ClientStatic.getIdsRecived(),
                                "1",
                                $_ClientStatic.getIdGroup(),
                                txt_message_input.getText().toString(),
                                $_Static_Class.getCurrentTime(),
                                $_ClientStatic.getUserName()

                        );
                        $_SendData sendData = new $_SendData(json_message_text_group, "Message_Text_Group");
                        sendData.excute();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    $_ClientStatic.getDataOutputStreamMessage().writeUTF(sendData.getJson_object().toString());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }
                        });
                        thread.start();
                        message_text = new $_Message_Text($_ClientStatic.getIdGroup(), $_ClientStatic.getUserName(), "1", $_Static_Class.getCurrentTime(), txt_message_input.getText().toString());
                        addMessage(message_text);
                        storeMessage(MainActivity.allMessages.get($_ClientStatic.idGroup).second);

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });


        item_recycle_view_room_chat_studio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FromCard();
            }
        });


        item_recycle_view_room_chat_record_voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*
                if (!isplay) {
                    isplay = true;
                    if (CheckPermissions()) {
                        mRecorder = new MediaRecorder();
                        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                        mRecorder.setOutputFile(mFileName);
                        try {
                            mRecorder.prepare();
                        } catch (IOException e) {
                            Log.e(LOG_TAG, "prepare() failed");
                        }
                        mRecorder.start();
                        Toast.makeText(getApplicationContext(), "Recording Started", Toast.LENGTH_LONG).show();
                    } else {
                        RequestPermissions();
                    }
                } else {
                    isplay = false;
                    mRecorder.stop();
                    mRecorder.release();
                    mRecorder = null;
                    Toast.makeText(getApplicationContext(), "Recording Stopped", Toast.LENGTH_LONG).show();
                    try {
                        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(mFileName));
                        bytes = new byte[dataInputStream.available()];
                        dataInputStream.read(bytes);
                        dataInputStream.close();
                        JSONObject jsonObject = new JSONObject();
                        try {
                            jsonObject.put($_JSONAttributes.Id.toString(), $_Client.getEmail());
                            jsonObject.put($_JSONAttributes.IdRecive.toString(), $_Client.idRecived);
                            jsonObject.put($_JSONAttributes.Type.toString(), "Message_Voice");
                            jsonObject.put("Time", $_Static_Class.getCurrentTime());
                            jsonObject.put($_JSONAttributes.User_Name.toString(), $_Client.getUserName());
                            jsonObject.put("MType", "R");
                            jsonObject.put("Message", bytes.length);
                            Thread thread = new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        $_Client.getDataOutputStreamMessage().writeUTF(jsonObject.toString());
                                        $_Client.getDataOutputStreamMessage().write(bytes);
                                        $_Client.getDataOutputStreamMessage().flush();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                            thread.start();
                            thread.join();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        $_Message_Voice message_voice = new $_Message_Voice($_Client.getEmail(), $_Client.getUserName(), "5", $_Static_Class.getCurrentTime(), 0, bytes);
                        addMessage(message_voice);
                        storeMessage(MainActivity.allMessages.get($_Client.idRecived.toString()).second);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
*/
                Bundle bundle = new Bundle();
                bundle.putString("name", $_ClientStatic.idRecived);
                voice_fragment.setArguments(bundle);
                fragmentActivity.getSupportFragmentManager().beginTransaction().add(R.id.container_main_fourty, voice_fragment).commit();
            }
        });




/*    recycle_view_room_chat.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recycle_view_room_chat, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            }

            @Override
            public void onLongItemClick(View view, int position) {
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(), view);
                MenuInflater menuInflater = popupMenu.getMenuInflater();
                menuInflater.inflate(R.menu.message_popup_menu, popupMenu.getMenu());
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getTitle().equals("Delete")) {
                            MainActivity.allMessages.get($_Client.idRecived).second.remove(position);
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
                        } else {
                            return false;
                        }
                    }
                });
            }
        }));
*/
    }


    public void FromCard() {
        //Create an Intent with action as ACTION_PICK
        Intent intent = new Intent(Intent.ACTION_PICK);
        // Sets the type as image/*. This ensures only components of type image are selected
        intent.setType("image/*");
        //We pass an extra array with the accepted mime types. This will ensure only components with these MIME types as targeted.
        String[] mimeTypes = {"image/jpeg", "image/png"};
        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
        // Launching the Intent
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    public synchronized void addMessage($_Message message) {
        //list.add(message);
        if (type.equals("ClientChat"))
            MainActivity.allMessages.get($_ClientStatic.idRecived).second.add(message);
        else
            MainActivity.allMessages.get($_ClientStatic.idGroup).second.add(message);


        FourActivity.fragmentActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (type.equals("ClientChat"))
                    MainActivity.allMessages.get($_ClientStatic.idRecived).first.notifyDataSetChanged();
                else
                    MainActivity.allMessages.get($_ClientStatic.idGroup).first.notifyDataSetChanged();
                if (recycle_view_room_chat == null) {
                    System.out.println("NNNNULLLLLLLLLLLLL->");
                } else {
                    if (type.equals("ClientChat"))
                        recycle_view_room_chat.scrollToPosition(MainActivity.allMessages.get($_ClientStatic.idRecived).first.getItemCount() - 1);
                    else
                        recycle_view_room_chat.scrollToPosition(MainActivity.allMessages.get($_ClientStatic.idGroup).first.getItemCount() - 1);
                }
            }
        });


    }

    public synchronized void storeMessage(List<$_Message> messages) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (type.equals("ClientChat"))
                    MainActivity.store_message.storeMessage($_ClientStatic.idRecived, messages);
                else {
                    for (int i = 0; i < $_ClientStatic.getIdsRecived().size(); i++) {
                        if (!$_ClientStatic.getIdsRecived().get(i).equals($_ClientStatic.getEmail())) {
                            MainActivity.store_message_group.setMessageGroupFile($_ClientStatic.getIdGroup());
                            MainActivity.store_message_group.getChatMessageGroupMangment().setMessageFile($_ClientStatic.getIdGroup());
                            MainActivity.store_message_group.storeMessage($_ClientStatic.getIdsRecived().get(i), $_ClientStatic.getIdGroup(), messages);

                        }

                    }
                }

            }
        });
        thread.start();
    }
}