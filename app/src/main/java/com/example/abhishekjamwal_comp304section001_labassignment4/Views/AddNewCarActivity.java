package com.example.abhishekjamwal_comp304section001_labassignment4.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.abhishekjamwal_comp304section001_labassignment4.Models.Cars;
import com.example.abhishekjamwal_comp304section001_labassignment4.Models.Customers;
import com.example.abhishekjamwal_comp304section001_labassignment4.R;
import com.example.abhishekjamwal_comp304section001_labassignment4.ViewModels.CarsViewModel;
import com.example.abhishekjamwal_comp304section001_labassignment4.ViewModels.CustomersViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class AddNewCarActivity extends AppCompatActivity {

    private TextInputEditText brandname;
    private TextInputEditText modelname;
    private TextInputEditText year;
    private TextInputEditText color;
    private TextInputEditText price;
    private TextInputEditText transmission;
    private MaterialButton addnewcar;
    Cars car;
    private CarsViewModel carsViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_car);

        brandname = findViewById(R.id.brandname);
        modelname = findViewById(R.id.modelname);
        year = findViewById(R.id.year);
        color = findViewById(R.id.color);
        transmission = findViewById(R.id.transmission);
        price = findViewById(R.id.price);
        addnewcar = findViewById(R.id.addnewcar);
        carsViewModel = ViewModelProviders.of(this).get(CarsViewModel.class);

        addnewcar.setOnClickListener((v -> {
            car = new Cars(
                    Objects.requireNonNull(brandname.getText()).toString(),
                    Objects.requireNonNull(modelname.getText()).toString(),
                    Objects.requireNonNull(price.getText()).toString(),
                    Objects.requireNonNull(color.getText()).toString(),
                    Objects.requireNonNull(transmission.getText()).toString(),
                    2022
            );
            carsViewModel.insert(car);
        }));

    }
}