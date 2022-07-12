package com.example.abhishekjamwal_comp304section001_labassignment4;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.abhishekjamwal_comp304section001_labassignment4.Models.CarSales;
import com.example.abhishekjamwal_comp304section001_labassignment4.Models.Customers;

public class CustomerAndSales {
    @Embedded
    public Customers customer;
    @Relation(
            parentColumn = "custId",
            entityColumn = "custId"
    )
    public CarSales carSale;
}
