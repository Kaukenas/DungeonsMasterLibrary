package com.example.manu.dungeonmasterlibrary.RETROFIT.CONTROLLERS;


import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import com.example.manu.dungeonmasterlibrary.POJOS2.Razas;
import com.example.manu.dungeonmasterlibrary.RETROFIT.INTERFACES.GetRaceRetrofit;
import com.example.manu.dungeonmasterlibrary.RETROFIT.INTERFACES.GetRacesRetrofit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetRaceController implements Callback<Razas> {

    static final String baseurl = "http://thedmlibrary.ddns.net/api/";
    Context context;
    public void start(Context context) {
        this.context=context;
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GetRaceRetrofit api = retrofit.create(GetRaceRetrofit.class);

        Call<Razas> call = api.loadChanges();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Razas> call, Response<Razas> response) {
        if(response.isSuccessful()) {
            Razas changesList = response.body();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    Toast.makeText(context, "el nombre de la raza es: " + changesList.getName(), Toast.LENGTH_SHORT).show();

            }
        } else {
            Toast.makeText(context, "fallo en respuesta", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<Razas> call, Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        String sStackTrace = sw.toString();
        Toast.makeText(context, sStackTrace, Toast.LENGTH_SHORT).show();
        Log.d("error", sStackTrace);
    }
}
