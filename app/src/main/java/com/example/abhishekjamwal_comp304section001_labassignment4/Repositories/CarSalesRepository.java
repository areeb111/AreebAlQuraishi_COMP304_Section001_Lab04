package com.example.abhishekjamwal_comp304section001_labassignment4.Repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.abhishekjamwal_comp304section001_labassignment4.AppDatabase;
import com.example.abhishekjamwal_comp304section001_labassignment4.DAO.CarSalesDAO;
import com.example.abhishekjamwal_comp304section001_labassignment4.Models.CarSales;

import java.util.List;

public class CarSalesRepository
{
    private final CarSalesDAO carSalesDAO;
    private MutableLiveData<Integer> insertResult = new MutableLiveData<>();
    private LiveData<List<CarSales>> carSales;
    private CarSales carSale;

    public CarSalesRepository(Context context){
        //create a database object
        AppDatabase db = AppDatabase.getInstance(context);
        //create an interface object
        carSalesDAO = db.carSalesDao();
        //call interface method
        carSales = carSalesDAO.loadAllCarSales();
    }

    public LiveData<List<CarSales>> loadAllCarSales() {return carSales;}

    public LiveData<List<CarSales>> loadAllSales(Integer custId) {return carSalesDAO.loadAllSales(custId);}

    public void insert(CarSales carSale) {
        insertAsync(carSale);
    }


    public LiveData<Integer> getInsertResult() {return insertResult; }

    private void insertAsync(final CarSales carSale) {
        new Thread((Runnable) () -> {
            try {
                carSalesDAO.insertSale(carSale);
                insertResult.postValue(1);
            } catch (Exception e){
                insertResult.postValue(0);
            }
        }).start();
    }
}
