package com.example.ahorravoltios_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button consume;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        consume=findViewById(R.id.buttonConsume);

        Intent consumeView= new Intent(getApplicationContext(),
                ConsumeActivity.class);

        consume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(consumeView);
            }
        });

    }
}