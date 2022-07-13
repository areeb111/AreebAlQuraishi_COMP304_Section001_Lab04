package com.example.abhishekjamwal_comp304section001_labassignment4.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abhishekjamwal_comp304section001_labassignment4.Models.CarSales;
import com.example.abhishekjamwal_comp304section001_labassignment4.Models.Cars;
import com.example.abhishekjamwal_comp304section001_labassignment4.R;
import com.example.abhishekjamwal_comp304section001_labassignment4.ViewModels.CarSalesViewModel;
import com.example.abhishekjamwal_comp304section001_labassignment4.ViewModels.CarsViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class CarSalesActivity extends AppCompatActivity {

    private CarsViewModel carsViewModel;
    private CarSalesViewModel carSalesViewModel;

    private MaterialButton checkout;

    private TextView brandname;
    private TextView modelname;
    private TextView year;
    private TextView price;
    private TextView color;
    private TextView transmission;
    private TextInputEditText cardName;
    private TextInputEditText cardNumber;
    private TextInputEditText cardExpiry;
    private TextInputEditText cardCVV;

    Cars car;
    CarSales carSales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_sales);

        CarsViewModel carsViewModel = ViewModelProviders.of(this).get(CarsViewModel.class);
        CarSalesViewModel carSalesViewModel = ViewModelProviders.of(this).get(CarSalesViewModel.class);

        // Getting user ID from SharedPref.
        SharedPreferences sharedpreferences = getSharedPreferences("G4Auto", Context.MODE_PRIVATE);
        Integer userId = sharedpreferences.getInt("userid", 0);



        Integer carid = getIntent().getIntExtra("carid",0);
        brandname = findViewById(R.id.brandname);
        modelname = findViewById(R.id.modelname);
        price = findViewById(R.id.price);
        color = findViewById(R.id.color);
        year = findViewById(R.id.year);
        transmission = findViewById(R.id.transmission);


        cardName = findViewById(R.id.cardname);
        cardNumber = findViewById(R.id.cardnumber);
        cardExpiry = findViewById(R.id.cardexpiry);
        cardCVV = findViewById(R.id.cardcvv);

        checkout = findViewById(R.id.checkout);

        carsViewModel.getCarById(carid).observe(this, (result) -> {
            //String output="";
            if (result.size() >= 1) {
                car = result.get(0);
                brandname.setText(car.getBrandName());
                modelname.setText(car.getModelName());
                price.setText(car.getPrice());
                color.setText(car.getColor());
                year.setText(car.getYear().toString());
                transmission.setText(car.getTransmission());
            } else {
                Toast.makeText(this, "Car not found", Toast.LENGTH_SHORT).show();
            }
        });

        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        String formattedDate = df.format(c);

        Log.i("MYID", userId.toString());

        checkout.setOnClickListener((v -> {
            carSalesViewModel.insert(new CarSales(
                    userId,
                    car.getCarId(),
                    formattedDate,
                    "Paid",
                    "4000",
                    Objects.requireNonNull(cardName.getText()).toString(),
                    Objects.requireNonNull(cardNumber.getText()).toString(),
                    Objects.requireNonNull(cardExpiry.getText()).toString(),
                    Objects.requireNonNull(cardCVV.getText()).toString()
                    )
            );
            finish();
        }
        ));


    }
}