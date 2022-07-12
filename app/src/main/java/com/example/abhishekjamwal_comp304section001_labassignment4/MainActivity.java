package com.example.abhishekjamwal_comp304section001_labassignment4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Toast;

import com.example.abhishekjamwal_comp304section001_labassignment4.ViewModels.CustomersViewModel;
import com.example.abhishekjamwal_comp304section001_labassignment4.Models.Customers;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText username;
    private TextInputEditText password;
    private MaterialButton login;
    private MaterialButton register;
    Customers customer;
    private CustomersViewModel customersViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        customersViewModel = ViewModelProviders.of(this).get(CustomersViewModel.class);


        customersViewModel.getInsertResult().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer result) {
                if (result == 1) {
                    Toast.makeText(MainActivity.this, "Customer successfully saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Error saving custoemr", Toast.LENGTH_SHORT).show();
                }
            }
        });

        customer = new Customers();
        register.setOnClickListener((v) -> {
            customer.setUserName(username.getText().toString());
            customer.setPassword(password.getText().toString());
            customersViewModel.insert(customer);
        });

    }
}