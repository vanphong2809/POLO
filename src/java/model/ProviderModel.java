/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Provider;
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
public class ProviderModel {
    public List<Provider> getAllProvider(){
        Connection conn=null;
        CallableStatement callSt=null;
        List<Provider> list=new ArrayList<Provider>();
        try {
            conn=ConnectionDB.openConnect();
            callSt=conn.prepareCall("{call getAllProvider()}");
            ResultSet rs=callSt.executeQuery();
            while(rs.next()){
                Provider p=new Provider();
                p.setProviderId(rs.getInt("ProviderId"));
                p.setProviderName(rs.getString("ProviderName"));
                p.setAddress(rs.getString("Address"));
                p.setEmail(rs.getString("Email"));
                p.setPhone(rs.getString("Phone"));
                p.setStatus(rs.getBoolean("Status"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ConnectionDB.closeConnect(conn, callSt);
        }
        return list;
    }
}
