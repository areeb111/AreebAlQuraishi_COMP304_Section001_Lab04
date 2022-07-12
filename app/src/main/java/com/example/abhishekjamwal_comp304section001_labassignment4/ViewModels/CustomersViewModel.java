package com.example.abhishekjamwal_comp304section001_labassignment4.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.abhishekjamwal_comp304section001_labassignment4.CustomersRepository;
import com.example.abhishekjamwal_comp304section001_labassignment4.Models.Customers;

import java.util.List;

public class CustomersViewModel extends AndroidViewModel {
    private CustomersRepository customersRepository;
    private LiveData<Integer> insertResult;
    private LiveData<List<Customers>> allCustomers;

    public CustomersViewModel(@NonNull Application application) {
        super(application);
        customersRepository = new CustomersRepository(application);
        insertResult = customersRepository.getInsertResult();
        allCustomers = customersRepository.getAllCustomers();

    }
    public void insert(Customers customer) {
        customersRepository.insert(customer);
    }

    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }
    //returns query results as live data object
    LiveData<List<Customers>> getAllCustomers() { return allCustomers; }



}
