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
public class ProductSize {
    private int productSizeId;
    private int sizeId;
    private String sizeName;
    private int productId;
    private Boolean status;

    public ProductSize() {
    }

    public ProductSize(int productSizeId, int sizeId, String sizeName, int productId, Boolean status) {
        this.productSizeId = productSizeId;
        this.sizeId = sizeId;
        this.sizeName = sizeName;
        this.productId = productId;
        this.status = status;
    }

    public int getProductSizeId() {
        return productSizeId;
    }

    public void setProductSizeId(int productSizeId) {
        this.productSizeId = productSizeId;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
}
