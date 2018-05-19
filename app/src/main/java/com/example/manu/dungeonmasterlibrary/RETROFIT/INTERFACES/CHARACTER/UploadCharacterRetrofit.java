package com.example.manu.dungeonmasterlibrary.RETROFIT.INTERFACES.CHARACTER;

import com.example.manu.dungeonmasterlibrary.POJOS2.Character;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UploadCharacterRetrofit {
    @POST("affiliates/login")
    Call<Character> loadChanges(@Body Character c);
}
