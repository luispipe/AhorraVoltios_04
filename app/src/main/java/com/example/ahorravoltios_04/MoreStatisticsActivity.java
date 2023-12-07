package com.example.ahorravoltios_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.ahorravoltios_04.models.Electricity;
import com.example.ahorravoltios_04.models.User;
import com.example.ahorravoltios_04.models.Water;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MoreStatisticsActivity extends AppCompatActivity {


    TableLayout water, electricity;

    TextView username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_statistics);
        water= findViewById(R.id.TableWater);
        electricity= findViewById(R.id.TableElectricity);
        username=findViewById(R.id.textViewUsername);

        Intent receive= getIntent();
        String userID= receive.getStringExtra("idUser");

        File waterFile= new File(getFilesDir(),"water.txt");
        File electricityFile= new File(getFilesDir(),"electricity.txt");
        File userFile= new File(getFilesDir(),"user.txt");

        ArrayList<Water> list= consumeWater(waterFile,userID);
        inflateWaterTable(list);

        ArrayList<Electricity> listElectricity= consumeElectricity(electricityFile,userID);
        inflateElectricityTable(listElectricity);

        String name_user= nameUser(userFile,userID);
        username.setText(name_user);
    }

    public void inflateWaterTable(ArrayList<Water>list){

        int total=0;
        String averageValue="";
        System.out.println("Antes");
        for (Water i: list){
            TableRow row=new TableRow(this);
            TextView quantity= new TextView(this);
            quantity.setWidth(97);
            quantity.setTextSize(14);
            quantity.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            TextView price= new TextView(this);
            price.setTextSize(14);
            price.setWidth(96);
            price.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            TextView month= new TextView(this);
            month.setWidth(105);
            month.setTextSize(14);
            month.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            TextView average= new TextView(this);
            average.setWidth(90);
            average.setTextSize(14);
            average.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            quantity.setText(i.getQuantity()+"");
            price.setText(i.getPrice()+"");
            month.setText(i.getMonth());
            total= totalWater(list);
            averageValue=average(total,i.getQuantity());
            average.setText(averageValue+"%");

            row.addView(month);
            row.addView(quantity);
            row.addView(price);
            row.addView(average);

            water.addView(row);
        }
    }

    public void inflateElectricityTable(ArrayList<Electricity>list){
        int total=0;
        String averageValue="";
        System.out.println("Antes");
        for (Electricity i: list){
            TableRow row=new TableRow(this);
            TextView quantity= new TextView(this);
            quantity.setWidth(97);
            quantity.setTextSize(14);
            quantity.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            TextView price= new TextView(this);
            price.setTextSize(14);
            price.setWidth(96);
            price.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            TextView month= new TextView(this);
            month.setWidth(105);
            month.setTextSize(14);
            month.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            TextView average= new TextView(this);
            average.setWidth(90);
            average.setTextSize(14);
            average.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            quantity.setText(i.getQuantity()+"");
            price.setText(i.getPrice()+"");
            month.setText(i.getMonth());
            total= totalElectricity(list);
            averageValue=average(total,i.getQuantity());
            average.setText(averageValue+"%");

            row.addView(month);
            row.addView(quantity);
            row.addView(price);
            row.addView(average);

            electricity.addView(row);
        }
    }
    public ArrayList<Water> consumeWater(File water, String id){
        ArrayList<Water> list= new ArrayList<>();
        try {
            FileReader reader= new FileReader(water);
            BufferedReader bufferedReader= new BufferedReader(reader);
            String line;
            while ((line=bufferedReader.readLine())!=null){
                String [] data= line.split(",");
                if (id.equals(data[4])){
                    int quantity= Integer.parseInt(data[1]);
                    int price= Integer.parseInt(data[2]);
                    String month= data[3];
                    String serial= data[0];
                    Water obj= new Water(serial,quantity,price,month,id);
                    list.add(obj);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Electricity> consumeElectricity(File electricity, String id){
        ArrayList<Electricity> list= new ArrayList<>();
        try {
            FileReader reader= new FileReader(electricity);
            BufferedReader bufferedReader= new BufferedReader(reader);
            String line;
            System.out.println(reader.toString());
            while ((line=bufferedReader.readLine())!=null){
                String [] data= line.split(",");
                if (id.equals(data[4])){
                    System.out.println(line);
                    int quantity= Integer.parseInt(data[1]);
                    int price= Integer.parseInt(data[2]);
                    String month= data[3];
                    String serial= data[0];
                    Electricity obj= new Electricity(serial,quantity,price,month,id);
                    list.add(obj);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(list.size());
        return list;
    }

    public int totalWater (ArrayList<Water> list){
        int total=0;
        for (Water i: list){
            total+=i.getQuantity();
        }
        return total;
    }

    public int totalElectricity(ArrayList<Electricity> list){
        int total=0;
        for (Electricity i: list){
            total+=i.getQuantity();
        }
        return total;
    }

    public String average(int total, int quantity){
        if (total==0){
            return "Error";
        }else{
            double total_d= total;
            double quantity_d=quantity;
            double avg= (quantity_d/total_d)*100; //2.3698
            DecimalFormat df= new DecimalFormat("#.##");// 2.36
            // df.setRoundingMode(RoundingMode.FLOOR); 2.37
            return df.format(avg);
        }
    }

    public String nameUser(File data, String idUser){
        String name="";
        try {
            //Para leer datos de un archivo plano se usa el FileReader
            FileReader reader= new FileReader(data);
            BufferedReader bufferedReader= new BufferedReader(reader);
            String user;
            while ((user=bufferedReader.readLine())!=null){
                String[] userData= user.split(",");
                if (idUser.equals(userData[0])){
                     name= userData[1];
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return name;
    }
}