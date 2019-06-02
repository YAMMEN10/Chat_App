package com.myhexaville.Logic.Friend;


import com.myhexaville.Logic.Tools.$_Tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class $_FriendStorgeMangement implements $_Tools {

    private FileInputStream fileInputFriend;
    private FileOutputStream fileOutputFriend;

    public FileInputStream getFileInputFriend() {
        return fileInputFriend;
    }

    public void setFileInputFriend(FileInputStream fileInputFriend) {
        this.fileInputFriend = fileInputFriend;
    }

    public FileOutputStream getFileOutputFriend() {
        return fileOutputFriend;
    }

    public void setFileOutputFriend(FileOutputStream fileOutputFriend) {
        this.fileOutputFriend = fileOutputFriend;
    }


    @Override
    public boolean update(Object object, String FriendPath) {
        $_FriendInfo my_Friend = ($_FriendInfo) object;
        String id = my_Friend.getId();
        if (!isExist(id, FriendPath)) return false;
        delete(id, FriendPath, 0);
        add(my_Friend);
        return true;
    }

    @Override
    public boolean add(Object object) {
        $_FriendInfo my_friend = ($_FriendInfo) object;
        String file_name = my_friend.getId();
        //if (isExist(file_name)) return false;
        try {
            ObjectOutputStream out = new ObjectOutputStream(fileOutputFriend);
            out.writeObject(my_friend);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean delete(String id, String FriendPath, int position) {
        if (!isExist(id, FriendPath)) return false;
        File Friend_file = new File(FriendPath + File.pathSeparator + id + ".Fr");
        Friend_file.delete();
        return true;
    }

    @Override
    public boolean isExist(String file_name, String FriendPath) {
        File Friend_folder = new File(FriendPath);
        for (File Friend : Friend_folder.listFiles()) {
            if (Friend.getName().equals(file_name + ".Fr")) return true;
        }
        return false;
    }

    @Override
    public Object get(String id) {
        $_FriendInfo friend = null;

        try {
            ObjectInputStream in = new ObjectInputStream(fileInputFriend);
            friend = ($_FriendInfo) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return friend;
    }
}
