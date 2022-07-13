package com.example.abhishekjamwal_comp304section001_labassignment4.Views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.abhishekjamwal_comp304section001_labassignment4.Adapters.CarsListAdapter;
import com.example.abhishekjamwal_comp304section001_labassignment4.Models.Cars;
import com.example.abhishekjamwal_comp304section001_labassignment4.R;
import com.example.abhishekjamwal_comp304section001_labassignment4.ViewModels.CarsViewModel;
import com.example.abhishekjamwal_comp304section001_labassignment4.ViewModels.CustomersViewModel;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class CustomerAcitivty extends AppCompatActivity {

    private MaterialButton updateProfile;
    private MaterialButton myGarage;
    private MaterialButton addNewCar;
    private LinearLayout emptyView;
    private RecyclerView rv;
    private TextView username;
    private TextView firstname;
    private TextView lastname;
    private CustomersViewModel customersViewModel;
    private CarsViewModel carsViewModel;
    private CarsListAdapter carsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        customersViewModel = ViewModelProviders.of(this).get(CustomersViewModel.class);
        carsViewModel = ViewModelProviders.of(this).get(CarsViewModel.class);

        updateProfile = findViewById(R.id.update);
        myGarage = findViewById(R.id.mygarage);
        addNewCar = findViewById(R.id.addnewcar);
        rv = findViewById(R.id.rv);
        emptyView = findViewById(R.id.empty);
        username = findViewById(R.id.username);
        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);

        SharedPreferences sharedpreferences = getSharedPreferences("G4Auto", Context.MODE_PRIVATE);
        Integer userId = sharedpreferences.getInt("userid", 0);

        customersViewModel.getCustomerById(userId).observe(this, (result) -> {
            if (result.size() >= 1) {
                username.setText(result.get(0).getUserName());
                firstname.setText(result.get(0).getFirstName());
                lastname.setText(result.get(0).getLastName());
            }
        });

        updateProfile.setOnClickListener((v) -> {
            Intent intent = new Intent(this, CustomerProfileActivity.class);
            startActivity(intent);
        });
        addNewCar.setOnClickListener((v) -> {
            Intent intent = new Intent(this, AddNewCarActivity.class);
            startActivity(intent);
        });

        myGarage.setOnClickListener((v) -> {
            Intent intent = new Intent(this, MyGarageActivity.class);
            startActivity(intent);
        });


        rv = findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rv.setLayoutManager(linearLayoutManager);
        getCars();

    }

    private void getCars() {
        carsViewModel.getAllCars().observe(this, new Observer<List<Cars>>() {
            @Override
            public void onChanged(@Nullable List<Cars> cars) {
                if(cars.size() > 0) {
                    emptyView.setVisibility(View.GONE);
                    rv.setVisibility(View.VISIBLE);
                    if (carsListAdapter == null) {
                        carsListAdapter = new CarsListAdapter(CustomerAcitivty.this,cars);
                        rv.setAdapter(carsListAdapter);

                    }
                } else updateEmptyView();
            }
        });
    }


    private void updateEmptyView() {
        emptyView.setVisibility(View.VISIBLE);
        rv.setVisibility(View.GONE);
    }



}