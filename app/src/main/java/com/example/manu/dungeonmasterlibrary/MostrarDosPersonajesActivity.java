package com.example.manu.dungeonmasterlibrary;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.manu.dungeonmasterlibrary.POJOS.Personajes;

import org.json.JSONException;

public class MostrarDosPersonajesActivity extends AppCompatActivity {

    TextView txtResultadoTirada, textViewFuerzA, textViewInteligenciA, textViewDestrezA, textViewSabiduriA,
            textViewConstitucioN, textViewCarismA;
    ImageButton imgBtn1, imgBtn12, imgBtn21, imgBtn22, imgBtn31, imgBtn32;
    Personajes personajes;
    static Activity a;

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

        a.finish();
        personajes = getIntent().getExtras().getParcelable("PERSONAJE");
        Toast.makeText(this, "Atributos"+ personajes.getAtributos(), Toast.LENGTH_SHORT).show();

        try {
            textViewFuerzA.setText(personajes.getAtributos().getString("fuerza"));
            textViewInteligenciA.setText(personajes.getAtributos().getString("inteligencia"));
            textViewDestrezA.setText(personajes.getAtributos().getString("destreza"));
            textViewSabiduriA.setText(personajes.getAtributos().getString("sabiduria"));
            textViewConstitucioN.setText(personajes.getAtributos().getString("constitucion"));
            textViewCarismA.setText(personajes.getAtributos().getString("carisma"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

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
}
