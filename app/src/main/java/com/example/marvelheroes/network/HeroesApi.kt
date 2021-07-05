package com.example.marvelheroes.network

import com.example.marvelheroes.model.HeroesResponse
import com.example.marvelheroes.util.Constants.Companion.PUBLIC_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HeroesApi {

    @GET("/v1/public/characters?")
    suspend fun getHeroes(
        @Query("ts")
        ts: Long,
        @Query("hash")
        hash: String,
        @Query("limit")
        limit: Int = 100,
        @Query("apikey")
        apiKey: String = PUBLIC_KEY
    ): Response<HeroesResponse>
}