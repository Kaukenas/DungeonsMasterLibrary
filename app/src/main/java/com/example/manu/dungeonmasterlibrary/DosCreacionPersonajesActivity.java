package com.example.manu.dungeonmasterlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class DosCreacionPersonajesActivity extends AppCompatActivity {

    MultiSelectionSpinner spinner, spinner2;
    Button btnCancelDos, btnNextDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos_creacion_personajes);

        btnNextDos = findViewById(R.id.btnNextDos);
        btnCancelDos = findViewById(R.id.btnCancelDos);

        spinner = findViewById(R.id.input1);
        spinner.setMax(3);
        spinner2 = findViewById(R.id.input2);
        spinner2.setMax(1);

        List<String> list = new ArrayList<String>();
        list.add("List1");
        list.add("List2");
        list.add("List3");
        list.add("List4");
        spinner.setItems(list);

        List<String> list2 = new ArrayList<String>();
        list2.add("List1");
        list2.add("List2");
        spinner2.setItems(list);

        btnNextDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DosCreacionPersonajesActivity.this, PersonajesActivity.class));
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
