package com.example.abhishekjamwal_comp304section001_labassignment4.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.abhishekjamwal_comp304section001_labassignment4.Models.Customers;

import java.util.List;

@Dao
public interface CustomersDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertCustomers(List<Customers> customers);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertCustomer(Customers customer);

    @Query("SELECT * FROM customers ORDER BY custId DESC")
    public LiveData<List<Customers>> getAllCustomers();

    @Query("SELECT * FROM customers WHERE custId= :custId")
    public LiveData<Customers> getCustomer(Integer custId);
}
