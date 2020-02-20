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
import java.util.ArrayList;
import java.util.List;
import util.ConnectionDB;

/**
 *
 * @author Win 10
 */
public class CatalogModel {
    public List<Catalog> getAllCatalog(){
        Connection conn=null;
        CallableStatement callSt=null;
        List<Catalog> list=new ArrayList<Catalog>();
        try {
            conn=ConnectionDB.openConnect();
            callSt=conn.prepareCall("{call getAllCatalog()}");
            ResultSet rs=callSt.executeQuery();
            while(rs.next()){
                Catalog c=new Catalog();
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
        }
        finally{
            ConnectionDB.closeConnect(conn, callSt);
        }
        return list;
    }
}
