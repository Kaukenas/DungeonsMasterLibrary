package com.example.manu.dungeonmasterlibrary.RETROFIT.INTERFACES.CHARACTER;

import com.example.manu.dungeonmasterlibrary.POJOS2.Character;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetCharacterRetrofit {
    @GET("CharacterApi/character/{id}")
    Call<Character> loadChanges(@Path("id") int id);
}
