package com.example.abhishekjamwal_comp304section001_labassignment4;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.abhishekjamwal_comp304section001_labassignment4.DAO.CarSalesDAO;
import com.example.abhishekjamwal_comp304section001_labassignment4.DAO.CustomersDAO;
import com.example.abhishekjamwal_comp304section001_labassignment4.Models.CarSales;
import com.example.abhishekjamwal_comp304section001_labassignment4.Models.Cars;
import com.example.abhishekjamwal_comp304section001_labassignment4.Models.Customers;

@Database(entities = {
        Cars.class,
        CarSales.class,
        Customers.class
    }, version = 1)

public abstract class AppDatabase extends RoomDatabase {
    //
    private static volatile AppDatabase INSTANCE;
    private static final String DATABASE_NAME = "CarSalesDB";

    public abstract CarSalesDAO carSalesDao();
    public abstract CustomersDAO customersDAO();

    //
    public static synchronized AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            //Create database object
            INSTANCE = Room.databaseBuilder(context,
                    AppDatabase.class, DATABASE_NAME).build();
        }
        return INSTANCE;
    }
}
