package com.example.abhishekjamwal_comp304section001_labassignment4.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abhishekjamwal_comp304section001_labassignment4.Models.CarSales;
import com.example.abhishekjamwal_comp304section001_labassignment4.Models.Cars;
import com.example.abhishekjamwal_comp304section001_labassignment4.R;
import com.example.abhishekjamwal_comp304section001_labassignment4.ViewModels.CarsViewModel;
import com.example.abhishekjamwal_comp304section001_labassignment4.Views.CarSalesActivity;
import com.example.abhishekjamwal_comp304section001_labassignment4.Views.CustomerAcitivty;

import java.util.List;

public class CarsListAdapter extends RecyclerView.Adapter<CarsListAdapter.CustomViewHolder> {

    private List<Cars> cars;
    private Context mcontext;
    public CarsListAdapter(Context _mcontext, List<Cars> cars) {
        this.cars = cars;
        this.mcontext = _mcontext;
    }
    private CarsViewModel carsViewModel;


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_list_item, null);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        CustomViewHolder viewHolder = new CustomViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Cars car = getItem(position);

        holder.brandName.setText(car.getBrandName());
        holder.modelName.setText(car.getModelName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mcontext.startActivity(new Intent(mcontext, CarSalesActivity.class).putExtra("carid", car.getCarId()));
            }
        });


    }


    @Override
    public int getItemCount() {
        return cars.size();
    }

    public Cars getItem(int position) {
        return cars.get(position);
    }


    protected class CustomViewHolder extends RecyclerView.ViewHolder {

        private TextView brandName, modelName;
        public CustomViewHolder(View itemView) {
            super(itemView);

            brandName = itemView.findViewById(R.id.brandname);
            modelName = itemView.findViewById(R.id.modelname);
        }
    }
}
