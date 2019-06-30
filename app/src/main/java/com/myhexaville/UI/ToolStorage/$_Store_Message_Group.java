package com.myhexaville.UI.ToolStorage;

import com.myhexaville.Logic.MessagesChats.$_ChatMessageGroupMangment;
import com.myhexaville.UI.Adapter.AdapterRoomChat.Message.$_Message;
import com.myhexaville.login.MainActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class $_Store_Message_Group {
    private $_ChatMessageGroupMangment chatMessageGroupMangment;
    private String messageGroupPath;
    private String messageGroupFile;

    public $_Store_Message_Group($_ChatMessageGroupMangment chatMessageGroupMangment) {
        this.chatMessageGroupMangment = chatMessageGroupMangment;
        //removeFolder(new File(MainActivity.context.getFilesDir() + "/Chat"));
        // init Folder's
        FriendPathMangment.MainPath = MainActivity.context.getFilesDir() + "/Chat";
        FriendPathMangment.FriendPath = FriendPathMangment.MainPath + "/Friend";
        FriendPathMangment.AccountPath = FriendPathMangment.MainPath + "/Account";
        new File(FriendPathMangment.MainPath).mkdir();
        new File(FriendPathMangment.FriendPath).mkdir();
        new File(FriendPathMangment.AccountPath).mkdir();

        //init
        this.messageGroupPath = FriendPathMangment.FriendPath;
        this.messageGroupFile = "MessageGroup.Fi";

    }

    public String getMessageGroupFile() {
        return messageGroupFile;
    }

    public void setMessageGroupFile(String messageGroupFile) {
        this.messageGroupFile = messageGroupFile;
    }

    public $_ChatMessageGroupMangment getChatMessageGroupMangment() {
        return chatMessageGroupMangment;
    }

    public void setChatMessageGroupMangment($_ChatMessageGroupMangment chatMessageGroupMangment) {
        this.chatMessageGroupMangment = chatMessageGroupMangment;
    }

    public synchronized void storeMessage(String id, String idGroup, List<$_Message> messages) {
        String customeFriendPath;
        customeFriendPath = messageGroupPath + File.separator + id + File.separator + "Groups";
        System.out.println("PAAAATTHHH = " + customeFriendPath + "     " + id);
        File folder = new File(customeFriendPath);
        if (!folder.exists())
            folder.mkdir();
        File file = new File(customeFriendPath, messageGroupFile);
        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO === " + file.exists());
        try {
            chatMessageGroupMangment.setFileOutputChatMessage(new FileOutputStream(file));
            chatMessageGroupMangment.add(messages);
            chatMessageGroupMangment.getFileOutputChatMessage().close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void updateMessage(String id, String idGroup, List<$_Message> messages) {
        deleteMessage(id, messageGroupPath);
        storeMessage(id, idGroup, messages);
    }


    public synchronized void deleteMessage(String id, String chatPath) {
        chatMessageGroupMangment.delete(id, chatPath, 0);
    }


    public Object retriveMessage(String name) {
        String customeFriendPath;

        customeFriendPath = messageGroupPath + File.separator + name + File.separator + "Groups";
        //File folder = new File(customeFriendPath);
        //folder.mkdir();

        File file = new File(customeFriendPath, messageGroupFile);
        List<$_Message> messages;
        try {
            chatMessageGroupMangment.setFileInputChatMessage(new FileInputStream(file));
            messages = (List<$_Message>) chatMessageGroupMangment.get(messageGroupFile);
            return messages;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return "";
    }


    public synchronized boolean isExist(String id) {
        return chatMessageGroupMangment.isExist(id, messageGroupPath);
    }


    private void removeFolder(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles())
                removeFolder(child);

        fileOrDirectory.delete();
    }
}
