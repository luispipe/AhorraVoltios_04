package com.example.ahorravoltios_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class StatisticsActivity extends AppCompatActivity {

    TextView totalWater,totalElectricity,total_pay,max_water_month,
    max_electricity_month,max_water_quantity,max_electricity_quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        totalWater=findViewById(R.id.textViewTotalWater);
        totalElectricity=findViewById(R.id.textViewTotalElectricity);
        total_pay=findViewById(R.id.textViewTotalPay);
        max_water_month=findViewById(R.id.textViewMonthMaxWater);
        max_water_quantity=findViewById(R.id.textViewMaxWaterQuantity);
        max_electricity_month=findViewById(R.id.textViewMonthMaxElectricity);
        max_electricity_quantity=findViewById(R.id.textViewMaxElectricityQuantity);

    }
}