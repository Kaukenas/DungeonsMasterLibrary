package com.example.manu.dungeonmasterlibrary.RETROFIT.INTERFACES.RACES;

import com.example.manu.dungeonmasterlibrary.POJOS2.Razas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

public interface GetRaceRetrofit {
    @GET("RaceApi/race/{id}")
    Call<Razas> loadChanges(@Path("id") int id);
}
