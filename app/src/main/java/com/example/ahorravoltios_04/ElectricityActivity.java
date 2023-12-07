package com.example.ahorravoltios_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ahorravoltios_04.models.Electricity;
import com.example.ahorravoltios_04.models.Water;
import com.google.android.material.snackbar.Snackbar;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

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
                    int quantityElectricity= Integer.parseInt(quantity.getText().toString());
                    int priceElectricity= Integer.parseInt(price.getText().toString());
                    String monthElectricity= month.getSelectedItem().toString();
                    String serial= idUser+monthElectricity;
                    Electricity consumeElectricity= new Electricity(serial,quantityElectricity,priceElectricity,monthElectricity,idUser);
                    registerElectricity(consumeElectricity);
                    Snackbar mySnackbar= Snackbar.make(findViewById(R.id.llelectricity),"Registro exitoso",5000);
                    mySnackbar.show();
                    /*Toast.makeText(getApplicationContext(),"Registro exitoso",
                            Toast.LENGTH_LONG).show();*/
                    cleanView();
                }
            }
        });

    }

    public void registerElectricity(Electricity consume){

        //Definir la dirección y nombre del archivo
        File electricityFile= new File(getFilesDir(),"electricity.txt");

        try {
            FileWriter writer= new FileWriter(electricityFile,true);
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