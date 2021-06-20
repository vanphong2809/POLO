/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author TuyenMap
 */
public class OrderDetail {
    private int orderDetailId;
    private int orderId;
    private String productName;
    private int colorId;
    private int sizeId;
    private String note;
    private int productId;
    private int price;
    private int quantity;
    private int amount;
    private boolean status;

    public OrderDetail() {
    }

    public OrderDetail(int orderDetailId, int orderId, String productName, int colorId, int sizeId, String note, int productId, int price, int quantity, int amount, boolean status) {
        this.orderDetailId = orderDetailId;
        this.orderId = orderId;
        this.productName = productName;
        this.colorId = colorId;
        this.sizeId = sizeId;
        this.note = note;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.amount = amount;
        this.status = status;
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

  
    
}
