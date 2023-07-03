package com.example.bank_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        Handler().postDelayed({
            startActivity(Intent(this@MainActivity4,MainActivity::class.java))
            this@MainActivity4.finish()
        }

        ,3000)
    }
}