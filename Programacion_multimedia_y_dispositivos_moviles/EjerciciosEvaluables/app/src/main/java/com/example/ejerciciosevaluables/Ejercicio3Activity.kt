package com.example.ejerciciosevaluables

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

class Ejercicio3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio3)

        val btnPantalla1 = findViewById<Button>(R.id.btnPantalla1)
        val btnPantalla2 = findViewById<Button>(R.id.btnPantalla2)
        val btnPantalla3 = findViewById<Button>(R.id.btnPantalla3)

        btnPantalla1.setOnClickListener {
            Toast.makeText(this, "Has pulsado Pantalla 1", Toast.LENGTH_SHORT).show()
        }

        btnPantalla2.setOnClickListener {
            Toast.makeText(this, "Has pulsado Pantalla 2", Toast.LENGTH_SHORT).show()
        }

        btnPantalla3.setOnClickListener {
            Toast.makeText(this, "Has pulsado Pantalla 3", Toast.LENGTH_SHORT).show()
        }
    }
}
