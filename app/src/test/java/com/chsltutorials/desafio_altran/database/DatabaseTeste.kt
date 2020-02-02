package com.chsltutorials.desafio_altran.database

import android.content.Context
import com.chsltutorials.desafio_altran.model.db.MovieDatabase
import com.chsltutorials.desafio_altran.model.di.dbModule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidApplication
import org.koin.core.context.startKoin
import org.koin.dsl.koinApplication
import org.koin.java.KoinJavaComponent.inject
import org.mockito.Mockito.mock
import org.koin.test.KoinTest
import org.mockito.runners.MockitoJUnitRunner
import kotlin.concurrent.thread

@RunWith(MockitoJUnitRunner::class)
class DatabaseTest : KoinTest {

//    private val dbInstace: MovieDatabase by inject()
//
//    @Test
//    fun `should get the same instance of Database when run threads simultaneously`() {
//        startKoin(
//            listOf(dbModule,applicationContext {
//
//            })
//        ) with (mock(Context::class.java))
//        repeat(10) {
//            thread(start = true) {
//                println(dbInstace)
//            }
//        }
//        Thread.sleep(500)
//    }

}