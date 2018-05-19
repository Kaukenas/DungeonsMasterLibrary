package com.example.manu.dungeonmasterlibrary.RETROFIT.INTERFACES.CHARACTER;

import com.example.manu.dungeonmasterlibrary.POJOS2.Character;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetCharactersRetrofit {
    @GET("CharacterApi/characters")
    Call<List<Character>> loadChanges();
}
