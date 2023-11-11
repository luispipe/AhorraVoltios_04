package com.example.ahorravoltios_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button consume,statistics,recommendations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        consume=findViewById(R.id.buttonConsume);
        statistics=findViewById(R.id.buttonStatistics);
        recommendations=findViewById(R.id.buttonRecommendations);

        Intent consumeView= new Intent(getApplicationContext(),
                ConsumeActivity.class);

        Intent statistics_view= new Intent(getApplicationContext(),
                StatisticsActivity.class);

        Intent recommendations_view= new Intent(getApplicationContext(),
                RecommendationActivity.class);

        consume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(consumeView);
            }
        });

        statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(statistics_view);
            }
        });

        recommendations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(recommendations_view);
            }
        });

    }
}