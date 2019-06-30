package com.myhexaville.Logic.MessagesChats;

import com.myhexaville.Logic.Tools.$_Tools;
import com.myhexaville.UI.Adapter.AdapterRoomChat.Message.$_Message;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class $_ChatMessageGroupMangment implements $_Tools {
    private FileInputStream fileInputChatMessage;
    private FileOutputStream fileOutputChatMessage;
    private String messageFile;


    @Override
    public boolean update(Object object, String FriendPath) throws IOException {
        $_Message message = ($_Message) object;
        String id = message.getId();
        if (!isExist(id, FriendPath)) return false;
        delete(id, FriendPath, 0);
        add(message);
        return true;
    }

    @Override
    public boolean add(Object object) {
        List<$_Message> message = (List<$_Message>) object;
        //if (isExist(file_name)) return false;
        try {
            ObjectOutputStream out = new ObjectOutputStream(fileOutputChatMessage);
            out.writeObject(message);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String id, String MessageChatPath, int positinon) {
        if (!isExist(id, MessageChatPath)) return false;
        File message_file = new File(MessageChatPath + File.separator + id + File.separator + this.messageFile);
        message_file.delete();
        return true;
    }

    @Override
    public boolean isExist(String name, String MessageChatPath) {
        File Chat_folder = new File(MessageChatPath);
        for (File Friend : Chat_folder.listFiles()) {
            File fileMessage = new File(Friend.getAbsolutePath() + File.separator + messageFile);
            if (fileMessage.exists()) return true;
        }
        return false;
    }

    @Override
    public Object get(String id) {
        List<$_Message> messages = null;

        try {
            ObjectInputStream in = new ObjectInputStream(fileInputChatMessage);
            messages = (List<$_Message>) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return messages;
    }

    public FileInputStream getFileInputChatMessage() {
        return fileInputChatMessage;
    }

    public void setFileInputChatMessage(FileInputStream fileInputChatMessage) {
        this.fileInputChatMessage = fileInputChatMessage;
    }

    public FileOutputStream getFileOutputChatMessage() {
        return fileOutputChatMessage;
    }

    public void setFileOutputChatMessage(FileOutputStream fileOutputChatMessage) {
        this.fileOutputChatMessage = fileOutputChatMessage;
    }

    public String getMessageFile() {
        return messageFile;
    }

    public void setMessageFile(String messageFile) {
        this.messageFile = messageFile;
    }
}
