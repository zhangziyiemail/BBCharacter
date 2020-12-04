package com.example.github.bbcharacter.network

import com.example.github.bbcharacter.model.BBCharacter
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

/**
 *   Created by Lee Zhang on 12/1/20 21:56
 **/
interface BBService {

    @GET("characters")
    suspend fun fetchCharacterList(): ApiResponse<List<BBCharacter>>
}