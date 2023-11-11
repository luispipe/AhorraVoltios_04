package com.example.ahorravoltios_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class WaterActivity extends AppCompatActivity {

    EditText quantity,price;
    Spinner month;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);

        quantity=findViewById(R.id.etWaterQuantity);
        price=findViewById(R.id.etPriceWater);
        month=findViewById(R.id.spinnerMonthWater);
        register=findViewById(R.id.btRegisterWater);

    }
}