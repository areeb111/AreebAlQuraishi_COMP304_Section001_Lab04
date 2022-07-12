package com.example.abhishekjamwal_comp304section001_labassignment4.Views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.abhishekjamwal_comp304section001_labassignment4.R;
import com.example.abhishekjamwal_comp304section001_labassignment4.ViewModels.CustomersViewModel;
import com.example.abhishekjamwal_comp304section001_labassignment4.Models.Customers;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText username;
    private TextInputEditText password;
    private MaterialButton login;
    private MaterialButton register;
    Customers customer;
    private CustomersViewModel customersViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        customersViewModel = ViewModelProviders.of(this).get(CustomersViewModel.class);


        customersViewModel.getInsertResult().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer result) {
                if (result == 1) {
                    Toast.makeText(LoginActivity.this, "Customer successfully saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Error saving custoemr", Toast.LENGTH_SHORT).show();
                }
            }
        });

        customer = new Customers();
        register.setOnClickListener((v) -> {
            customer.setUserName(username.getText().toString());
            customer.setPassword(password.getText().toString());
            customersViewModel.insert(customer);
        });


        login.setOnClickListener((v) -> {
            customer.setUserName(username.getText().toString());
            customer.setPassword(password.getText().toString());
            customersViewModel.authenticateUser(username.getText().toString(), password.getText().toString()).observe(this, (result) -> {
                //String output="";
                if (result.size() >= 1) {

                    SharedPreferences sharedpreferences = getSharedPreferences("G4Auto", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();

                    Toast.makeText(getApplicationContext(), "Login success", Toast.LENGTH_SHORT).show();

                    // Save data into shared preferences
                    editor.putString("username", result.get(0).getUserName());
                    editor.putInt("userid", result.get(0).getCustId());
                    editor.apply();

                    Intent intent = new Intent(this, CustomerAcitivty.class);
                    intent.putExtra("username", result.get(0).getUserName());
                    intent.putExtra("userid", result.get(0).getCustId().toString());
                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();

                }
                /*
                for(Customers customer : result) {
                    output = customer.getUserName();
                    Toast.makeText(getApplicationContext(), output, Toast.LENGTH_SHORT).show();
                }

                 */

            });
        });


    }
}