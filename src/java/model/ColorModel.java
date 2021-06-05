/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Color;
import entity.Product;
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
     public boolean updateColor(Color color) throws ParseException {
        Connection conn = null;
        CallableStatement calla = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnect();
            calla = conn.prepareCall("{call updateColor(?,?,?)}");
            calla.setInt(1, color.getColorId()); 
            calla.setString(2, color.getColorName());
            calla.setString(3, color.getNatation());
              
            calla.executeUpdate();
            result = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.closeConnect(conn, calla);
        }
        return result;
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
     public Color GetColorById(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Color color=new Color();
        try {
            conn = ConnectionDB.openConnect();
            callSt = conn.prepareCall("{call getColorById(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                color.setColorId(rs.getInt("ColorId"));
                color.setColorName(rs.getString("ColorName"));
                color.setStatus(rs.getBoolean("Status"));
                color.setNatation(rs.getString("Natation"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnect(conn, callSt);
        }
        return color;
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
    public boolean deleteColor(int id){
        Connection conn=null;
        CallableStatement callSt=null;
        boolean result=false;
        try {
            conn=ConnectionDB.openConnect();
            callSt=conn.prepareCall("{call deleteColor(?)}");
            callSt.setInt(1, id);
            callSt.executeUpdate();
            result=true;
        } catch (Exception e) {
            Logger.getLogger(CatalogModel.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            ConnectionDB.closeConnect(conn, callSt);
        }
        return result;
    }
}
