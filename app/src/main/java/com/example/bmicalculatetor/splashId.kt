package com.example.bmicalculatetor

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class splashId : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_id)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent =Intent(this@splashId, MainActivity::class.java)
            startActivity(intent)
        }, 2000)

    }
}