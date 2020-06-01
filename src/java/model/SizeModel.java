/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Size;
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
public class SizeModel {
    public List<Size> GetAllSize(){
        Connection conn=null;
        CallableStatement callSt=null;
        List<Size> list=new ArrayList<>();
        try {
            conn=ConnectionDB.openConnect();
            callSt=conn.prepareCall("{call GetAllSize()}");
            ResultSet rs=callSt.executeQuery();
            while(rs.next()){
                Size s=new Size();
                s.setSizeId(rs.getInt("SizeId"));
                s.setSizeName(rs.getString("SizeName"));
                s.setDescription(rs.getString("Descriptions"));
                s.setStatus(rs.getBoolean("Status"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ConnectionDB.closeConnect(conn, callSt);
        }
        return list;
    }
    public boolean InsertSize(Size size){
        Connection conn=null;
        CallableStatement callSt=null;
        boolean check=false;
        try {
            conn=ConnectionDB.openConnect();
            callSt=conn.prepareCall("{call InsertSize(?,?)}");
            callSt.setString(1, size.getSizeName());
            callSt.setString(2, size.getDescription());
            callSt.executeUpdate();
            check=true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ConnectionDB.closeConnect(conn, callSt);
        }
        return check;
    }
}
