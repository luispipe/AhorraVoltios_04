package com.example.ahorravoltios_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ahorravoltios_04.models.User;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class RegisterUserActivity extends AppCompatActivity {

    TextInputLayout name,email,phone,password1,password2;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        name= findViewById(R.id.name_user);
        email=findViewById(R.id.email_user);
        register=findViewById(R.id.buttonUserRegister);
        phone=findViewById(R.id.phone_user);
        password1=findViewById(R.id.password1_user);
        password2=findViewById(R.id.password2_user);

        Intent login= new Intent(getApplicationContext(),
                MainActivity.class);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateUser()){
                    User user=createrUser();
                    saveUser(user);
                    startActivity(login);
                }else{
                Toast.makeText(getApplicationContext(),
            "Todos los campos deben estar diligenciados",Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    public boolean validateUser(){
        boolean validate= true;

        if(name.getEditText().getText().toString().isEmpty()){
            name.setBoxBackgroundColor(Color.RED);
            validate=false;
        }
        if (email.getEditText().getText().toString().isEmpty()){
            email.setBoxBackgroundColor(Color.RED);
            validate=false;
        }
        if (phone.getEditText().getText().toString().isEmpty()){
            phone.setBoxBackgroundColor(Color.RED);
            validate=false;
        }
        if (password1.getEditText().getText().toString().isEmpty()){
            password1.setBoxBackgroundColor(Color.RED);
            validate=false;
        }
        if (password2.getEditText().getText().toString().isEmpty()){
            password2.setBoxBackgroundColor(Color.RED);
            validate=false;
        }
        if (!password1.getEditText().getText().toString().equals(password2.getEditText().getText().toString())){
            password1.setBoxBackgroundColor(Color.RED);
            password2.setBoxBackgroundColor(Color.RED);
            validate=false;
        }

        return validate;
    }

    public User createrUser(){
        String id,nameUser,emailUser,phoneUser,password;

        nameUser= name.getEditText().getText().toString();
        id=generateID(nameUser);
        emailUser=email.getEditText().getText().toString();
        phoneUser=phone.getEditText().getText().toString();
        password=password1.getEditText().getText().toString();
        User user= new User(id,nameUser,emailUser,phoneUser,password);

        return user;
    }
    /* Se generar el id de forma aleatoria tomando 2 letras del nombre
    *  y dos números aleatorios de 0-1000
    * */
     public String generateID(String name){
         String id="";
         for (int i=0;i<2;i++){
             int letra= (int) (Math.random()*name.length());
             int number= (int)(Math.random()*1000);
             id+=name.charAt(letra);
             id+=number;
         }
         return id;
      /* nombre= Luis
      *  id= ""
      *  letra= aleatorio(0,4) --> 3
      *  number= aleatorio(0.1000) -->529
      *  id="s529"
      *  letra= aleatorio(0,4) --> 1
      *  number= aleatorio(0.1000) -->874
      *  id="s529u874"
      * */

     }

    public void saveUser(User user){

        //Crear archivo plano
        File fileUser= new File(getFilesDir(),"user.txt");

        //Try catch --> es un componente de java para la captura de errores
        //en el try se realiza la acción
        //en el catch se supervisa que no pase ningun error y si pasa lo captura para despues mostrarlo

        try {
            //Se define el FileWriter
            FileWriter writer=new FileWriter(fileUser,true);
            //BufferedWriter se utiliza para almacenar muchos datos (recomendado)
            BufferedWriter bufferedWriter= new BufferedWriter(writer);
            bufferedWriter.write(
                    user.getId()+","+
                       user.getName()+","+
                       user.getEmail()+","+
                       user.getPhone()+","+
                       user.getPassword()
                    );
            bufferedWriter.newLine();
            bufferedWriter.close();
        }catch (Exception error){
            error.printStackTrace();
        }

    }



}