package com.example.abhishekjamwal_comp304section001_labassignment4.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.abhishekjamwal_comp304section001_labassignment4.Repositories.CustomersRepository;
import com.example.abhishekjamwal_comp304section001_labassignment4.Models.Customers;

import java.util.List;

public class CustomersViewModel extends AndroidViewModel {
    private CustomersRepository customersRepository;
    private LiveData<Integer> insertResult;
    private LiveData<List<Customers>> allCustomers;
    private LiveData<List<Customers>> singleCustomer;

    public CustomersViewModel(@NonNull Application application) {
        super(application);
        customersRepository = new CustomersRepository(application);
    }

    public void insert(Customers customer) {
        customersRepository.insert(customer);
    }

    public void updateCustomer(Customers customer) {customersRepository.updateCustomer(customer);}

    public LiveData<Integer> getInsertResult() {
        return customersRepository.getInsertResult();
    }

    public LiveData<List<Customers>> getAllCustomers() { return customersRepository.getAllCustomers(); }

    public LiveData<List<Customers>> authenticateUser(String userName, String password) {return customersRepository.authenticateUser(userName, password);}

    public LiveData<List<Customers>> getCustomerById(Integer custId) {return customersRepository.getCustomerById(custId);}



}
