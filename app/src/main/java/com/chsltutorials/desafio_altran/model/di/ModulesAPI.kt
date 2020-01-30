package com.chsltutorials.desafio_altran.model.di

import com.chsltutorials.desafio_altran.BuildConfig
import com.chsltutorials.desafio_altran.model.api.MovieAPI
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val apiModule = module{
    fun provideMovieApi(retrofit: Retrofit) : MovieAPI{
        return retrofit.create(MovieAPI::class.java)
    }

    single { provideMovieApi(get()) }
}

val networkModule = module {

    fun providerRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder().apply {
        baseUrl(BuildConfig.API)
        client(client)
        addConverterFactory(MoshiConverterFactory.create())
    }.build()


    fun providerOkHttpClient(): OkHttpClient = OkHttpClient.Builder().apply {
        connectTimeout(60L, TimeUnit.SECONDS)
        readTimeout(60L, TimeUnit.SECONDS)
    }.build()

    single { providerOkHttpClient() }
    single { providerRetrofit(get()) }
}

