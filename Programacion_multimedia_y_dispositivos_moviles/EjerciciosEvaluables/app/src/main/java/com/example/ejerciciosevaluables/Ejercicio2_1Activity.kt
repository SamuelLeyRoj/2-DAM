package com.example.ejerciciosevaluables

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ejerciciosevaluables.ui.theme.EjerciciosEvaluablesTheme


class Ejercicio2_1Activity : ComponentActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                EjerciciosEvaluablesTheme {
                    PantallaEjercicio2_1(this)
                }
            }
        }
}


@Composable
fun PantallaEjercicio2_1(activity: ComponentActivity) {
    Column(
        modifier = Modifier
            .fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text("Esta es la pantalla del Ejercicio 2")



        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {

                val intent = Intent(activity, MainActivity::class.java)
                activity.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(35.dp)
        ) {
            Text("Volver al inicio")
        }
    }
}
