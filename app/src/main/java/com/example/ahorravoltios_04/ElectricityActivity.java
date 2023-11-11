package com.example.ahorravoltios_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class ElectricityActivity extends AppCompatActivity {

    EditText quantity,price;
    Spinner month;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity);

        quantity=findViewById(R.id.etElectricityQuantity);
        price=findViewById(R.id.etPriceElectricity);
        month=findViewById(R.id.spinnerMonthElectricity);
        register=findViewById(R.id.btRegisterElectricity);

    }
}