/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Color;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionDB;

/**
 *
 * @author Win 10
 */
public class ColorModel {

    public List<Color> GetAllColor() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Color> list = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnect();
            callSt = conn.prepareCall("{call getAllColor()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Color c = new Color();
                c.setColorId(rs.getInt("ColorId"));
                c.setColorName(rs.getString("ColorName"));
                c.setStatus(rs.getBoolean("Status"));
                c.setNatation(rs.getString("Natation"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnect(conn, callSt);
        }
        return list;
    }

    public List<Color> GetColorByProductId(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Color> list = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnect();
            callSt = conn.prepareCall("{call getColorByProductId(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Color c = new Color();
                c.setColorId(rs.getInt("ColorId"));
                c.setColorName(rs.getString("ColorName"));
                c.setStatus(rs.getBoolean("Status"));
                c.setNatation(rs.getString("Natation"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnect(conn, callSt);
        }
        return list;
    }

    public boolean InsertColor(Color color) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnect();
            callSt = conn.prepareCall("{call InsertColor(?,?)}");
            callSt.setString(1, color.getColorName());
            callSt.setString(2, color.getNatation());
            callSt.executeUpdate();
            result=true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ConnectionDB.closeConnect(conn, callSt);
        }
        return result;
    }
}
