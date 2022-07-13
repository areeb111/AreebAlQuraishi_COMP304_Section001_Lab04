package com.example.abhishekjamwal_comp304section001_labassignment4.Views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.abhishekjamwal_comp304section001_labassignment4.Adapters.CarsListAdapter;
import com.example.abhishekjamwal_comp304section001_labassignment4.Adapters.MyGarageListAdapter;
import com.example.abhishekjamwal_comp304section001_labassignment4.Models.CarSales;
import com.example.abhishekjamwal_comp304section001_labassignment4.Models.Cars;
import com.example.abhishekjamwal_comp304section001_labassignment4.R;
import com.example.abhishekjamwal_comp304section001_labassignment4.ViewModels.CarSalesViewModel;
import com.example.abhishekjamwal_comp304section001_labassignment4.ViewModels.CarsViewModel;

import java.util.List;

public class MyGarageActivity extends AppCompatActivity {
    private RecyclerView mygarage_rv;
    private CarSalesViewModel carSalesViewModel;
    private MyGarageListAdapter myGarageListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_garage);
        mygarage_rv = findViewById(R.id.mygarage_rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        carSalesViewModel = ViewModelProviders.of(this).get(CarSalesViewModel.class);
        mygarage_rv.setLayoutManager(linearLayoutManager);
        getCarSales();

    }

    private void getCarSales() {
        carSalesViewModel.loadAllCarSales().observe(this, new Observer<List<CarSales>>() {
            @Override
            public void onChanged(@Nullable List<CarSales> carSales) {
                if(carSales.size() > 0) {
                    mygarage_rv.setVisibility(View.VISIBLE);
                    if (myGarageListAdapter == null) {
                        myGarageListAdapter = new MyGarageListAdapter(MyGarageActivity.this,carSales);
                        mygarage_rv.setAdapter(myGarageListAdapter);

                    }
                }
            }
        });
    }
}