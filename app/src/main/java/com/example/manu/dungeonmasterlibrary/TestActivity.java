package com.example.manu.dungeonmasterlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.manu.dungeonmasterlibrary.RETROFIT.CONTROLLERS.GetRacesController;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        GetRacesController controller = new GetRacesController();
        controller.start(this.getApplicationContext());
    }
}
