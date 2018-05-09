package com.example.manu.dungeonmasterlibrary.RETROFIT.CONTROLLERS;


import android.content.Context;
import android.os.Build;
import android.widget.Toast;

import com.example.manu.dungeonmasterlibrary.POJOS.Razas;
import com.example.manu.dungeonmasterlibrary.RETROFIT.INTERFACES.RacesRetrofit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RacesController implements Callback<List<Razas>> {

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

        RacesRetrofit racesApi = retrofit.create(RacesRetrofit.class);

        Call<List<Razas>> call = racesApi.loadChanges();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Razas>> call, Response<List<Razas>> response) {
        if(response.isSuccessful()) {
            List<Razas> changesList = response.body();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                changesList.forEach(raza -> Toast.makeText(context, "el nombre de la raza es: "+raza.getName(), Toast.LENGTH_SHORT).show());
            }
        } else {
            Toast.makeText(context, "fallo en respuesta", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<List<Razas>> call, Throwable t) {
        Toast.makeText(context, "fallo en la peticion", Toast.LENGTH_SHORT).show();
    }
}
