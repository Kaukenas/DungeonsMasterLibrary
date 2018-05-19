package com.example.manu.dungeonmasterlibrary;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.manu.dungeonmasterlibrary.POJOS.Objetos;
import com.example.manu.dungeonmasterlibrary.POJOS2.Character;

import org.json.JSONException;

import java.util.ArrayList;

public class MostrarDosPersonajesActivity extends AppCompatActivity {

    TextView txtResultadoTirada, textViewFuerzA, textViewInteligenciA, textViewDestrezA, textViewSabiduriA,
            textViewConstitucioN, textViewCarismA;
    ImageButton imgBtn1, imgBtn12, imgBtn21, imgBtn22, imgBtn31, imgBtn32;
    Character personajes;
    static Activity a;
    BottomNavigationView bottomNavigationView;
    ArrayList<Objetos> listaObjetos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_dos_personajes);

        imgBtn1 = findViewById(R.id.imgBtn1);
        imgBtn12 = findViewById(R.id.imgBtn12);
        imgBtn21 = findViewById(R.id.imgBtn21);
        imgBtn22 = findViewById(R.id.imgBtn22);
        imgBtn31 = findViewById(R.id.imgBtn31);
        imgBtn32 = findViewById(R.id.imgBtn32);
        textViewFuerzA = findViewById(R.id.scuo);
        textViewInteligenciA = findViewById(R.id.vvvvv);
        textViewDestrezA = findViewById(R.id.tettever);
        textViewSabiduriA = findViewById(R.id.textViewSaBiduria);
        textViewConstitucioN = findViewById(R.id.txtCoNstitucion);
        textViewCarismA = findViewById(R.id.txtCaRisma);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setSelectedItemId(R.id.habilidadesItem);

        a.finish();
        personajes = getIntent().getExtras().getParcelable("PERSONAJE");

            textViewFuerzA.setText(personajes.getAbilities().get(0).getFuerza());
            textViewDestrezA.setText(personajes.getAbilities().get(1).getDestreza());
            textViewConstitucioN.setText(personajes.getAbilities().get(2).getConstitucion());
            textViewInteligenciA.setText(personajes.getAbilities().get(3).getInteligencia());
            textViewSabiduriA.setText(personajes.getAbilities().get(4).getSabiduria());
            textViewCarismA.setText(personajes.getAbilities().get(5).getCarisma());

        Objetos o = new Objetos();
        ArrayList<Objetos> objetosArrayList = cargarArmas();
        for(int i=0; i < objetosArrayList.size(); i++) {
            o = objetosArrayList.get(i);
            Toast.makeText(this, "NOMBRE ARMA " + o.getNombreArma(), Toast.LENGTH_SHORT).show();
        }
        Objetos finalO = o;
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.combateItem:
                        Intent intent = new Intent(MostrarDosPersonajesActivity.this,MostrarUnoPersonajeActivity.class);
                        intent.putExtras(getIntent().getExtras());
                        MostrarUnoPersonajeActivity.setActivity(MostrarDosPersonajesActivity.this);
                        startActivity(intent);
                        break;
                    case R.id.habilidadesItem:
                        break;
                    case R.id.equipamientoItem:
                        Intent intentEquipamiento = new Intent(MostrarDosPersonajesActivity.this,MostrarTresPersonajesActivity.class);
                        Bundle bundle = new Bundle();
                        intentEquipamiento.putExtras(getIntent().getExtras());
                        MostrarTresPersonajesActivity.setActivity(MostrarDosPersonajesActivity.this);
                        startActivity(intentEquipamiento);
                        break;
                    case R.id.rasgosItem:
                        Intent intentRas = new Intent(MostrarDosPersonajesActivity.this,MostrarCuatroPersonajesActivity.class);
                        intentRas.putExtras(getIntent().getExtras());
                        MostrarCuatroPersonajesActivity.setActivity(MostrarDosPersonajesActivity.this);
                        startActivity(intentRas);
                        break;
                }
                return true;
            }
        });
        imgBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog =MyCustomAlertDialog();
                dialog.show();
            }
        });

        imgBtn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog =MyCustomAlertDialog();
                dialog.show();
            }
        });

        imgBtn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog =MyCustomAlertDialog();
                dialog.show();
            }
        });

        imgBtn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog =MyCustomAlertDialog();
                dialog.show();
            }
        });

        imgBtn31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog =MyCustomAlertDialog();
                dialog.show();
            }
        });

        imgBtn32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog =MyCustomAlertDialog();
                dialog.show();
            }
        });

    }

    public int tirarDado(int rango) {
        double resultado;
        resultado=Math.random()*rango;
        return (int)resultado;
    }

    public AlertDialog MyCustomAlertDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater layoutInflater = this.getLayoutInflater();
        View mylayout =layoutInflater.inflate(R.layout.dialog_signin, null);
        txtResultadoTirada =  mylayout.findViewById(R.id.txtResultadoTirada);
        int tirada=tirarDado(20);
        txtResultadoTirada.setText(""+tirada);
        builder.setView(mylayout).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        return builder.create();
    }



    public static void setActivity(Activity activity){
        MostrarDosPersonajesActivity.a=activity;
    }
    public ArrayList<Objetos> cargarArmas(){
        Objetos objetos = new Objetos("Espada corta",1,6,1,"Arma");
        listaObjetos.add(objetos);
        return listaObjetos;
    }
}
