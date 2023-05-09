package com.example.moneywiseu

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SplashActivity : AppCompatActivity() {
    private lateinit var BtnloginIntro : Button
    private lateinit var BtnRegisterIntro : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        BtnloginIntro = findViewById(R.id.btnloginintro)
        BtnRegisterIntro = findViewById(R.id.btnregisterintro)
    }
}