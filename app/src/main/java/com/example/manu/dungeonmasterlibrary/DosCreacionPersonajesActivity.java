package com.example.manu.dungeonmasterlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.manu.dungeonmasterlibrary.POJOS.Personajes;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DosCreacionPersonajesActivity extends AppCompatActivity {

    MultiSelectionSpinner spinner, spinner2;
    Button btnCancelDos, btnNextDos;
    Personajes personajes;
    EditText txtNombrePersonaje;
    TextView txtTituloElegirHabilidades;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos_creacion_personajes);
        List<String> list = new ArrayList<String>();
        btnNextDos = findViewById(R.id.btnNextDos);
        btnCancelDos = findViewById(R.id.btnCancelDos);
        txtNombrePersonaje = findViewById(R.id.txtNombrePersonaje);
        txtTituloElegirHabilidades = findViewById(R.id.txtTituloElegir);



        personajes = getIntent().getExtras().getParcelable("PERSONAJE");
        Toast.makeText(this, "personaje = "+personajes.getClases().getNombre(), Toast.LENGTH_LONG).show();
        JSONObject habilidades = personajes.getClases().getHabilidadesEscoger();
        Iterator<String> iterator =habilidades.keys();
        while(iterator.hasNext()){
            list.add(iterator.next());
        }

        txtTituloElegirHabilidades.setText("Elegir " + personajes.getClases().getNumHabilidades() + " de las Siguientes Habilidades");

        spinner = findViewById(R.id.input1);
        spinner.setMax(personajes.getClases().getNumHabilidades());
        spinner2 = findViewById(R.id.input2);
        spinner2.setMax(1);
        spinner.setItems(list);

        final List<String> list2 = new ArrayList<String>();
        list2.add("LEGAL BUENO");
        list2.add("LEGAL MALIGNO");
        list2.add("NEUTRAL LEGAL");
        list2.add("NEUTRAL NEUTRAL");
        list2.add("NEUTRAL MALIGNO");
        list2.add("NEUTRAL CAÓTICO");
        list2.add("NEUTRAL BUENO");
        list2.add("CAÓTICO BUENO");
        list2.add("CAÓTICO MALIGNO");

        spinner2.setItems(list2);

        btnNextDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(DosCreacionPersonajesActivity.this, PersonajesActivity.class));
                Personajes p = personajes;
                ArrayList<String> habilidades =spinner.obtenerSeleccion();
                JSONObject hab = new JSONObject();
                try {
                    for(int i = 0; i<habilidades.size();i++){
                        hab.put(habilidades.get(i),0);
                    }
                }catch (JSONException e) {
                    e.printStackTrace();
                }

                p.setHabilidades(hab);
                p.setNombre(txtNombrePersonaje.getText().toString());
                p.setAlineamiento(spinner2.obtenerSeleccion().get(0));
                Toast.makeText(DosCreacionPersonajesActivity.this, p.getNombre().toString(), Toast.LENGTH_SHORT).show();
                Toast.makeText(DosCreacionPersonajesActivity.this, "ATTTTTTRRS " + personajes.getAtributos() , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DosCreacionPersonajesActivity.this, TresCreacionPersonajesActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("PERSONAJE",p);
                intent.putExtras(bundle);
                intent.setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
                startActivity(intent);
                finish();

            }
        });



        btnCancelDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}
