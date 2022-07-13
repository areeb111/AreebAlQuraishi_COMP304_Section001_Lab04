package com.example.abhishekjamwal_comp304section001_labassignment4.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.abhishekjamwal_comp304section001_labassignment4.Models.CarSales;

import com.example.abhishekjamwal_comp304section001_labassignment4.Repositories.CarSalesRepository;

import java.util.List;

public class CarSalesViewModel extends AndroidViewModel {
    private CarSalesRepository carSalesRepository;
    private LiveData<Integer> insertResult;
    private LiveData<List<CarSales>> carSales;

    public CarSalesViewModel(@NonNull Application application) {
        super(application);
        carSalesRepository = new CarSalesRepository(application);
    }

    public void insert(CarSales carSales) {
        carSalesRepository.insert(carSales);
    }

    public LiveData<Integer> getInsertResult() {
        return carSalesRepository.getInsertResult();
    }

    public LiveData<List<CarSales>> loadAllSales(Integer custId) { return carSalesRepository.loadAllSales(custId); }

    public LiveData<List<CarSales>> loadAllCarSales() { return carSalesRepository.loadAllCarSales(); }
}
