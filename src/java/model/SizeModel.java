/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Color;
import entity.Size;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConnectionDB;

/**
 *
 * @author Win 10
 */
public class SizeModel {

    public List<Size> GetAllSize() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Size> list = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnect();
            callSt = conn.prepareCall("{call GetAllSize()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Size s = new Size();
                s.setSizeId(rs.getInt("SizeId"));
                s.setSizeName(rs.getString("SizeName"));
                s.setDescription(rs.getString("Descriptions"));
                s.setStatus(rs.getBoolean("Status"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnect(conn, callSt);
        }
        return list;
    }

    public boolean InsertSize(Size size) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean check = false;
        try {
            conn = ConnectionDB.openConnect();
            callSt = conn.prepareCall("{call InsertSize(?,?)}");
            callSt.setString(1, size.getSizeName());
            callSt.setString(2, size.getDescription());
            callSt.executeUpdate();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnect(conn, callSt);
        }
        return check;
    }

    public boolean deleteSize(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnect();
            callSt = conn.prepareCall("{call deleteSize(?)}");
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
      public Size GetSizeById(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Size size=new Size();
        try {
            conn = ConnectionDB.openConnect();
            callSt = conn.prepareCall("{call getSizeById(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                size.setSizeId(rs.getInt("SizeId"));
                size.setSizeName(rs.getString("SizeName"));
                size.setStatus(rs.getBoolean("Status"));
                size.setDescription(rs.getString("Descriptions"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnect(conn, callSt);
        }
        return size;
    }
     public boolean updateSize(Size size) throws ParseException {
        Connection conn = null;
        CallableStatement calla = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnect();
            calla = conn.prepareCall("{call updateSize(?,?,?)}");
            calla.setInt(1, size.getSizeId()); 
            calla.setString(2, size.getSizeName());
            calla.setString(3, size.getDescription());
              
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
