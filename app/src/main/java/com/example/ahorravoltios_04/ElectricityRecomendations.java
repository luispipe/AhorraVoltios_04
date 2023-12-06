package com.example.ahorravoltios_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ElectricityRecomendations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity_recomendations);

        Button back= findViewById(R.id.btnBackRecommend);

        Intent recommendation= new Intent(getApplicationContext(), RecommendationActivity.class);

        back.setOnClickListener(v -> startActivity(recommendation));

    }
}