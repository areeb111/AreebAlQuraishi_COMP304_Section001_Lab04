package com.example.abhishekjamwal_comp304section001_labassignment4.Models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class CarSales {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private Integer saleId;
    private Integer custId;
    private Integer carId;
    private String paymentDate;
    private String orderStatus;
    private String amountPaid;
    private String cardName;
    private String cardNumber;
    private String cardExpiry;
    private String cardCVV;

    public void setSaleId(Integer saleId) {this.saleId = saleId;}
    public Integer getSaleId() {return saleId;}
    public Integer getCustId() {return custId;}
    public Integer getCarId() {return carId;}
    public String getPaymentDate() {return paymentDate;}
    public String getOrderStatus() {return orderStatus;}
    public String getAmountPaid() {return amountPaid;}
    public String getCardName() {return cardName;}
    public String getCardNumber() {return  cardNumber;}
    public String getCardExpiry() {return cardExpiry;}
    public String getCardCVV() {return cardCVV;}


    public CarSales (Integer custId, Integer carId, String paymentDate, String orderStatus, String amountPaid, String cardName, String cardNumber, String cardExpiry, String cardCVV) {
        this.custId = custId;
        this.carId = carId;
        this.paymentDate = paymentDate;
        this.orderStatus = orderStatus;
        this.amountPaid = amountPaid;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.cardExpiry = cardExpiry;
        this.cardCVV = cardCVV;
    }
}
