package com.example.ahorravoltios_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ahorravoltios_04.models.Electricity;
import com.example.ahorravoltios_04.models.Water;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class StatisticsActivity extends AppCompatActivity {

    TextView totalWater,totalElectricity,total_pay,max_water_month,
    max_electricity_month,max_water_quantity,max_electricity_quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        totalWater=findViewById(R.id.textViewTotalWater);
        totalElectricity=findViewById(R.id.textViewTotalElectricity);
        total_pay=findViewById(R.id.textViewTotalPay);
        max_water_month=findViewById(R.id.textViewMonthMaxWater);
        max_water_quantity=findViewById(R.id.textViewMaxWaterQuantity);
        max_electricity_month=findViewById(R.id.textViewMonthMaxElectricity);
        max_electricity_quantity=findViewById(R.id.textViewMaxElectricityQuantity);

        //Recibir los datos enviados en un Intent desde otro Activity
        Intent receive= getIntent();
        String idUser= receive.getStringExtra("idUser");

        File water= new File(getFilesDir(),"water.txt");
        File electricity= new File(getFilesDir(),"electricity.txt");

        ArrayList<Water> list_water= listWater(water,idUser);
        ArrayList<Electricity> list_electricity= listElectricity(electricity,idUser);

        total_consume_water(list_water);
        total_consume_electricity(list_electricity);

        int total= totalPayWater(list_water)+totalPayElectricity(list_electricity);
        total_pay.setText("$ "+total);

    }

    public int totalPayWater(ArrayList<Water>list){
        int pay=0;
        for (Water i: list){
            pay+=i.getPrice();
        }
        return pay;
    }

    public int totalPayElectricity(ArrayList<Electricity>list){
        int pay=0;
        for (Electricity i: list){
            pay+=i.getPrice();
        }
        return pay;
    }

    public void total_consume_water(ArrayList<Water>list){
        int total=0;
        String month="";
        int max=0;
        for (Water i:list){
            total+=i.getQuantity();
            if (max<i.getQuantity()){
                max=i.getQuantity();
                month=i.getMonth();
            }
        }
        totalWater.setText(total+" L");
        max_water_quantity.setText(max+" L");
        max_water_month.setText(month);
    }

    public void total_consume_electricity(ArrayList<Electricity>list){
        int total=0;
        String month="";
        int max=0;
        for (Electricity i:list){
            total+=i.getQuantity();
            if (max<i.getQuantity()){
                max=i.getQuantity();
                month=i.getMonth();
            }
        }
        totalElectricity.setText(total+" KWh");
        max_electricity_quantity.setText(max+" KWh");
        max_electricity_month.setText(month);
    }


    public ArrayList<Water> listWater(File water,String user){
        ArrayList<Water> list= new ArrayList<>();
        try {
            FileReader reader= new FileReader(water);
            BufferedReader bufferedReader=new BufferedReader(reader);
            String cadena;
            while ((cadena=bufferedReader.readLine())!=null){
                String [] data= cadena.split(",");
                if(data[4].equals(user)){
                    String serial= data[0];
                    int quantity= Integer.parseInt(data[1]);
                    int price= Integer.parseInt(data[2]);
                    String month= data[3];
                    String idUser= data[4];

                    Water obj= new Water(serial,quantity,price,month,idUser);
                    list.add(obj);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Electricity> listElectricity(File electricity, String user){
        ArrayList<Electricity> list= new ArrayList<>();
        try {
            FileReader reader= new FileReader(electricity);
            BufferedReader bufferedReader=new BufferedReader(reader);
            String cadena;
            while ((cadena=bufferedReader.readLine())!=null){
                String [] data= cadena.split(",");
                if(data[4].equals(user)){
                    String serial= data[0];
                    int quantity= Integer.parseInt(data[1]);
                    int price= Integer.parseInt(data[2]);
                    String month= data[3];
                    String idUser= data[4];

                    Electricity obj= new Electricity(serial,quantity,price,month,idUser);
                    list.add(obj);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }



}