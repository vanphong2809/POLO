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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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
public class OrderModel {
    public List<Order> GetOrderByUser(int id){
        Connection conn=null;
        CallableStatement callSt=null;
        ArrayList<Order> list=new ArrayList<>();
        try {
            conn=ConnectionDB.openConnect();
            callSt=conn.prepareCall("{call getInforOrderByUser(?)}");
            callSt.setInt(1, id);
            ResultSet rs=callSt.executeQuery();
            while(rs.next()){
                Order order=new Order();
                order.setOrderId(rs.getInt("OrderId"));
                order.setOrderName(rs.getString("OrderName"));
                order.setOrderNumber(rs.getString("OrderNumber"));
                order.setPhone(rs.getString("Phone"));
                order.setEmail(rs.getString("Email"));
                order.setAddress(rs.getString("Address"));
                order.setTotalAmount(rs.getInt("TotalAmount"));
                order.setPaymentDate(rs.getString("PaymentDate"));
                order.setCreated(rs.getString("CreateDate"));
                order.setStatus(rs.getInt("Status"));
                order.setUserId(rs.getInt("UserId"));
                order.setPaymentMethod(rs.getString("PaymentMethod"));
                order.setDescription(rs.getString("Description"));
                order.setPaymentStatus(rs.getString("PaymentStatus"));
                order.setTransportStatus(rs.getString("TransportStatus"));
                list.add(order);
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ConnectionDB.closeConnect(conn, callSt);
        }
        return list;
    }
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
    
    public List<Order> GetAllOrder(){
        SimpleDateFormat fomat = new SimpleDateFormat("dd-MM-yyyy");
        Connection conn=null;
        CallableStatement callSt=null;
        List<Order> list=new ArrayList<>();
        try {
            conn=ConnectionDB.openConnect();
            callSt=conn.prepareCall("{call GetAllOrder()}");
            ResultSet rs=callSt.executeQuery();
            while(rs.next()){
                Order order=new Order();
                order.setOrderId(rs.getInt("OrderId"));
                order.setOrderName(rs.getString("OrderName"));
                order.setOrderNumber(rs.getString("OrderNumber"));
                order.setPhone(rs.getString("Phone"));
                order.setEmail(rs.getString("Email"));
                order.setAddress(rs.getString("Address"));
                order.setTotalAmount(rs.getInt("TotalAmount"));
                if(rs.getDate("PaymentDate")!=null){
                    order.setPaymentDate(fomat.format(rs.getDate("PaymentDate")));
                }
                if(rs.getDate("CreateDate")!=null){
                    order.setCreated(fomat.format(rs.getDate("CreateDate")));
                }
                order.setStatus(rs.getInt("Status"));
                order.setUserId(rs.getInt("UserId"));
                order.setPaymentMethod(rs.getString("PaymentMethod"));
                order.setDescription(rs.getString("Description"));
                order.setPaymentStatus(rs.getString("PaymentStatus"));
                order.setTransportStatus(rs.getString("TransportStatus"));
                list.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ConnectionDB.closeConnect(conn, callSt);
        }
        return list;
    }
}
