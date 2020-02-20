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
public class ImageLink {
    private int imageLinkId;
    private String imageLinkName;
    private int productId;
    private boolean status;
    private int purpose;
    public ImageLink() {
    }

    public ImageLink(int imageLinkId, String imageLinkName, int productId, boolean status, int purpose) {
        this.imageLinkId = imageLinkId;
        this.imageLinkName = imageLinkName;
        this.productId = productId;
        this.status = status;
        this.purpose = purpose;
    }

    public int getImageLinkId() {
        return imageLinkId;
    }

    public void setImageLinkId(int imageLinkId) {
        this.imageLinkId = imageLinkId;
    }

    public String getImageLinkName() {
        return imageLinkName;
    }

    public void setImageLinkName(String imageLinkName) {
        this.imageLinkName = imageLinkName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPurpose() {
        return purpose;
    }

    public void setPurpose(int purpose) {
        this.purpose = purpose;
    }
    
}
