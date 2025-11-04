package com.example.ejerciciosevaluables

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ejerciciosevaluables.ui.theme.EjerciciosEvaluablesTheme

class Ejercicio1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EjerciciosEvaluablesTheme {
                // Le pasamos "this" (la actividad actual) a la pantalla
                PantallaEjercicio1(this)
            }
        }
    }
}

@Composable
fun PantallaEjercicio1(activity: ComponentActivity) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Esta es la pantalla del Ejercicio 1")

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Al pulsar, cerramos esta pantalla y volvemos a la anterior (MainActivity)
                activity.finish()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver al inicio")
        }
    }
}
