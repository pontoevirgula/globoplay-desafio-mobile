package com.chsltutorials.desafio_altran.model.repository

import androidx.lifecycle.LiveData
import com.chsltutorials.desafio_altran.model.api.MovieAPI
import com.chsltutorials.desafio_altran.model.db.MovieDAO
import com.chsltutorials.desafio_altran.model.entity.Favorite
import com.chsltutorials.desafio_altran.model.entity.Results

interface MovieRepository{
    fun getListMovies(): List<Results>
    suspend fun getMovies()
    fun getListFavoriteMovies(): LiveData<List<Results>>
    fun addFavoriteMovies(id: Favorite)
    fun verifyFavoriteMovie(id: String): LiveData<Favorite>
    fun removeFavoriteMovies(id: String)
}



