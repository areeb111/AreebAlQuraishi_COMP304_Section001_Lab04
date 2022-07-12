package com.example.abhishekjamwal_comp304section001_labassignment4.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.abhishekjamwal_comp304section001_labassignment4.R;
import com.example.abhishekjamwal_comp304section001_labassignment4.ViewModels.CustomersViewModel;
import com.google.android.material.button.MaterialButton;

public class CustomerAcitivty extends AppCompatActivity {

    private MaterialButton updateProfile;
    private MaterialButton myGarage;
    private MaterialButton addNewCar;
    private RecyclerView rv;
    private TextView username;
    private TextView firstname;
    private TextView lastname;
    private CustomersViewModel customersViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        customersViewModel = ViewModelProviders.of(this).get(CustomersViewModel.class);

        updateProfile = findViewById(R.id.update);
        myGarage = findViewById(R.id.mygarage);
        addNewCar = findViewById(R.id.addnewcar);
        rv = findViewById(R.id.rv);
        username = findViewById(R.id.username);
        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);

        SharedPreferences sharedpreferences = getSharedPreferences("G4Auto", Context.MODE_PRIVATE);
        Integer userId = sharedpreferences.getInt("userid", 0);

        customersViewModel.getCustomerById(userId).observe(this, (result) -> {
            //String output="";
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
    }
}