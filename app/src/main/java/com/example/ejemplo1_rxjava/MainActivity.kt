package com.example.ejemplo1_rxjava

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejemplo1_rxjava.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setUpView()
    }

    private fun setUpView() {
        binding.btRX00Introduccion.setOnClickListener {
            startActivity(Intent(applicationContext,RX00PrimerEjemploActivity::class.java))
        }

        binding.btRX01Disponsable.setOnClickListener {
            startActivity(Intent(applicationContext,RX01Disponsable::class.java))
        }
    }
}