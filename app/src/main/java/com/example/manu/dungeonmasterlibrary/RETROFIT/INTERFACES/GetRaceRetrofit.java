package com.example.manu.dungeonmasterlibrary.RETROFIT.INTERFACES;

import com.example.manu.dungeonmasterlibrary.POJOS2.Razas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetRaceRetrofit {
    @GET("index.php/RaceApi/race/{id}")
    Call<Razas> loadChanges();
}
