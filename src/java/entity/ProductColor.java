/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Win 10
 */
public class ProductColor {
    private int productColorId;
    private int productId;
    private int colorId;
    private String colorName;
    private String natation;
    private Boolean status;

    public ProductColor() {
    }

    public ProductColor(int productColorId, int productId, int colorId, String colorName, String natation, Boolean status) {
        this.productColorId = productColorId;
        this.productId = productId;
        this.colorId = colorId;
        this.colorName = colorName;
        this.natation = natation;
        this.status = status;
    }

    public int getProductColorId() {
        return productColorId;
    }

    public void setProductColorId(int productColorId) {
        this.productColorId = productColorId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getNatation() {
        return natation;
    }

    public void setNatation(String natation) {
        this.natation = natation;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
}
