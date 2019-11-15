package com.DAO;

import com.bean.User;
import com.util.ConnectionDB1;
import com.inter.InterfaceUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class userDao implements InterfaceUser {
    @Override
    public List<User> getAllUsers(){
        List<User> list = new ArrayList<User>();
        Connection conn = ConnectionDB1.getCon();
        String sql = "select * from thing";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                list.add(user);
            }
            rs.close();
            pst.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public User userLogin(String username, String passwords) {
        User user = null;
        PreparedStatement pst = null;
        Connection conn = ConnectionDB1.getCon();
        String sql = "select * from thing where username= ? and password= ?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1,username);
            pst.setString(2,passwords);
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
            pst.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
    @Override
    public boolean register(User user){
        Connection conn = ConnectionDB1.getCon();
        String sql = "insert into thing(id, username, password) values(?,?,?)";
        int i = 0;
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, user.getId());
            pst.setString(2, user.getUsername());
            pst.setString(3, user.getPassword());
            i = pst.executeUpdate();
            pst.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return i > 0;
    }

    @Override
    public boolean updateUser(User user){
        Connection conn = ConnectionDB1.getCon();
        String sql = "UPDATE thing SET username=?, password=? where id=?";
        int i = 0;
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setInt(3,user.getId());
            i = pst.executeUpdate();
            pst.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return i > 0;
    }

    @Override
    public boolean deleteUser(User user){
        Connection conn = ConnectionDB1.getCon();
        System.out.println("到达删除");
        String sql = "DELETE FROM thing where id = " + user.getId();
        System.out.println("数据库操作删除成功");
        int i = 0;
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            i = pst.executeUpdate();
            pst.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return i > 0;
    }

}
