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
public class Payment {
    private String merchantName;
    private String accNo;
    private String accName;
    private float paymentAmount;
    private int cardId;
    private int numberSeri;

    public Payment() {
    }

    public Payment(String merchantName, String accNo, String accName, float paymentAmount, int cardId, int numberSeri) {
        this.merchantName = merchantName;
        this.accNo = accNo;
        this.accName = accName;
        this.paymentAmount = paymentAmount;
        this.cardId = cardId;
        this.numberSeri = numberSeri;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public float getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(float paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getNumberSeri() {
        return numberSeri;
    }

    public void setNumberSeri(int numberSeri) {
        this.numberSeri = numberSeri;
    }
    
}
