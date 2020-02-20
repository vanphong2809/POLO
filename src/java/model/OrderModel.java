/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Order;
import entity.OrderDetail;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConnectionDB;

/**
 *
 * @author Win 10
 */
public class OrderModel {
    public void insertOrder(Order order){
         Connection conn = null;
         CallableStatement calla = null;
        try {
            conn = ConnectionDB.openConnect();
            calla = conn.prepareCall("{ call insertOrder(?,?,?,?,?,?,?)}");
            calla.setString(1, order.getOrderName());
            calla.setString(2, order.getPhone());
            calla.setString(3, order.getEmail());
            calla.setString(4, order.getAddress());
            calla.setInt(5, order.getTotalAmount());
            calla.setInt(6, order.getUserId());
            calla.setString(7, order.getDescription());
            calla.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionDB.closeConnect(conn, calla);
        }
    }
    public void insertOrderDetail(OrderDetail orderDetail){
         Connection conn = null;
         CallableStatement calla = null;
         boolean result = false;
        try {
            conn = ConnectionDB.openConnect();
            calla = conn.prepareCall("{ call insertOrderDetail(?,?,?,?,?,?)}");
            calla.setInt(1, orderDetail.getOrderId());
            calla.setInt(2, orderDetail.getProductId());
            calla.setInt(3, orderDetail.getAmount());
            calla.setInt(4,  orderDetail.getPrice());
            calla.setInt(5, orderDetail.getQuantity());
            calla.setString(6,orderDetail.getNote());
            calla.executeUpdate();
            result = true;
        } catch (SQLException ex) {
            Logger.getLogger(OrderModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionDB.closeConnect(conn, calla);
        }
    }
    
    public int getOrderIdNew(){
        Connection conn=null;
        CallableStatement callSt=null;
        int orderId=0;
        try {
            conn=ConnectionDB.openConnect();
            callSt=conn.prepareCall("{call getOrderIdNew(?)}");
            callSt.registerOutParameter(1, Types.INTEGER);
            callSt.executeUpdate();
            orderId=callSt.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ConnectionDB.closeConnect(conn, callSt);
        }
        return orderId;
    }
    
    public void updateBuyItem(int id, int quantity){
        Connection conn=null;
        CallableStatement callSt=null;
        try {
            conn=ConnectionDB.openConnect();
            callSt=conn.prepareCall("{call updateBuyItem(?,?)}");
            callSt.setInt(1, id);
            callSt.setInt(2, quantity);
            callSt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ConnectionDB.closeConnect(conn, callSt);
        }
    }
}
