/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Catalog;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConnectionDB;

/**
 *
 * @author Win 10
 */
public class CatalogModel {

    public List<Catalog> getAllCatalog() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Catalog> list = new ArrayList<Catalog>();
        try {
            conn = ConnectionDB.openConnect();
            callSt = conn.prepareCall("{call getAllCatalog()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Catalog c = new Catalog();
                c.setCatalogId(rs.getInt("CatalogId"));
                c.setCatalogName(rs.getString("CatalogName"));
                c.setDescriptions(rs.getString("Descriptions"));
                c.setParentId(rs.getInt("ParentId"));
                c.setStatus(rs.getBoolean("Status"));
                c.setImages(rs.getString("Images"));
                c.setDisplayNumber(rs.getInt("DisplayNumber"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnect(conn, callSt);
        }
        return list;
    }

    public boolean insertCatalog(Catalog catalog) {
        Connection conn = null;
        CallableStatement calla = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnect();
            calla = conn.prepareCall("{ call insertCatalog(?,?,?,?,?)}");
            calla.setString(1, catalog.getCatalogName());
            calla.setString(2, catalog.getDescriptions());
            calla.setInt(3, catalog.getParentId());
            calla.setString(4, catalog.getImages());
            calla.setInt(5, catalog.getDisplayNumber());
            calla.executeUpdate();
            result = true;
        } catch (SQLException ex) {
            Logger.getLogger(CatalogModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.closeConnect(conn, calla);
        }
        return result;
    }

    public Catalog GetCatalogById(int id) {
        Connection conn = null;
        CallableStatement calla = null;
        Catalog catalog=new Catalog();
        try {
            conn = ConnectionDB.openConnect();
            calla = conn.prepareCall("{call GetCatalogById(?)}");
            calla.setInt(1, id);
            ResultSet rs = calla.executeQuery();
            while (rs.next()) {
                catalog.setCatalogId(id);
                catalog.setCatalogName(rs.getString("CatalogName"));
                catalog.setDescriptions(rs.getString("Descriptions"));
                catalog.setParentId(rs.getInt("ParentId"));
                catalog.setImages(rs.getString("Images"));
                catalog.setDisplayNumber(rs.getInt("DisplayNumber"));
                catalog.setStatus(rs.getBoolean("Status"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CatalogModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.closeConnect(conn, calla);
        }
        return catalog;
    }
    public boolean updateCatalog(Catalog catalog){
        Connection conn = null;
        CallableStatement calla = null;
        boolean result = false;
        
        try {
            conn = ConnectionDB.openConnect();
            calla = conn.prepareCall("{call updateCatalog(?,?,?,?,?,?,?)}");
            calla.setInt(1, catalog.getCatalogId());
            calla.setString(2, catalog.getCatalogName());
            calla.setString(3, catalog.getDescriptions());
            calla.setInt(4, catalog.getParentId());
            calla.setBoolean(5, catalog.isStatus());
            calla.setString(6, catalog.getImages());
            calla.setInt(7, catalog.getDisplayNumber());                     
            calla.executeUpdate();
            result = true;
        } catch (SQLException ex) {
            Logger.getLogger(CatalogModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionDB.closeConnect(conn, calla);
        }
        return result;
    }
}
