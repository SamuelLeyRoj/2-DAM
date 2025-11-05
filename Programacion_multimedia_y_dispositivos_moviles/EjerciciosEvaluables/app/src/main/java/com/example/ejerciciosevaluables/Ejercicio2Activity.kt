package com.example.ejerciciosevaluables

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ejerciciosevaluables.ui.theme.EjerciciosEvaluablesTheme


class Ejercicio2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EjerciciosEvaluablesTheme {
                PantallaEjercicio2(this)
            }
        }
    }
}


@Composable
fun PantallaEjercicio2(activity: ComponentActivity) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Esta es la pantalla del Ejercicio 2")

        Spacer(modifier = Modifier.height(30.dp))


        Button(
            onClick = {

                val intent = Intent(activity, Ejercicio2_1Activity::class.java)


                val pendingIntent = PendingIntent.getActivity(
                    activity,
                    0,
                    intent,
                    PendingIntent.FLAG_IMMUTABLE
                )


                Toast.makeText(activity, "Cargando la siguiente pag...", Toast.LENGTH_SHORT).show()


                Handler(Looper.getMainLooper()).postDelayed({
                    try {
                        pendingIntent.send()
                    } catch (e: PendingIntent.CanceledException) {
                        e.printStackTrace()
                    }
                }, 10_000)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(35.dp)
        ) {
            Text("Ir a Ejercicio 2_1 (en 10 segundos)")
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                activity.finish()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(35.dp)
        ) {
            Text("Volver al inicio")
        }
    }
}
