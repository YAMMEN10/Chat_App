package com.myhexaville.UI.ToolStorage;

import com.myhexaville.Logic.MessagesChats.$_ChatMessageMangment;
import com.myhexaville.UI.Adapter.AdapterRoomChat.Message.$_Message;
import com.myhexaville.login.MainActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class $_Store_Message {
    private $_ChatMessageMangment chatMessageMangment;
    private String MessagedPath;
    private String messageFile;


    public $_Store_Message($_ChatMessageMangment friendStorgeMangement) {
        this.chatMessageMangment = friendStorgeMangement;
        //removeFolder(new File(MainActivity.context.getFilesDir() + "/Chat"));
        // init Folder's
        FriendPathMangment.MainPath = MainActivity.context.getFilesDir() + "/Chat";
        FriendPathMangment.FriendPath = FriendPathMangment.MainPath + "/Friend";
        FriendPathMangment.AccountPath = FriendPathMangment.MainPath + "/Account";
        new File(FriendPathMangment.MainPath).mkdir();
        new File(FriendPathMangment.FriendPath).mkdir();
        new File(FriendPathMangment.AccountPath).mkdir();

        //init
        this.MessagedPath = FriendPathMangment.FriendPath;
        this.messageFile = "Message.Fi";

    }


    public synchronized void storeMessage(String id, List<$_Message> messages) {
        String customeFriendPath;
        customeFriendPath = MessagedPath + File.separator + id;
        File folder = new File(customeFriendPath);
        folder.mkdir();
        File file = new File(customeFriendPath, messageFile);
        try {
            chatMessageMangment.setFileOutputChatMessage(new FileOutputStream(file));
            chatMessageMangment.add(messages);
            chatMessageMangment.getFileOutputChatMessage().close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void updateMessage(String id, List<$_Message> messages) {
        deleteMessage(id, MessagedPath);
        storeMessage(id, messages);
    }


    public synchronized void deleteMessage(String id, String chatPath) {
        chatMessageMangment.delete(id, chatPath, 0);
    }


    public Object retriveMessage(String name) {
        String customeFriendPath;

        customeFriendPath = MessagedPath + File.separator + name;
        //File folder = new File(customeFriendPath);
        //folder.mkdir();

        File file = new File(customeFriendPath, messageFile);
        List<$_Message> messages;
        try {
            chatMessageMangment.setFileInputChatMessage(new FileInputStream(file));
            messages = (List<$_Message>) chatMessageMangment.get(messageFile);
            return messages;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }


    public synchronized boolean isExist(String id) {
        return chatMessageMangment.isExist(id, MessagedPath);
    }


    private void removeFolder(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles())
                removeFolder(child);

        fileOrDirectory.delete();
    }


}
