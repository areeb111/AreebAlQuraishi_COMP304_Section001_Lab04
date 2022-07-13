package com.example.abhishekjamwal_comp304section001_labassignment4.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abhishekjamwal_comp304section001_labassignment4.Models.CarSales;
import com.example.abhishekjamwal_comp304section001_labassignment4.R;
import com.example.abhishekjamwal_comp304section001_labassignment4.ViewModels.CarSalesViewModel;
import com.example.abhishekjamwal_comp304section001_labassignment4.ViewModels.CarsViewModel;
import com.example.abhishekjamwal_comp304section001_labassignment4.Views.CarSalesActivity;

import java.util.List;

public class MyGarageListAdapter extends RecyclerView.Adapter<MyGarageListAdapter.CustomViewHolder> {

    private List<CarSales> carSales;
    private Context mcontext;
    public MyGarageListAdapter(Context _mcontext, List<CarSales> carSales) {
        this.carSales = carSales;
        this.mcontext = _mcontext;
    }
    private CarSalesViewModel carSalesViewModel;


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sales_list_item, null);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        CustomViewHolder viewHolder = new CustomViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        CarSales carSales = getItem(position);
        holder.brandName.setText(carSales.getSaleId().toString());
        holder.modelName.setText(carSales.getPaymentDate());

    }


    @Override
    public int getItemCount() {
        return carSales.size();
    }

    public CarSales getItem(int position) {
        return carSales.get(position);
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
