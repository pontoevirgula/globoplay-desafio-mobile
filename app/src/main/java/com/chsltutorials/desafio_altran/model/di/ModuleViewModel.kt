package com.chsltutorials.desafio_altran.model.di

import com.chsltutorials.desafio_altran.model.api.MovieAPI
import com.chsltutorials.desafio_altran.model.db.MovieDAO
import com.chsltutorials.desafio_altran.model.repository.MovieRepository
import com.chsltutorials.desafio_altran.model.repository.MovieRepositoryImpl
import com.chsltutorials.desafio_altran.ui.details.DetailViewModel
import com.chsltutorials.desafio_altran.ui.favorite.FavoriteViewModel
import com.chsltutorials.desafio_altran.ui.home.HomeViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel


val viewModelModule = module {
    viewModel { HomeViewModel(provideMovieRepository(get(), get())) }
    viewModel { FavoriteViewModel(provideMovieRepository(get(), get())) }
    viewModel { DetailViewModel(provideMovieRepository(get(), get())) }
}
    fun provideMovieRepository(api: MovieAPI, dao: MovieDAO): MovieRepositoryImpl {
        return MovieRepositoryImpl(api, dao)
    }

    //single { provideMovieRepository(get(), get()) }
//}