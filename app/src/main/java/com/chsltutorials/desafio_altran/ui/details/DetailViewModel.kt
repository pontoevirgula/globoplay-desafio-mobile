package com.chsltutorials.desafio_altran.ui.details

import androidx.lifecycle.ViewModel
import com.chsltutorials.desafio_altran.model.entity.Favorite
import com.chsltutorials.desafio_altran.model.repository.MovieRepositoryImpl

class DetailViewModel(val repositoryImpl: MovieRepositoryImpl) : ViewModel() {

    fun removeFavorite(id: String) = repositoryImpl.removeFavoriteMovies(id)
    fun addFavorite(favorite: Favorite) = repositoryImpl.addFavoriteMovies(favorite)
    fun checkFavorite(id: String) = repositoryImpl.verifyFavoriteMovie(id)



}
