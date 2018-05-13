package com.example.manu.dungeonmasterlibrary.RETROFIT.INTERFACES.CLASSES;

import com.example.manu.dungeonmasterlibrary.POJOS2.Class;
import com.example.manu.dungeonmasterlibrary.POJOS2.Razas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetClassesRetrofit {
    @GET("ClassesApi/classes")
    Call<List<Class>> loadChanges();
}
