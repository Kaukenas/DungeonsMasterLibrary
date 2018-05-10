package com.example.manu.dungeonmasterlibrary.RETROFIT.CONTROLLERS;


import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import com.example.manu.dungeonmasterlibrary.POJOS2.Razas;
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

public class GetRacesController implements Callback<List<Razas>> {

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

        GetRacesRetrofit racesApi = retrofit.create(GetRacesRetrofit.class);

        Call<List<Razas>> call = racesApi.loadChanges();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Razas>> call, Response<List<Razas>> response) {
        if(response.isSuccessful()) {
            List<Razas> changesList = response.body();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

                for (Razas raza : changesList) {
                    for(int i =0;i<raza.getTraits().size();i++)
                    Toast.makeText(context, "el nombre de la raza es: " + raza.getTraits().get(i).getTrait(), Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            Toast.makeText(context, "fallo en respuesta", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<List<Razas>> call, Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        String sStackTrace = sw.toString();
        Toast.makeText(context, sStackTrace, Toast.LENGTH_SHORT).show();
        Log.d("error", sStackTrace);
    }
}
