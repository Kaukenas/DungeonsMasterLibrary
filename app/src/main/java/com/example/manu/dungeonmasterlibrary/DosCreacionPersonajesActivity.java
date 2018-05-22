package com.example.manu.dungeonmasterlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.manu.dungeonmasterlibrary.POJOS2.Class;
import com.example.manu.dungeonmasterlibrary.POJOS2.Character;
import com.example.manu.dungeonmasterlibrary.POJOS2.Skill;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DosCreacionPersonajesActivity extends AppCompatActivity {

    MultiSelectionSpinner spinner, spinner2;
    Button btnCancelDos, btnNextDos;
    Character personajes;
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
        Toast.makeText(this, "personaje = "+personajes, Toast.LENGTH_LONG).show();
        List<Skill> habilidades = personajes.getaClass().getSkills();
        for (int i = 0; i <habilidades.size() ; i++) {
            list.add(habilidades.get(i).getHabilidad());
        }

        txtTituloElegirHabilidades.setText("Elegir " + personajes.getaClass().getNumOfSkills() + " de las Siguientes Habilidades");

        spinner = findViewById(R.id.input1);
        spinner.setMax(Integer.parseInt(personajes.getaClass().getNumOfSkills()));
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
                if (!spinner2.getSelectedItemsAsString().equals("") && !spinner.getSelectedItemsAsString().equals("") && !txtNombrePersonaje.getText().toString().equals("")) {
                    Character p = personajes;
                    ArrayList<String> habilidades = spinner.obtenerSeleccion();
                    ArrayList<Skill> hab = new ArrayList<>();
                    for (int i = 0; i < habilidades.size(); i++) {
                        hab.add(new Skill(habilidades.get(i)));
                    }


                    p.setSkills(hab);
                    p.setName(txtNombrePersonaje.getText().toString());
                    p.setAlineamiento(spinner2.obtenerSeleccion().get(0));
                    //Toast.makeText(DosCreacionPersonajesActivity.this, p.getName().toString(), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(DosCreacionPersonajesActivity.this, "ATTTTTTRRS " + personajes.getAbilities(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DosCreacionPersonajesActivity.this, TresCreacionPersonajesActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("PERSONAJE", p);
                    intent.putExtras(bundle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
                    startActivity(intent);
                    finish();
                } else {
                        Toast.makeText(DosCreacionPersonajesActivity.this, "Debes seleccionar las Habilidades, el Alineamiento", Toast.LENGTH_SHORT).show();
                    }
            }
        });



        btnCancelDos.setOnClickListener(view -> onBackPressed());
        
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



}
