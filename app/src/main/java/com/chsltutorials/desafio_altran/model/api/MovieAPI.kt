package com.chsltutorials.desafio_altran.model.api

import com.chsltutorials.desafio_altran.model.entity.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    @GET("discover/movie")
    suspend fun getAllMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("sort_by") sort_by: String
    ): MovieResponse
}
