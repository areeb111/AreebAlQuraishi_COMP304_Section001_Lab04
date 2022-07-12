package com.example.abhishekjamwal_comp304section001_labassignment4.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.abhishekjamwal_comp304section001_labassignment4.Models.Cars;

import java.util.List;

@Dao
public interface CarsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertCars(List<Cars> cars);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertCar(Cars car);

    @Query("SELECT * FROM cars ORDER BY carId DESC")
    public LiveData<List<Cars>> getAllCars();

    @Query("SELECT * FROM cars WHERE carId = :carId")
    public LiveData<Cars> getCar(Integer carId);
}
