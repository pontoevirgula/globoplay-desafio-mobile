package com.chsltutorials.desafio_altran

import android.app.Application
import com.chsltutorials.desafio_altran.model.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AltranChallengeApplication : Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@AltranChallengeApplication)
            modules(listOf(apiModule, networkModule,dbModule, viewModelModule))
        }


    }

}