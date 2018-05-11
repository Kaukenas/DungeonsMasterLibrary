package com.example.manu.dungeonmasterlibrary.RETROFIT.INTERFACES.RACES;

import com.example.manu.dungeonmasterlibrary.POJOS2.Razas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetRacesRetrofit {
    @GET("RaceApi/races")
    Call<List<Razas>> loadChanges();
}
