package com.myhexaville.Logic.Tools;


import java.io.IOException;

public interface $_Tools {

    boolean update(Object object, String FriendPath) throws IOException;

    boolean add(Object object) throws IOException;

    boolean delete(String id, String FriendPath, int positinon);

    boolean isExist(String name, String FriendPath);

    Object get(String id) throws IOException;
}
