package com.example.ahorravoltios_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RecommendationActivity extends AppCompatActivity {

    Button moreWater, moreElect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);

        moreWater= findViewById(R.id.btMoreWater);
        moreElect=findViewById(R.id.btMoreElect);

        Intent waterRecommedantion= new Intent(getApplicationContext(), WaterRecomendations.class);
        Intent electRecommendation= new Intent(getApplicationContext(), ElectricityRecomendations.class);

        moreWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(waterRecommedantion);
            }
        });

        moreElect.setOnClickListener(v -> startActivity(electRecommendation) );

    }
}