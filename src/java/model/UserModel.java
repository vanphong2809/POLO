/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Color;
import entity.Group;
import entity.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.CheckEmail;
import util.ConnectionDB;
import util.HashPassword;

/**
 *
 * @author Win 10
 */
public class UserModel {

    private HashPassword hassPass;

    public UserModel() {
        hassPass = new HashPassword();
    }

    public boolean register(User user) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean check = false;
        try {
            conn = ConnectionDB.openConnect();
            callSt = conn.prepareCall("{call register(?,?,?,?,?)}");
            callSt.setString(1, user.getUserName());
            callSt.setString(2, hassPass.getMD5(user.getPassword()));
            callSt.setString(3, user.getEmail());
            callSt.setString(4, user.getAddress());
            callSt.setString(5, user.getPhone());
            callSt.executeUpdate();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnect(conn, callSt);
        }
        return check;
    }

    public User getUserByEmail(String email) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Connection conn = null;
        CallableStatement callSt = null;
        User user = new User();
        try {
            conn = ConnectionDB.openConnect();
            callSt = conn.prepareCall("{call getUserByEmail(?)}");
            callSt.setString(1, email);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
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
        } finally {
            ConnectionDB.closeConnect(conn, callSt);
        }
        return user;
    }

    public List<User> GetAllUser() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<User> list = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnect();
            callSt = conn.prepareCall("{call GetAllUser()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                User user = new User();
                Group group = new Group();
                user.setUserId(rs.getInt("UserId"));
                user.setUserName(rs.getString("UserName"));
                user.setPassword(rs.getString("Password"));
                user.setEmail(rs.getString("Email"));
                user.setAddress(rs.getString("Address"));
                user.setPhone(rs.getString("Phone"));
                user.setGroupId(rs.getInt("GroupId"));
                user.setStatus(rs.getBoolean("Status"));
                user.setCreated(rs.getString("Created"));
                group.setGroupName(rs.getString("GroupName"));
                String groupName = group.getGroupName();
                user.setGroup(new Group(0, groupName, true));
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnect(conn, callSt);
        }
        return list;
    }

    public boolean InsertUser(User user) {
        Connection conn = null;
        CallableStatement callst = null;
        boolean check = false;
        try {
            conn = ConnectionDB.openConnect();
            callst = conn.prepareCall("{call InsertUser(?,?,?,?,?,?)}");
            callst.setString(1, user.getUserName());
            callst.setString(2, hassPass.getMD5(user.getPassword()));
            callst.setString(3, user.getEmail());
            callst.setString(4, user.getAddress());
            callst.setString(5, user.getPhone());
            callst.setInt(6, user.getGroupId());
            callst.executeUpdate();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnect(conn, callst);
        }
        return check;
    }

    public int totalUser() {
        Connection conn = null;
        CallableStatement callSt = null;
        int total = 0;
        try {
            conn = ConnectionDB.openConnect();
            callSt = conn.prepareCall("{call totalUser()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                total = rs.getInt("totalUser");
            }
            return total;
        } catch (Exception e) {
            ConnectionDB.closeConnect(conn, callSt);
        }
        return total;
    }
    public boolean deleteUser(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnect();
            callSt = conn.prepareCall("{call deleteUser(?)}");
            callSt.setInt(1, id);
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            Logger.getLogger(CatalogModel.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionDB.closeConnect(conn, callSt);
        }
        return result;
    }
    public User GetUserById(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        User u=new User();
        try {
            conn = ConnectionDB.openConnect();
            callSt = conn.prepareCall("{call getUserById(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                u.setUserId(rs.getInt("UserId"));
                u.setUserName(rs.getString("UserName"));
                u.setPassword(rs.getString("Password"));
                u.setEmail(rs.getString("Email"));
                u.setAddress(rs.getString("Address"));
                u.setPhone(rs.getString("Phone"));
                u.setGroupId(rs.getInt("GroupId"));
                u.setStatus(rs.getBoolean("Status"));
                u.setCreated(rs.getString("Created"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnect(conn, callSt);
        }
        return u;
    }
    public boolean updateUser(User user) throws ParseException {
        Connection conn = null;
        CallableStatement calla = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnect();
            calla = conn.prepareCall("{call updateUser(?,?,?,?,?,?,?,?)}");
            calla.setInt(1, user.getUserId()); 
            calla.setString(2, user.getUserName());
            calla.setString(3, user.getPassword());
            calla.setString(4, user.getEmail());
            calla.setString(5, user.getAddress());
            calla.setString(6, user.getPhone());
            calla.setInt(7, user.getGroupId());
            calla.setBoolean(8, user.isStatus());
            calla.executeUpdate();
            result = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.closeConnect(conn, calla);
        }
        return result;
    }
}
