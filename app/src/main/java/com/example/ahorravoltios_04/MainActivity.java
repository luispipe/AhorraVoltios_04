package com.example.ahorravoltios_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button home;
TextView register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        home=findViewById(R.id.buttonLogin);
        register=findViewById(R.id.textViewRegister);
        Intent home_activity=new Intent(getApplicationContext(),
                HomeActivity.class);
        Intent register_activity= new Intent(getApplicationContext(),
                RegisterUserActivity.class);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(register_activity);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(home_activity);
            }
        });
    }
}