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
public class Product {
    private int productId;
    private String productName;
    private String productContent;
    private String productContentDetail;
    private String images;
    private int view;
    private int buyItem;
    private int priceInput;
    private int priceOutput;
    private int quantity;
    private int catalogId;
    private int providerId;
    private String created;
    private boolean status;
    private String imageHover;
    private int discount;
    private String imageLink;
    private int priceDiscount;
    public Product() {
    }

    public Product(int productId, String productName, String productContent, String productContentDetail, String images, int view, int buyItem, int priceInput, int priceOutput, int quantity, int catalogId, int providerId, String created, boolean status, String imageHover, int discount, String imageLink, int priceDiscount) {
        this.productId = productId;
        this.productName = productName;
        this.productContent = productContent;
        this.productContentDetail = productContentDetail;
        this.images = images;
        this.view = view;
        this.buyItem = buyItem;
        this.priceInput = priceInput;
        this.priceOutput = priceOutput;
        this.quantity = quantity;
        this.catalogId = catalogId;
        this.providerId = providerId;
        this.created = created;
        this.status = status;
        this.imageHover = imageHover;
        this.discount = discount;
        this.imageLink = imageLink;
        this.priceDiscount = priceDiscount;
    }

    public Product(int priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductContent() {
        return productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent;
    }

    public String getProductContentDetail() {
        return productContentDetail;
    }

    public void setProductContentDetail(String productContentDetail) {
        this.productContentDetail = productContentDetail;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getBuyItem() {
        return buyItem;
    }

    public void setBuyItem(int buyItem) {
        this.buyItem = buyItem;
    }

    public int getPriceInput() {
        return priceInput;
    }

    public void setPriceInput(int priceInput) {
        this.priceInput = priceInput;
    }

    public int getPriceOutput() {
        return priceOutput;
    }

    public void setPriceOutput(int priceOutput) {
        this.priceOutput = priceOutput;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getImageHover() {
        return imageHover;
    }

    public void setImageHover(String imageHover) {
        this.imageHover = imageHover;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public int getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(int priceDiscount) {
        this.priceDiscount = priceDiscount;
    }
    
}
