package com.example.manu.dungeonmasterlibrary;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MostrarTresPersonajesActivity extends AppCompatActivity {

    static Activity c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_tres_personajes);

        c.finish();
    }

    public static void setActivity(Activity activity){
        MostrarTresPersonajesActivity.c=activity;
    }
}
