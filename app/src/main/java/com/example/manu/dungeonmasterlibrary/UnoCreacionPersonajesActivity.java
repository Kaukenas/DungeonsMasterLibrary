package com.example.manu.dungeonmasterlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.manu.dungeonmasterlibrary.POJOS.Clases;
import com.example.manu.dungeonmasterlibrary.POJOS.Features;
import com.example.manu.dungeonmasterlibrary.POJOS.Traits;
import com.example.manu.dungeonmasterlibrary.POJOS2.Ability;
import com.example.manu.dungeonmasterlibrary.POJOS2.AbilityScore;
import com.example.manu.dungeonmasterlibrary.POJOS2.Character;
import com.example.manu.dungeonmasterlibrary.POJOS2.Razas;
import com.example.manu.dungeonmasterlibrary.POJOS2.Class;
import com.example.manu.dungeonmasterlibrary.POJOS2.Skill;
import com.example.manu.dungeonmasterlibrary.RETROFIT.INTERFACES.CLASSES.GetClassesRetrofit;
import com.example.manu.dungeonmasterlibrary.RETROFIT.INTERFACES.RACES.GetRacesRetrofit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UnoCreacionPersonajesActivity extends AppCompatActivity {

    Button btnNextUno, btnCancelUno, btnRerroll;
    TextView txtFuerza, txtDestreza, txtConstitucion, txtInteligencia, txtSabiduria, txtCarisma;
    int numero;
    MultiSelectionSpinner spinnerClases, spinnerRazas;
    ArrayList<Class> listaclases;
    ArrayList<Razas> listarazas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uno_creacion_personajes);
        spinnerClases = findViewById(R.id.spinnerDATAClases);
        spinnerClases.setMax(1);
        spinnerRazas = findViewById(R.id.spinnerDATARazas);
        spinnerRazas.setMax(1);
        btnNextUno = findViewById(R.id.btnNextUno);
        btnNextUno.setEnabled(false);
        btnCancelUno = findViewById(R.id.btnCancelUno);
        btnRerroll = findViewById(R.id.btnRerroll);
        txtFuerza = findViewById(R.id.txtFuerza);
        txtDestreza = findViewById(R.id.txtDestreza);
        txtConstitucion = findViewById(R.id.txtConstitucion);
        txtInteligencia = findViewById(R.id.txtInteligencia);
        txtSabiduria = findViewById(R.id.txtSabiduria);
        txtCarisma = findViewById(R.id.txtCarisma);
        cargarClases();
        cargarRazas();
        tirarDados();

        List<String> clases = new ArrayList<>();
        clases.add("guerrero");
        clases.add("monje");
        clases.add("picaro");
        clases.add("barbaro");

        List<String> razas = new ArrayList<>();
        razas.add("elfo");
        razas.add("enano");

        spinnerClases.setItems(clases);
        spinnerRazas.setItems(razas);

        btnRerroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tirarDados();
            }
        });

        btnNextUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //IF ha seleccionado algo en clase y ha seleccionado algo en raza
                if (!spinnerClases.getSelectedItemsAsString().equals("") && !spinnerRazas.getSelectedItemsAsString().equals("")){

                    Class c = new Class();
                    Razas r = new Razas();
                    Character p = new Character();

                    Toast.makeText(UnoCreacionPersonajesActivity.this, ""+listaclases.size(), Toast.LENGTH_SHORT).show();
                        for (int i=0; i < listaclases.size(); i++){
                            if(listaclases.get(i).getName().equals(UnoCreacionPersonajesActivity.this.spinnerClases.obtenerSeleccion().get(0))){
                                Toast.makeText(UnoCreacionPersonajesActivity.this, "entrando al if", Toast.LENGTH_SHORT).show();
                                c = listaclases.get(i);
                            }
                        }


                        for (int i=0; i < listarazas.size(); i++){
                            if(listarazas.get(i).getName().equals(UnoCreacionPersonajesActivity.this.spinnerRazas.obtenerSeleccion().get(0))){
                                r = listarazas.get(i);
                            }
                        }

                        List<Ability> attrs = new ArrayList<Ability>();

                        Ability fuerza = new Ability();
                        fuerza.setFuerza(txtFuerza.getText().toString());
                        attrs.add(fuerza);
                        Ability destreza = new Ability();
                        fuerza.setDestreza(txtDestreza.getText().toString());
                        attrs.add(destreza);
                        Ability constitucion = new Ability();
                        fuerza.setConstitucion(txtConstitucion.getText().toString());
                        attrs.add(constitucion);
                        Ability inteligencia = new Ability();
                        fuerza.setInteligencia(txtInteligencia.getText().toString());
                        attrs.add(inteligencia);
                        Ability sabiduria = new Ability();
                        fuerza.setSabiduria(txtSabiduria.getText().toString());
                        attrs.add(sabiduria);
                        Ability carisma = new Ability();
                        fuerza.setCarisma(txtCarisma.getText().toString());
                        attrs.add(carisma);

                        p.setVida(Integer.parseInt(c.getHitDice())+obtenerBonoAtributo(Integer.parseInt(txtConstitucion.getText().toString())));
                        p.setAbilities(attrs);
                        p.setaClass(c);
                        p.setRaza(r);
                        Toast.makeText(UnoCreacionPersonajesActivity.this, ""+p.getaClass().getHitDice(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UnoCreacionPersonajesActivity.this, DosCreacionPersonajesActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("PERSONAJE",p);
                        intent.putExtras(bundle);
                        intent.setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
                        startActivity(intent);
                        finish();
                } else {
                    Toast.makeText(UnoCreacionPersonajesActivity.this, "Debes seleccionar una Clase y una Raza, no intentes explotarnos la APP", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnCancelUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    public void tirarDados(){
        txtFuerza.setText(""+tirarDadejo());
        txtDestreza.setText(""+tirarDadejo());
        txtConstitucion.setText(""+tirarDadejo());
        txtInteligencia.setText(""+tirarDadejo());
        txtSabiduria.setText(""+tirarDadejo());
        txtCarisma.setText(""+tirarDadejo());
    }

    public int tirarDadejo(){
        numero = (int) (Math.random() * 11) + 5;
        return numero;
    }

    public int obtenerBonoAtributo(int atributo){
        int bono;
        if((atributo % 2)==0){
            bono=(atributo-10)/2;
        }else{
            bono=(atributo-11)/2;
        }
        return bono;
    }

    public void cargarRazas() {
        listarazas=new ArrayList<>();

        String baseurl = "http://thedmlibrary.ddns.net/api/index.php/";

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GetRacesRetrofit Api = retrofit.create(GetRacesRetrofit.class);

        Call<List<Razas>> call = Api.loadChanges();
        call.enqueue(new Callback<List<Razas>>() {
            @Override
            public void onResponse(Call<List<Razas>> call, Response<List<Razas>> response) {
                List<Razas> c = response.body();
                for (int i = 0; i <c.size() ; i++) {
                    switch (c.get(i).getId()){
                        case "1":{
                            c.get(i).setTraitsArrayList(cargarEnano());
                            break;
                        }
                        case "2":{
                            c.get(i).setTraitsArrayList(cargarElfo());
                            break;
                        }
                    }
                    listarazas.add(c.get(i));
                }
                btnNextUno.setEnabled(true);
            }

            @Override
            public void onFailure(Call<List<Razas>> call, Throwable t) {

            }
        });

    }

    public ArrayList<Traits> cargarEnano(){
        ArrayList<Traits> listaTraits = new ArrayList<>();
        Traits t = new Traits("aguante enano", "ventaja en tiradas de salvacion contra veneno") {
            @Override
            public void accion() {
                super.accion();
                int numero = (int) (Math.random() * 1) + 19;
                int numero2 = (int) (Math.random() * 1) +19;
                int resultado = 0;
                if (numero > numero2){
                    resultado = numero;
                } else {
                    resultado = numero2;
                }
                Toast.makeText(getApplicationContext(), "Tu tirada es de: " + resultado, Toast.LENGTH_SHORT).show();
            }
        };
        listaTraits.add(t);
        t = new Traits("entrenamiento de combate", "Tienes competencia con hacha de batalla, hacha, martillo ligero y martillo de guerra") {};
        listaTraits.add(t);
        t = new Traits("oompetencia con herramientas", "ganas competencia con una de las siguientes herramientas: de herrero, de cervecero, de masoneria") {};
        listaTraits.add(t);
        t = new Traits("afinidad con la piedra", "Siempre que hagas una tirada con trabajos relacionados en piedra tines ventsja") {
            @Override
            public void accion() {
                super.accion();
                int numero = (int) (Math.random() * 1) + 19;
                int numero2 = (int) (Math.random() * 1) +19;
                int resultado = 0;
                if (numero > numero2){
                    resultado = numero;
                } else {
                    resultado = numero2;
                }
                Toast.makeText(getApplicationContext(), "Tu tirada es de: " + resultado, Toast.LENGTH_SHORT).show();
            }
        };
        listaTraits.add(t);
        t = new Traits("vision en la oscuridad", "Ves a 60 pies en la oscuridad") {
            @Override
            public void accion() {
                super.accion();
                int numero = (int) (Math.random() * 1) + 19;
                int numero2 = (int) (Math.random() * 1) +19;
                int resultado = 0;
                if (numero > numero2){
                    resultado = numero;
                } else {
                    resultado = numero2;
                }
                Toast.makeText(getApplicationContext(), "Tu tirada es de: " + resultado, Toast.LENGTH_SHORT).show();
            }
        };
        listaTraits.add(t);
        return listaTraits;
    }

    public ArrayList<Traits> cargarElfo(){
        ArrayList<Traits> listaTraits = new ArrayList<>();
        Traits t = new Traits("sentidos agudos", "eres competente con la habilidad percepcion") {
            public void accion(Character p) {
                super.accion();
                List<Skill> h = p.getSkills();
                h.add(new Skill("percepcion"));
                p.setSkills(h);
            }
        };
        listaTraits.add(t);
        t = new Traits("origen feerico", "Ventaja en tiradas de dormir") {
            public void accion() {
                super.accion();
                int numero = (int) (Math.random() * 1) + 19;
                int numero2 = (int) (Math.random() * 1) +19;
                int resultado = 0;
                if (numero > numero2){
                    resultado = numero;
                } else {
                    resultado = numero2;
                }
                Toast.makeText(getApplicationContext(), "Tu tirada es de: " + resultado, Toast.LENGTH_SHORT).show();
            }
        };
        listaTraits.add(t);
        t = new Traits("trance", "no necesitas dormir, solo meditar 4 horas") {};
        listaTraits.add(t);
        t = new Traits("vision en la oscuridad", "Ves a 60 pies en la oscuridad") {
            @Override
            public void accion() {
                super.accion();
                int numero = (int) (Math.random() * 1) + 19;
                int numero2 = (int) (Math.random() * 1) +19;
                int resultado = 0;
                if (numero > numero2){
                    resultado = numero;
                } else {
                    resultado = numero2;
                }
                Toast.makeText(getApplicationContext(), "Tu tirada es de: " + resultado, Toast.LENGTH_SHORT).show();
            }
        };
        listaTraits.add(t);
        return listaTraits;
    }

    public ArrayList<Class> cargarClases(){
        listaclases= new ArrayList<>();
        String baseurl = "http://thedmlibrary.ddns.net/api/index.php/";

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GetClassesRetrofit Api = retrofit.create(GetClassesRetrofit.class);

        Call<List<Class>> call = Api.loadChanges();
        call.enqueue(new Callback<List<Class>>() {
            @Override
            public void onResponse(Call<List<Class>> call, Response<List<Class>> response) {
                List<Class> c = response.body();
                for (int i = 0; i <c.size() ; i++) {
                    Toast.makeText(UnoCreacionPersonajesActivity.this, c.get(i).getName(), Toast.LENGTH_SHORT).show();
                    switch (c.get(i).getId()){
                        case "1":{
                            c.get(i).setFeatures(cargarGuerrero());
                            break;
                        }
                        case "2":{
                            c.get(i).setFeatures(cargarMonje());
                            break;
                        }
                        case "3":{
                            c.get(i).setFeatures(cargarPicaro());
                            break;
                        }
                        case "4":{
                            c.get(i).setFeatures(cargarBarbaro());
                            break;
                        }
                    }
                    listaclases.add(c.get(i));
                }
            }

            @Override
            public void onFailure(Call<List<Class>> call, Throwable t) {

            }
        });
        return listaclases;
    }

    public ArrayList<Features> cargarGuerrero() {
        ArrayList<Features> listaFeatures = new ArrayList<>();
        Features f = new Features("Estilo de combate","Descripcion de Estilo de Combate",false,"CA",1) {
            public void accion(Character p) {
                super.accion();
                p.setCA(p.getCA()+1);
            }
        };
        listaFeatures.add(f);
        f = new Features("Nuevas Energias","Descripcion de Nuevas Energias",true,"HEAL",1) {
            public void accion(Character p) {
                super.accion();
                p.setVida(p.getVida()+5);
            }
        };
        listaFeatures.add(f);
        f = new Features("Oleada de Accion", "Descripcion de Oleada de Accion", true, "NULL",2) {
            @Override
            public void accion() {
                super.accion();
            }
        };
        listaFeatures.add(f);
        f = new Features("Arquetipo Marcial", "Descripcion de Arquetipo Marcial", false, "DAMAGE",3) {
            public void accion(Character p) {
                super.accion();
                p.setDAMAGE(p.getDAMAGE()+1);
            }
        };
        listaFeatures.add(f);
        f = new Features ("Mejora Caracteristica", "Descripcion de Mejora Caracteristica", true, "NULL",4){
            public void accion(){
                super.accion();
                Toast.makeText(getApplicationContext(), "Mejora Caracteristica" + 4, Toast.LENGTH_SHORT).show();
            }
        };
        listaFeatures.add(f);
        f = new Features ("Ataque Extra", "Descripcion de Ataque Extra", true, "NULL",5){
            public void accion(){
                super.accion();
            }
        };
        listaFeatures.add(f);
        f = new Features ("Mejora Caracteristica", "Descripcion de Mejora Caracteristica", true, "NULL",6){
            public void accion(){
                super.accion();
                Toast.makeText(getApplicationContext(), "Mejora Caracteristica" + 6, Toast.LENGTH_SHORT).show();

            }
        };
        listaFeatures.add(f);
        f = new Features ("Estilo Combate 2", "Descripcion de Estilo Combate 2", false, "CA",7){
            public void accion(Character p) {
                super.accion();
                p.setCA(p.getCA()+2);
            }
        };
        listaFeatures.add(f);
        f = new Features ("Mejora Caracteristica", "Descripcion de Mejora Caracteristica", true, "NULL",8){
            public void accion(){
                super.accion();
                Toast.makeText(getApplicationContext(), "Mejora Caracteristica" + 8, Toast.LENGTH_SHORT).show();
            }
        };
        listaFeatures.add(f);

        return listaFeatures;
    }

    public ArrayList<Features> cargarMonje() {
        ArrayList<Features> listaFeatures = new ArrayList<>();
        Features f = new Features("Estilo de combate","Descripcion de Estilo de Combate",false,"CA",1) {
            public void accion(Character p) {
                super.accion();
                p.setCA(p.getCA()+1);
            }
        };
        listaFeatures.add(f);
        f = new Features("Nuevas Energias","Descripcion de Nuevas Energias",true,"HEAL",1) {
            public void accion(Character p) {
                super.accion();
                p.setVida(p.getVida()+5);
            }
        };
        listaFeatures.add(f);
        f = new Features("Oleada de Accion", "Descripcion de Oleada de Accion", true, "NULL",2) {
            @Override
            public void accion() {
                super.accion();
            }
        };
        listaFeatures.add(f);
        f = new Features("Arquetipo Marcial", "Descripcion de Arquetipo Marcial", false, "DAMAGE",3) {
            public void accion(Character p) {
                super.accion();
                p.setDAMAGE(p.getDAMAGE()+1);
            }
        };
        listaFeatures.add(f);
        f = new Features ("Mejora Caracteristica", "Descripcion de Mejora Caracteristica", true, "NULL",4){
            public void accion(){
                super.accion();
                Toast.makeText(getApplicationContext(), "Mejora Caracteristica" + 4, Toast.LENGTH_SHORT).show();
            }
        };
        listaFeatures.add(f);
        f = new Features ("Ataque Extra", "Descripcion de Ataque Extra", true, "NULL",5){
            public void accion(){
                super.accion();
            }
        };
        listaFeatures.add(f);
        f = new Features ("Mejora Caracteristica", "Descripcion de Mejora Caracteristica", true, "NULL",6){
            public void accion(){
                super.accion();
                Toast.makeText(getApplicationContext(), "Mejora Caracteristica" + 6, Toast.LENGTH_SHORT).show();

            }
        };
        listaFeatures.add(f);
        f = new Features ("Estilo Combate 2", "Descripcion de Estilo Combate 2", false, "CA",7){
            public void accion(Character p) {
                super.accion();
                p.setCA(p.getCA()+2);
            }
        };
        listaFeatures.add(f);
        f = new Features ("Mejora Caracteristica", "Descripcion de Mejora Caracteristica", true, "NULL",8){
            public void accion(){
                super.accion();
                Toast.makeText(getApplicationContext(), "Mejora Caracteristica" + 8, Toast.LENGTH_SHORT).show();
            }
        };
        listaFeatures.add(f);

        return listaFeatures;
    }

    public ArrayList<Features> cargarPicaro() {
        ArrayList<Features> listaFeatures = new ArrayList<>();
        Features f = new Features("Estilo de combate","Descripcion de Estilo de Combate",false,"CA",1) {
            public void accion(Character p) {
                super.accion();
                p.setCA(p.getCA()+1);
            }
        };
        listaFeatures.add(f);
        f = new Features("Nuevas Energias","Descripcion de Nuevas Energias",true,"HEAL",1) {
            public void accion(Character p) {
                super.accion();
                p.setVida(p.getVida()+5);
            }
        };
        listaFeatures.add(f);
        f = new Features("Oleada de Accion", "Descripcion de Oleada de Accion", true, "NULL",2) {
            @Override
            public void accion() {
                super.accion();
            }
        };
        listaFeatures.add(f);
        f = new Features("Arquetipo Marcial", "Descripcion de Arquetipo Marcial", false, "DAMAGE",3) {
            public void accion(Character p) {
                super.accion();
                p.setDAMAGE(p.getDAMAGE()+1);
            }
        };
        listaFeatures.add(f);
        f = new Features ("Mejora Caracteristica", "Descripcion de Mejora Caracteristica", true, "NULL",4){
            public void accion(){
                super.accion();
                Toast.makeText(getApplicationContext(), "Mejora Caracteristica" + 4, Toast.LENGTH_SHORT).show();
            }
        };
        listaFeatures.add(f);
        f = new Features ("Ataque Extra", "Descripcion de Ataque Extra", true, "NULL",5){
            public void accion(){
                super.accion();
            }
        };
        listaFeatures.add(f);
        f = new Features ("Mejora Caracteristica", "Descripcion de Mejora Caracteristica", true, "NULL",6){
            public void accion(){
                super.accion();
                Toast.makeText(getApplicationContext(), "Mejora Caracteristica" + 6, Toast.LENGTH_SHORT).show();

            }
        };
        listaFeatures.add(f);
        f = new Features ("Estilo Combate 2", "Descripcion de Estilo Combate 2", false, "CA",7){
            public void accion(Character p) {
                super.accion();
                p.setCA(p.getCA()+2);
            }
        };
        listaFeatures.add(f);
        f = new Features ("Mejora Caracteristica", "Descripcion de Mejora Caracteristica", true, "NULL",8){
            public void accion(){
                super.accion();
                Toast.makeText(getApplicationContext(), "Mejora Caracteristica" + 8, Toast.LENGTH_SHORT).show();
            }
        };
        listaFeatures.add(f);

        return listaFeatures;
    }

    public ArrayList<Features> cargarBarbaro() {
        ArrayList<Features> listaFeatures = new ArrayList<>();
        Features f = new Features("Estilo de combate","Descripcion de Estilo de Combate",false,"CA",1) {
            public void accion(Character p) {
                super.accion();
                p.setCA(p.getCA()+1);
            }
        };
        listaFeatures.add(f);
        f = new Features("Nuevas Energias","Descripcion de Nuevas Energias",true,"HEAL",1) {
            public void accion(Character p) {
                super.accion();
                p.setVida(p.getVida()+5);
            }
        };
        listaFeatures.add(f);
        f = new Features("Oleada de Accion", "Descripcion de Oleada de Accion", true, "NULL",2) {
            @Override
            public void accion() {
                super.accion();
            }
        };
        listaFeatures.add(f);
        f = new Features("Arquetipo Marcial", "Descripcion de Arquetipo Marcial", false, "DAMAGE",3) {
            public void accion(Character p) {
                super.accion();
                p.setDAMAGE(p.getDAMAGE()+1);
            }
        };
        listaFeatures.add(f);
        f = new Features ("Mejora Caracteristica", "Descripcion de Mejora Caracteristica", true, "NULL",4){
            public void accion(){
                super.accion();
                Toast.makeText(getApplicationContext(), "Mejora Caracteristica" + 4, Toast.LENGTH_SHORT).show();
            }
        };
        listaFeatures.add(f);
        f = new Features ("Ataque Extra", "Descripcion de Ataque Extra", true, "NULL",5){
            public void accion(){
                super.accion();
            }
        };
        listaFeatures.add(f);
        f = new Features ("Mejora Caracteristica", "Descripcion de Mejora Caracteristica", true, "NULL",6){
            public void accion(){
                super.accion();
                Toast.makeText(getApplicationContext(), "Mejora Caracteristica" + 6, Toast.LENGTH_SHORT).show();

            }
        };
        listaFeatures.add(f);
        f = new Features ("Estilo Combate 2", "Descripcion de Estilo Combate 2", false, "CA",7){
            public void accion(Character p) {
                super.accion();
                p.setCA(p.getCA()+2);
            }
        };
        listaFeatures.add(f);
        f = new Features ("Mejora Caracteristica", "Descripcion de Mejora Caracteristica", true, "NULL",8){
            public void accion(){
                super.accion();
                Toast.makeText(getApplicationContext(), "Mejora Caracteristica" + 8, Toast.LENGTH_SHORT).show();
            }
        };
        listaFeatures.add(f);

        return listaFeatures;
    }


}
