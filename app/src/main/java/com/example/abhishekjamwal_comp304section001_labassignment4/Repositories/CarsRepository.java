package com.example.abhishekjamwal_comp304section001_labassignment4.Repositories;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.abhishekjamwal_comp304section001_labassignment4.AppDatabase;
import com.example.abhishekjamwal_comp304section001_labassignment4.DAO.CarsDAO;
import com.example.abhishekjamwal_comp304section001_labassignment4.DAO.CustomersDAO;
import com.example.abhishekjamwal_comp304section001_labassignment4.Models.Cars;
import com.example.abhishekjamwal_comp304section001_labassignment4.Models.Customers;

import java.util.List;

public class CarsRepository
{
    private final CarsDAO carsDAO;
    private MutableLiveData<Integer> insertResult = new MutableLiveData<>();
    private LiveData<List<Cars>> carsList;
    private Cars car;

    public CarsRepository(Context context){
        //create a database object
        AppDatabase db = AppDatabase.getInstance(context);
        //create an interface object
        carsDAO = db.carsDAO();
        //call interface method
        carsList = carsDAO.getAllCars();
    }

    public LiveData<List<Cars>> getAllCars() {return carsList;}

    //public LiveData<List<Customers>> authenticateUser(String userName, String password) {return customersDAO.authenticateUser(userName, password);}

    //public LiveData<List<Customers>> getCustomerById(Integer custId) {return customersDAO.getCustomerbyId(custId);}


    public void insert(Cars car) {
        insertAsync(car);
    }

    //public void updateCustomer(Customers customer) {
        //updateAsync(customer);
    //}

    public LiveData<Integer> getInsertResult() {return insertResult; }

    private void insertAsync(final Cars car) {
        new Thread((Runnable) () -> {
            try {
                carsDAO.insertCar(car);
                insertResult.postValue(1);
            } catch (Exception e){
                insertResult.postValue(0);
            }
        }).start();
    }

    /*
    private void updateAsync(final Customers customer) {
        new Thread((Runnable) () -> {
            try {
                customersDAO.updateCustomer(customer);
                Log.i("UPDATING", "CUSTOMER UPDATED SUCCESSFULLY");
            } catch (Exception e) {
                Log.e("ERROR_UPDATING", e.toString());
            }
        }).start();
    }

     */


}
