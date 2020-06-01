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
public class Color {
    private int colorId;
    private String colorName;
    private boolean status;
    private String natation;

    public Color() {
    }

    public Color(int colorId, String colorName, boolean status, String natation) {
        this.colorId = colorId;
        this.colorName = colorName;
        this.status = status;
        this.natation = natation;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getNatation() {
        return natation;
    }

    public void setNatation(String natation) {
        this.natation = natation;
    }
    
}
