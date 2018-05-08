package com.example.manu.dungeonmasterlibrary.RETROFIT.INTERFACES;

import com.example.manu.dungeonmasterlibrary.POJOS.Razas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RacesRetrofit {
    @GET("index.php/RaceApi/races")
    Call<List<Razas>> loadChanges();
}
