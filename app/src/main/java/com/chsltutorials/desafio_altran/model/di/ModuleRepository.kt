package com.chsltutorials.desafio_altran.model.di

import com.chsltutorials.desafio_altran.model.api.MovieAPI
import com.chsltutorials.desafio_altran.model.db.MovieDAO
import com.chsltutorials.desafio_altran.model.repository.IMovieRepository
import com.chsltutorials.desafio_altran.model.repository.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    fun provideMovieRepository(api: MovieAPI, dao: MovieDAO): IMovieRepository {
        return MovieRepository(api, dao)
    }

    single { provideMovieRepository(get(), get()) }
}