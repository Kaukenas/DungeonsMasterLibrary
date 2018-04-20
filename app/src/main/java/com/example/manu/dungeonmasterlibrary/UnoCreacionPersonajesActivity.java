package com.example.manu.dungeonmasterlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class UnoCreacionPersonajesActivity extends AppCompatActivity {

    Button btnNextUno, btnCancelUno, btnRerroll;
    TextView txtFuerza, txtDestreza, txtConstitucion, txtInteligencia, txtSabiduria, txtCarisma;
    int numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uno_creacion_personajes);

        btnNextUno = findViewById(R.id.btnNextUno);
        btnCancelUno = findViewById(R.id.btnCancelUno);
        btnRerroll = findViewById(R.id.btnRerroll);
        txtFuerza = findViewById(R.id.txtFuerza);
        txtDestreza = findViewById(R.id.txtDestreza);
        txtConstitucion = findViewById(R.id.txtConstitucion);
        txtInteligencia = findViewById(R.id.txtInteligencia);
        txtSabiduria = findViewById(R.id.txtSabiduria);
        txtCarisma = findViewById(R.id.txtCarisma);

        tirarDados();

        btnRerroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tirarDados();
            }
        });

        btnNextUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UnoCreacionPersonajesActivity.this, DosCreacionPersonajesActivity.class));
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
}
