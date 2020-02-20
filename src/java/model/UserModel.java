/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import util.CheckEmail;
import util.ConnectionDB;

/**
 *
 * @author Win 10
 */
public class UserModel {
    public boolean register(User user){
        Connection conn=null;
        CallableStatement callSt=null;
        boolean check=false;
        try {
            conn=ConnectionDB.openConnect();
            callSt=conn.prepareCall("{call register(?,?,?,?,?)}");
            callSt.setString(1, user.getUserName());
            callSt.setString(2, user.getPassword());
            callSt.setString(3, user.getEmail());
            callSt.setString(4, user.getAddress());
            callSt.setString(5, user.getPhone());
            callSt.executeUpdate();
            check=true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ConnectionDB.closeConnect(conn, callSt);
        }
        return check;
    }
    
    public User getUserByEmail(String email){
        SimpleDateFormat format= new SimpleDateFormat("dd-MM-yyyy");
        Connection conn=null;
        CallableStatement callSt=null;
        User user = new User();
        try {
            conn=ConnectionDB.openConnect();
            callSt=conn.prepareCall("{call getUserByEmail(?)}");
            callSt.setString(1, email);
            ResultSet rs=callSt.executeQuery();
            while(rs.next()){
                user.setUserId(rs.getInt("UserId"));
                user.setUserName(rs.getString("UserName"));
                user.setPassword(rs.getString("Password"));
                user.setEmail(rs.getString("Email"));
                user.setAddress(rs.getString("Address"));
                user.setPhone(rs.getString("Phone"));
                user.setGroupId(rs.getInt("GroupId"));
                user.setStatus(rs.getBoolean("Status"));
                if (rs.getDate("Created") != null) {
                    user.setCreated(format.format(rs.getDate("Created")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ConnectionDB.closeConnect(conn, callSt);
        }
        return user;
    }
}
