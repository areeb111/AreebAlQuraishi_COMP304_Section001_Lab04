package com.example.abhishekjamwal_comp304section001_labassignment4.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.abhishekjamwal_comp304section001_labassignment4.CustomerAndSales;
import com.example.abhishekjamwal_comp304section001_labassignment4.Models.CarSales;

import java.util.List;

@Dao
public interface CarSalesDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertSales(List<CarSales> sales);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertSale(CarSales sale);

    @Delete
    public void deleteSale(CarSales sale);

    @Query("SELECT * FROM carsales ORDER BY saleId DESC")
    public LiveData<List<CarSales>> loadAllSales();

    @Query("SELECT * FROM carsales ORDER BY saleId DESC")
    public LiveData<List<CustomerAndSales>> getAllCusWithSales();

}
