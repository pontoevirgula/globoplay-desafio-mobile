package com.chsltutorials.desafio_altran.model.repository

import androidx.lifecycle.LiveData
import com.chsltutorials.desafio_altran.model.api.MovieAPI
import com.chsltutorials.desafio_altran.model.db.MovieDAO
import com.chsltutorials.desafio_altran.model.entity.Favorite
import com.chsltutorials.desafio_altran.model.entity.Results

class MovieRepositoryImpl(private val api: MovieAPI, private val dao: MovieDAO) : MovieRepository{

    override fun getListMovies() : LiveData<List<Results>> {
        return dao.findAllMovies()
    }
    override fun addFavoriteMovies(id: Favorite) = dao.addFavoriteMovie(id)
    override fun removeFavoriteMovies(id: String) = dao.removeFavoriteMovies(id)
    override fun getListFavoriteMovies() = dao.findAllFavoriteMovies()
    override fun verifyFavoriteMovie(id: String) = dao.verifyFavoriteMovie(id)
    override suspend fun getMovies() {
        val movies = api.getMovies("803d892b8de1774a397eea8c048361b7","pt-BR","popularity.desc")
        movies.results?.let {
            dao.addMovies(it)
        }
    }

}