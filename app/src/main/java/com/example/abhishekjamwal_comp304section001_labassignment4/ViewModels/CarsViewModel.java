package com.example.abhishekjamwal_comp304section001_labassignment4.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.abhishekjamwal_comp304section001_labassignment4.Models.Cars;
import com.example.abhishekjamwal_comp304section001_labassignment4.Models.Customers;
import com.example.abhishekjamwal_comp304section001_labassignment4.Repositories.CarsRepository;

import java.util.List;

public class CarsViewModel extends AndroidViewModel {
    private CarsRepository carsRepository;
    private LiveData<Integer> insertResult;
    private LiveData<List<Customers>> allCars;

    public CarsViewModel(@NonNull Application application) {
        super(application);
        carsRepository = new CarsRepository(application);
    }

    public void insert(Cars car) {
        carsRepository.insert(car);
    }

    public LiveData<Integer> getInsertResult() {
        return carsRepository.getInsertResult();
    }

    public LiveData<List<Cars>> getAllCars() { return carsRepository.getAllCars(); }

    //public LiveData<List<Customers>> authenticateUser(String userName, String password) {return customersRepository.authenticateUser(userName, password);}

    public LiveData<List<Cars>> getCarById(Integer carId) {return carsRepository.getCarByid(carId);}



}
