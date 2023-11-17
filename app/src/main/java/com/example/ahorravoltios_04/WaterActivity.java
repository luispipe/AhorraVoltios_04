package com.example.ahorravoltios_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ahorravoltios_04.models.Water;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

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

        Intent receive= getIntent();
        String idUser= receive.getStringExtra("idUser");
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity.getText().toString().isEmpty() ||
                    price.getText().toString().isEmpty() ||
                    month.getSelectedItem().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),
                    "Todos los campos deben diligenciarse",Toast.LENGTH_LONG).show();
                }else{
                    int quantityWater= Integer.parseInt(quantity.getText().toString());
                    int priceWater= Integer.parseInt(price.getText().toString());
                    String monthWater= month.getSelectedItem().toString();
                    String serial= idUser+monthWater;
                    Water consumeWater= new Water(serial,quantityWater,priceWater,monthWater,idUser);
                    registerWater(consumeWater);
                    Toast.makeText(getApplicationContext(),"Registro exitoso",
                            Toast.LENGTH_LONG).show();
                    cleanView();
                }
            }
        });

    }

    public void registerWater(Water consume){

        //Definir la dirección y nombre del archivo
        File waterFile= new File(getFilesDir(),"water.txt");

        try {
            FileWriter writer= new FileWriter(waterFile,true);
            BufferedWriter bufferedWriter= new BufferedWriter(writer);
            bufferedWriter.write(
                    consume.getSERIAL()+","+
                       consume.getQuantity()+","+
                       consume.getPrice()+","+
                       consume.getMonth()+","+
                        consume.getIdUser()
            );
            bufferedWriter.newLine();
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void cleanView(){
        quantity.setText("");
        price.setText("");
        month.setSelection(0);
    }

}