package com.chsltutorials.desafio_altran.ui.favorite

import androidx.lifecycle.ViewModel
import com.chsltutorials.desafio_altran.model.repository.MovieRepositoryImpl

class FavoriteViewModel(repositoryImpl: MovieRepositoryImpl) : ViewModel() {

    val listFavoriteMovies = repositoryImpl.getListFavoriteMovies()
}