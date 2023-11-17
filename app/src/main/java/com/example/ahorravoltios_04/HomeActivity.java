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

        //Recibir los datos enviados en un Intent desde otro Activity
        Intent receive= getIntent();
        String idUser= receive.getStringExtra("idUser");

        Intent consumeView= new Intent(getApplicationContext(),
                ConsumeActivity.class);
        consumeView.putExtra("idUser",idUser);

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