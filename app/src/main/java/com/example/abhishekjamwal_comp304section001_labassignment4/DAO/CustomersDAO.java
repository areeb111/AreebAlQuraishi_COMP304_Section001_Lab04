package com.example.abhishekjamwal_comp304section001_labassignment4.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.abhishekjamwal_comp304section001_labassignment4.Models.Customers;

import java.util.List;

@Dao
public interface CustomersDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertCustomers(List<Customers> customers);

    // insert customer in database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertCustomer(Customers customer);

    // update customer in database
    @Update(onConflict = OnConflictStrategy.REPLACE)
    public void updateCustomer(Customers customer);

    // Get all customers
    @Query("SELECT * FROM customers ORDER BY custId DESC")
    public LiveData<List<Customers>> getAllCustomers();

    // Authentication query by username & password
    @Query("SELECT * FROM customers WHERE username = :userName and password = :password")
    public LiveData<List<Customers>> authenticateUser(String userName, String password);

    // Get customer by ID
    @Query("SELECT * FROM customers WHERE custId = :custid")
    public LiveData<List<Customers>> getCustomerbyId(Integer custid);

}
