package com.example.abhishekjamwal_comp304section001_labassignment4;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.abhishekjamwal_comp304section001_labassignment4.DAO.CustomersDAO;
import com.example.abhishekjamwal_comp304section001_labassignment4.Models.Customers;

import java.util.List;

public class CustomersRepository
{
    private final CustomersDAO customersDAO;
    private MutableLiveData<Integer> insertResult = new MutableLiveData<>();
    private LiveData<List<Customers>> customersList;

    public CustomersRepository(Context context){
        //create a database object
        AppDatabase db = AppDatabase.getInstance(context);
        //create an interface object
        customersDAO = db.customersDAO();
        //call interface method
        customersList = customersDAO.getAllCustomers();
    }

    public LiveData<List<Customers>> getAllCustomers() {return customersList;}

    public void insert(Customers customer) {
        insertAsync(customer);
    }

    public LiveData<Integer> getInsertResult() {return insertResult; }

    private void insertAsync(final Customers customer) {
        new Thread((Runnable) () -> {
            try {
                customersDAO.insertCustomer(customer);
                insertResult.postValue(1);
            } catch (Exception e){
                insertResult.postValue(0);
            }
        }).start();
    }
}
