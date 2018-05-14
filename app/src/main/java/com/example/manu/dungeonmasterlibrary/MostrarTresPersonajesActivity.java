package com.example.manu.dungeonmasterlibrary;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.manu.dungeonmasterlibrary.POJOS.Objetos;

import java.util.ArrayList;
import java.util.List;

public class MostrarTresPersonajesActivity extends AppCompatActivity {

    static Activity c;
    Objetos objetos;
    MultiSelectionSpinner spinnerBag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_tres_personajes);

        spinnerBag = findViewById(R.id.spinnerBag);

        c.finish();
        objetos = getIntent().getExtras().getParcelable("ARMAS");
        List<String> list = new ArrayList<String>();
        list.add(String.valueOf(objetos));
        spinnerBag.setItems(list);





    }

    public static void setActivity(Activity activity){
        MostrarTresPersonajesActivity.c=activity;
    }
}
