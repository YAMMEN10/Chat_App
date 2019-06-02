package com.myhexaville.UI.ToolStorage;

import com.myhexaville.Logic.Friend.$_FriendInfo;
import com.myhexaville.Logic.Friend.$_FriendStorgeMangement;
import com.myhexaville.login.MainActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class $_Store_Friend {
    private $_FriendStorgeMangement friendStorgeMangement;
    private String FriendPath;

    public $_Store_Friend($_FriendStorgeMangement friendStorgeMangement) {
        this.friendStorgeMangement = friendStorgeMangement;
        //removeFolder(new File(MainActivity.context.getFilesDir() + "/Chat"));
        // init Folder's
        FriendPathMangment.MainPath = MainActivity.context.getFilesDir() + "/Chat";
        FriendPathMangment.FriendPath = FriendPathMangment.MainPath + "/Friend";
        FriendPathMangment.AccountPath = FriendPathMangment.MainPath + "/Account";
        new File(FriendPathMangment.MainPath).mkdir();
        new File(FriendPathMangment.FriendPath).mkdir();
        new File(FriendPathMangment.AccountPath).mkdir();

        //init
        this.FriendPath = FriendPathMangment.FriendPath;

    }


    public void storeFriend(String name, String user_name, String state, byte[] image) {
        String customeFriendPath;

        customeFriendPath = FriendPath + File.separator + name;

        File folder = new File(customeFriendPath);
        folder.mkdir();

        File file = new File(customeFriendPath, name + ".Fi");
        try {
            friendStorgeMangement.setFileOutputFriend(new FileOutputStream(file));
            friendStorgeMangement.add(new $_FriendInfo(name, user_name, image, state));
            friendStorgeMangement.getFileOutputFriend().close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object retriveFriend(String name) {
        String customeFriendPath;

        customeFriendPath = FriendPath + File.separator + name;
        //File folder = new File(customeFriendPath);
        //folder.mkdir();

        File file = new File(customeFriendPath, name + ".Fi");
        $_FriendInfo friendInfo;
        try {
            friendStorgeMangement.setFileInputFriend(new FileInputStream(file));

            friendInfo = ($_FriendInfo) friendStorgeMangement.get(name + ".Fi");
            return friendInfo;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void removeFriend(String name) {
        String customeFriendPath;

        customeFriendPath = FriendPath + File.separator + name;
        File folder = new File(customeFriendPath);
        folder.mkdir();

        friendStorgeMangement.delete(name, customeFriendPath, 0);
    }

    public void removeFolder(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles())
                removeFolder(child);

        fileOrDirectory.delete();
    }

    public String getFriendPath() {
        return FriendPath;
    }

    public void setFriendPath(String friendPath) {
        FriendPath = friendPath;
    }

}
