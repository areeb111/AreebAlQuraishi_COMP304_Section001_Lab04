package com.example.abhishekjamwal_comp304section001_labassignment4.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Cars {
    @PrimaryKey(autoGenerate = true)
    private Integer carId;
    private String brandName;
    private String modelName;
    private String price;
    private String color;
    private String transmission;
    private Integer year;

    public void setCarId(Integer carId) {this.carId = carId;}
    public Integer getCarId() {return carId;}
    public String getBrandName() {return brandName;}
    public String getModelName() {return modelName;}
    public String getPrice() {return price;}
    public String getColor() {return color;}
    public String getTransmission() {return transmission;}
    public Integer getYear() { return year;}


    public Cars (String brandName, String modelName, String price, String color, String transmission, Integer year) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.price = price;
        this.color = color;
        this.transmission = transmission;
        this.year = year;
    }
}
