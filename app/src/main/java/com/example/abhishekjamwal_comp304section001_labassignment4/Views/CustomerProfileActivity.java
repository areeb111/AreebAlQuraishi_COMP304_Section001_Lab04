package com.example.abhishekjamwal_comp304section001_labassignment4.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.abhishekjamwal_comp304section001_labassignment4.Models.Customers;
import com.example.abhishekjamwal_comp304section001_labassignment4.R;
import com.example.abhishekjamwal_comp304section001_labassignment4.ViewModels.CustomersViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class CustomerProfileActivity extends AppCompatActivity {

    private TextInputEditText username;
    private TextInputEditText password;
    private TextInputEditText firstname;
    private TextInputEditText lastname;
    private TextInputEditText city;
    private TextInputEditText address;
    private TextInputEditText postalcode;
    private MaterialButton update;
    Customers customer;
    private CustomersViewModel customersViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_profile);

        customersViewModel = ViewModelProviders.of(this).get(CustomersViewModel.class);


        update = findViewById(R.id.update);
        username = findViewById(R.id.username);
        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        address = findViewById(R.id.address);
        city = findViewById(R.id.city);
        postalcode = findViewById(R.id.postalcode);
        password = findViewById(R.id.password);

        // Getting user ID from SharedPref.
        SharedPreferences sharedpreferences = getSharedPreferences("G4Auto", Context.MODE_PRIVATE);
        Integer userId = sharedpreferences.getInt("userid", 0);

        // Loading data from database;
        customersViewModel.getCustomerById(userId).observe(this, (result) -> {
            //String output="";
            if (result.size() >= 1) {
                customer = result.get(0);
                username.setText(customer.getUserName());
                firstname.setText(customer.getFirstName());
                lastname.setText(customer.getLastName());
                address.setText(customer.getAddress());
                city.setText(customer.getCity());
                postalcode.setText(customer.getPostalCode());
            }
        });


        update.setOnClickListener((v) -> {
            customer.setUserName(Objects.requireNonNull(username.getText()).toString());
            customer.setFirstName(Objects.requireNonNull(firstname.getText()).toString());
            customer.setLastName(Objects.requireNonNull(lastname.getText()).toString());
            customer.setPostalCode(Objects.requireNonNull(postalcode.getText()).toString());
            customer.setCity(Objects.requireNonNull(city.getText()).toString());
            customer.setAddress(Objects.requireNonNull(address.getText()).toString());

            // If password is not changed, Then keep the same password.
            if (!Objects.requireNonNull(password.getText()).toString().equals("")) {
                customer.setPassword(Objects.requireNonNull(password.getText()).toString());
            }

            // Update customer record
            customersViewModel.updateCustomer(customer);

            finish();



        });


    }
}