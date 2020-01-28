package com.chsltutorials.desafio_altran.model.di

import android.app.Application
import androidx.room.Room
import com.chsltutorials.desafio_altran.model.db.MovieDAO
import com.chsltutorials.desafio_altran.model.db.MovieDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val localModule = module {

    fun provideDatabase(application: Application): MovieDatabase {
        return Room.databaseBuilder(application, MovieDatabase::class.java, "movie.database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    fun provideDao(database: MovieDatabase): MovieDAO {
        return database.moviesDao()
    }

    single { provideDatabase(androidApplication()) }
    single { provideDao(get()) }
}