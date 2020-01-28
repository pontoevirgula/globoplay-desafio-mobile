package com.chsltutorials.desafio_altran.model.repository

import androidx.lifecycle.LiveData
import com.chsltutorials.desafio_altran.model.api.MovieAPI
import com.chsltutorials.desafio_altran.model.db.MovieDAO
import com.chsltutorials.desafio_altran.model.entity.Favorite
import com.chsltutorials.desafio_altran.model.entity.Results

interface IMovieRepository{
    fun getListMovies(): LiveData<List<Results>>
    suspend fun getMovies()
    fun getListFavoriteMovies(): LiveData<List<Results>>
    fun addFavoriteMovies(id: Favorite)
    fun verifyFavoriteMovie(id: String): LiveData<Favorite>
    fun removeFavoriteMovies(id: String)
}


class MovieRepository(private val api: MovieAPI, private val dao: MovieDAO) : IMovieRepository{
    override fun getListMovies(): LiveData<List<Results>> {
        return dao.findAllMovies()
    }

    override fun addFavoriteMovies(id: Favorite){
        dao.addFavoriteMovie(id)
    }

    override fun removeFavoriteMovies(id: String){
        dao.removeFavoriteMovies(id)
    }

    override fun getListFavoriteMovies(): LiveData<List<Results>> {
        return dao.findAllFavoriteMovies()
    }

    override fun verifyFavoriteMovie(id: String): LiveData<Favorite> {
        return dao.verifyFavoriteMovie(id)
    }

    override suspend fun getMovies() {
        val movies = api.getMovies("803d892b8de1774a397eea8c048361b7","pt-BR","popularity.desc")
        movies.results?.let { dao.addMovies(it) }
    }

}
