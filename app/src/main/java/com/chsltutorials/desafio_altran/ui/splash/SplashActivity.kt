package com.chsltutorials.desafio_altran.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.chsltutorials.desafio_altran.R
import com.chsltutorials.desafio_altran.ui.main.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({ initApp() }, 2000)
    }

    private fun initApp() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
