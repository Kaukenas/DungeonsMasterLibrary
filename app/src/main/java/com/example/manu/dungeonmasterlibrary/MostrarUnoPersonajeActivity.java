package com.example.manu.dungeonmasterlibrary;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.manu.dungeonmasterlibrary.POJOS.Clases;
import com.example.manu.dungeonmasterlibrary.POJOS.Objetos;
import com.example.manu.dungeonmasterlibrary.POJOS.Personajes;
import com.example.manu.dungeonmasterlibrary.POJOS2.Ability;
import com.example.manu.dungeonmasterlibrary.POJOS2.Character;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class MostrarUnoPersonajeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ImageButton imageButtonDados1, imageButtonDados2,imageButtonDados3,imageButtonDados4,
            imageButtonDados5,imageButtonDados6,imageButtonDados7, imageButton51, imageButton52,
            imageButton61, imageButton62;
    TextView txtResultadoTirada, txtFuerza, txtInteligencia, txtDestreza, txtSabiduria,
            txtConstitucion, txtCarisma, txtVidaCambia, txtIniciativa, txtAtaqueCC, txtCA,
            txtADistancia;
    Character personajes;
    ProgressBar pbVida;
    int sumar = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_uno_personaje);

        pbVida= findViewById(R.id.pbVida);
        imageButton51 = findViewById(R.id.imageButton51);
        imageButton52 = findViewById(R.id.imageButton52);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        imageButtonDados1 = findViewById(R.id.imageButtonDados1);
        imageButtonDados2 = findViewById(R.id.imageButtonDados2);
        imageButtonDados3 = findViewById(R.id.imageButtonDados3);
        imageButtonDados4 = findViewById(R.id.imageButtonDados4);
        imageButtonDados5 = findViewById(R.id.imageButtonDados5);
        imageButtonDados6 = findViewById(R.id.imageButtonDados6);
        imageButtonDados7 = findViewById(R.id.imageButtonDados7);
        imageButton61 = findViewById(R.id.imageButton61);
        imageButton62 = findViewById(R.id.imageButton62);
        txtFuerza = findViewById(R.id.txtFuerza);
        txtInteligencia = findViewById(R.id.txtInteligencia);
        txtDestreza = findViewById(R.id.txtDestreza);
        txtSabiduria = findViewById(R.id.txtSabiduria);
        txtConstitucion = findViewById(R.id.txtConstitucion);
        txtCarisma = findViewById(R.id.txtCarisma);
        txtVidaCambia = findViewById(R.id.txtVidaCambia);
        txtIniciativa = findViewById(R.id.txtIniciativa);
        txtAtaqueCC = findViewById(R.id.txtAtaqueCC);
        txtCA = findViewById(R.id.txtCA);
        txtADistancia = findViewById(R.id.txtADistancia);

        Objetos o = new Objetos();
        ArrayList<Objetos> objetosArrayList = cargarArmas();
        for (int i=0; i < objetosArrayList.size(); i++) {
            o = objetosArrayList.get(i);
            Toast.makeText(this, "NOMBRE ARMA " + o.getNombreArma(), Toast.LENGTH_SHORT).show();
        }


        pbVida.setProgress(100);
        pbVida.getProgressDrawable().setColorFilter(
                Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN);
        txtVidaCambia.setText(String.valueOf(100));

        imageButton51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sumar = sumar -2;
                int x = pbVida.getProgress();
                pbVida.setProgress(x + (sumar));
                int z = Integer.parseInt(String.valueOf(txtVidaCambia.getText()));
                txtVidaCambia.setText(String.valueOf(z + (sumar)));
                sumar=0;

                if (pbVida.getProgress() >= 50){
                    pbVida.getProgressDrawable().setColorFilter(
                            Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN);
                } else {
                    pbVida.getProgressDrawable().setColorFilter(
                            Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                }
            }
        });

        imageButton52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sumar = sumar +2;
                int y = pbVida.getProgress();
                pbVida.setProgress(y + (sumar));
                int w = Integer.parseInt(String.valueOf(txtVidaCambia.getText()));
                txtVidaCambia.setText(String.valueOf(w + (sumar)));
                sumar=0;

                if (pbVida.getProgress() >= 50){
                    pbVida.getProgressDrawable().setColorFilter(
                            Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN);
                } else {
                    pbVida.getProgressDrawable().setColorFilter(
                            Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                }
            }

        });

        personajes = getIntent().getExtras().getParcelable("PERSONAJE");
        //Toast.makeText(this, "Atributos"+ personajes.getAtributos(), Toast.LENGTH_SHORT).show();


        cargarAtributos();



        /*int destreza = Integer.parseInt(String.valueOf(txtDestreza.getText()));
        if (destreza %2 == 0) {
            txtIniciativa.setText(String.valueOf((destreza - 10)/2));
        } else {
            txtIniciativa.setText(String.valueOf((destreza - 11)/2));
        }

        int fuerza = Integer.parseInt(String.valueOf(txtFuerza.getText()));
        if (fuerza %2 == 0) {
            txtAtaqueCC.setText(String.valueOf((fuerza - 10)/2));
        } else {
            txtAtaqueCC.setText(String.valueOf((fuerza - 11)/2));
        }

        int iniciativa = Integer.parseInt(String.valueOf(txtIniciativa.getText()));
        txtCA.setText(String.valueOf(iniciativa+14));
        txtADistancia.setText(String.valueOf(iniciativa));

        imageButton62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int CA = Integer.parseInt(String.valueOf(txtCA.getText()));
                txtCA.setText(String.valueOf(CA+1));
            }
        });*/

        imageButton61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int CA = Integer.parseInt(String.valueOf(txtCA.getText()));
                txtCA.setText(String.valueOf(CA-1));
            }
        });

        Objetos finalO = o;
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.combateItem:
                        //setContentView(R.layout.activity_mostrar_uno_personaje);
                        break;
                    case R.id.habilidadesItem:
                        Intent intent = new Intent(MostrarUnoPersonajeActivity.this,MostrarDosPersonajesActivity.class);
                        intent.putExtras(getIntent().getExtras());
                        MostrarDosPersonajesActivity.setActivity(MostrarUnoPersonajeActivity.this);
                        startActivity(intent);
                        break;
                    case R.id.equipamientoItem:
                        Intent intentEquipamiento = new Intent(MostrarUnoPersonajeActivity.this,MostrarTresPersonajesActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("ARMAS", finalO);
                        intentEquipamiento.putExtras(bundle);
                        MostrarTresPersonajesActivity.setActivity(MostrarUnoPersonajeActivity.this);
                        startActivity(intentEquipamiento);
                        break;
                        //setContentView(R.layout.activity_mostrar_tres_personajes);
                        //break;
                    case R.id.rasgosItem:
                        break;
                }
                return true;
            }
        });

        imageButtonDados1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog =MyCustomAlertDialog();
                dialog.show();
            }
        });

        imageButtonDados2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog =MyCustomAlertDialog();
                dialog.show();
            }
        });

        imageButtonDados3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog =MyCustomAlertDialog();
                dialog.show();
            }
        });

        imageButtonDados4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog =MyCustomAlertDialog();
                dialog.show();
            }
        });

        imageButtonDados5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog =MyCustomAlertDialog();
                dialog.show();
            }
        });

        imageButtonDados6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog =MyCustomAlertDialog();
                dialog.show();
            }
        });

        imageButtonDados7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog =MyCustomAlertDialog();
                dialog.show();
            }
        });
    }

    public void cargarAtributos(){
            txtFuerza.setText(personajes.getAbilities().get(0).getFuerza());
            txtInteligencia.setText(personajes.getAbilities().get(1).getDestreza());
            txtDestreza.setText(personajes.getAbilities().get(2).getConstitucion());
            txtSabiduria.setText(personajes.getAbilities().get(3).getInteligencia());
            txtConstitucion.setText(personajes.getAbilities().get(4).getSabiduria());
            txtCarisma.setText(personajes.getAbilities().get(5).getCarisma());
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

    public ArrayList<Objetos> cargarArmas(){
        ArrayList<Objetos> listaClases = new ArrayList<>();
        Objetos objetos = new Objetos("Espada corta",1,6,1,"Arma");
        listaClases.add(objetos);
        return listaClases;
    }

}
