package com.example.abhishekjamwal_comp304section001_labassignment4.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.abhishekjamwal_comp304section001_labassignment4.CustomerAndSales;
import com.example.abhishekjamwal_comp304section001_labassignment4.Models.CarSales;
import com.example.abhishekjamwal_comp304section001_labassignment4.Models.Cars;

import java.util.List;

@Dao
public interface CarSalesDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertSale(CarSales sale);

    @Delete
    public void deleteSale(CarSales sale);


    @Query("SELECT * FROM carsales ORDER BY carId DESC")
    public LiveData<List<CarSales>> loadAllCarSales();

    @Query("SELECT * FROM carsales WHERE custId = :custId ORDER BY saleId DESC")
    LiveData<List<CarSales>> loadAllSales(Integer custId);

}
