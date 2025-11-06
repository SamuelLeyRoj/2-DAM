package com.example.ejerciciosevaluables

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

class Ejercicio3Activity : Activity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio3)

        val btnPantalla1 = findViewById<Button>(R.id.btnPantalla1)
        val btnPantalla2 = findViewById<Button>(R.id.btnPantalla2)
        val btnPantalla3 = findViewById<Button>(R.id.btnPantalla3)


        // PANTALLA 1
        btnPantalla1.setOnClickListener {
            val intent = Intent(this, Ejercicio3_1Activity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Has pulsado Pantalla 1", Toast.LENGTH_SHORT).show()
        }

        // PANTALLA 2
        btnPantalla2.setOnClickListener {
            val intent = Intent(this, Ejercicio3_2Activity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Has pulsado Pantalla 2", Toast.LENGTH_SHORT).show()
        }

        // PANTALLA 3
        btnPantalla3.setOnClickListener {
            val intent = Intent(this, Ejercicio3_3Activity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Has pulsado Pantalla 3", Toast.LENGTH_SHORT).show()
        }


    }
}
