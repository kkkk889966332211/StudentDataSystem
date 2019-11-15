package com.inter;

import com.bean.User;

import java.util.List;

public interface InterfaceUser {
    public List<User> getAllUsers();
    public User userLogin(String username, String passwords);
    public boolean register(User user);
    public boolean updateUser(User user);
    public boolean deleteUser(User user);
}
