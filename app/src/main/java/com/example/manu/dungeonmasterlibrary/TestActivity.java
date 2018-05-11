package com.example.manu.dungeonmasterlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.manu.dungeonmasterlibrary.RETROFIT.CONTROLLERS.CHARACTER.GetCharacterController;
import com.example.manu.dungeonmasterlibrary.RETROFIT.CONTROLLERS.RACES.GetRaceController;
import com.example.manu.dungeonmasterlibrary.RETROFIT.CONTROLLERS.RACES.GetRacesController;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        GetCharacterController controller = new GetCharacterController();
        controller.start(this.getApplicationContext(), 1);
    }
}
