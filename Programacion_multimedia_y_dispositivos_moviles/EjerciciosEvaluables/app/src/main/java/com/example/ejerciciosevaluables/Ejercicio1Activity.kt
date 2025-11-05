package com.example.ejerciciosevaluables

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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

    var texto by remember { mutableStateOf("") }
    val toast1 = LocalContext.current
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(texto))

    Column(
        modifier = Modifier
            .fillMaxSize().verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,

    ) {
        Text("Inserte algo:")

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = texto,
            onValueChange = { texto = it },
            label = { Text("Campo de texto") },
            modifier = Modifier
                .fillMaxWidth()

        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                if (texto.isEmpty()){

                    Toast.makeText(toast1, "El campo de texto está vacio.", Toast.LENGTH_SHORT).show()

                }else if (!texto.startsWith("https://")) {

                    Toast.makeText(toast1, "URL no válida.", Toast.LENGTH_SHORT).show()

                }else{
                    try {
                        toast1.startActivity(intent)
                    } catch (e: Exception) {
                        Toast.makeText(toast1, "No se pudo abrir la URL.", Toast.LENGTH_SHORT).show()
                    }
                    }
                },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Confirmar")
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
