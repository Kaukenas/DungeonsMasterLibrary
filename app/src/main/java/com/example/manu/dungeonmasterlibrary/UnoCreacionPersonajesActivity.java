package com.example.manu.dungeonmasterlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.manu.dungeonmasterlibrary.POJOS.Clases;
import com.example.manu.dungeonmasterlibrary.POJOS.Personajes;
import com.example.manu.dungeonmasterlibrary.POJOS.Razas;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UnoCreacionPersonajesActivity extends AppCompatActivity {

    Button btnNextUno, btnCancelUno, btnRerroll;
    TextView txtFuerza, txtDestreza, txtConstitucion, txtInteligencia, txtSabiduria, txtCarisma;
    int numero;
    MultiSelectionSpinner spinnerClases, spinnerRazas;
    CargarDatos cargarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uno_creacion_personajes);

        cargarDatos = new CargarDatos(getApplicationContext());
        spinnerClases = findViewById(R.id.spinnerDATAClases);
        spinnerClases.setMax(1);
        spinnerRazas = findViewById(R.id.spinnerDATARazas);
        spinnerRazas.setMax(1);
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

        List<String> clases = new ArrayList<>();
        clases.add("guerrero");

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

                    Clases c = new Clases();
                    Razas r = new Razas();
                    Personajes p = new Personajes();
                    try {
                        ArrayList<Clases> clases = cargarDatos.cargarClases();
                        ArrayList<Razas> razas = cargarDatos.cargarRazas();

                        for (int i=0; i < clases.size(); i++){
                            if(clases.get(i).getNombre().equals(UnoCreacionPersonajesActivity.this.spinnerClases.obtenerSeleccion().get(0))){

                                c = clases.get(i);
                            }
                        }

                        for (int i=0; i < razas.size(); i++){
                            if(razas.get(i).getName().equals(UnoCreacionPersonajesActivity.this.spinnerRazas.obtenerSeleccion().get(0))){
                                r = razas.get(i);
                            }
                        }

                        JSONObject attrs = new JSONObject();
                        attrs.put("fuerza", Integer.parseInt(txtFuerza.getText().toString()));
                        attrs.put("destreza", Integer.parseInt(txtDestreza.getText().toString()));
                        attrs.put("constitucion", Integer.parseInt(txtConstitucion.getText().toString()));
                        attrs.put("inteligencia", Integer.parseInt(txtInteligencia.getText().toString()));
                        attrs.put("sabiduria", Integer.parseInt(txtSabiduria.getText().toString()));
                        attrs.put("carisma", Integer.parseInt(txtCarisma.getText().toString()));

                        p.setVIDA(c.getDadoGolpe()+obtenerBonoAtributo(Integer.parseInt(txtConstitucion.getText().toString())));
                        p.setAtributos(attrs);
                        p.setClases(c);
                        p.setRazas(r);
                        //Toast.makeText(UnoCreacionPersonajesActivity.this, c.getNombre(), Toast.LENGTH_SHORT).show();
                        //Toast.makeText(UnoCreacionPersonajesActivity.this, r.getName(), Toast.LENGTH_SHORT).show();
                        //Toast.makeText(UnoCreacionPersonajesActivity.this.getApplicationContext(), "atributo = "+ p.getAtributos(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(UnoCreacionPersonajesActivity.this, DosCreacionPersonajesActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("PERSONAJE",p);
                        intent.putExtras(bundle);
                        intent.setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
                        startActivity(intent);
                        finish();




                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                   // Toast.makeText(UnoCreacionPersonajesActivity.this, "Nombre de la clase: "+c.getNombre()+" Nombre de la raza " + r.getName(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(UnoCreacionPersonajesActivity.this, "Debes seleccionar una Clase y una Raza, no intentes explotarnos la APP que te conozco", Toast.LENGTH_SHORT).show();
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


}
