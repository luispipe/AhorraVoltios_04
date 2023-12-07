package com.example.ahorravoltios_04;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
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
        statistics_view.putExtra("idUser",idUser);

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

    //Metodo que controle cuando se da click en el boton retroceder


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode==event.KEYCODE_BACK){
            AlertDialog.Builder builder= new AlertDialog.Builder(this);
            builder.setTitle("¿Esta seguro que quiere salir de la aplicación?")
                    .setMessage("Recuerda que al salir no se almacenaran los datos que no guardaste")
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            builder.show();
        }
        return super.onKeyDown(keyCode, event);
    }
}