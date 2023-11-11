package com.example.ahorravoltios_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RecommendationActivity extends AppCompatActivity {

    LinearLayout state,water,electricity;
    ImageView icon;
    TextView alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);

        state=findViewById(R.id.LayoutState);
        water=findViewById(R.id.layout_water_recommendations);
        electricity=findViewById(R.id.layout_electricity_recommendations);
        icon=findViewById(R.id.imageViewState);
        alert=findViewById(R.id.textViewMessage);


    }
}