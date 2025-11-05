package com.example.ejerciciosevaluables

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejerciciosevaluables.ui.theme.EjerciciosEvaluablesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjerciciosEvaluablesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding),
                        onNavigate = { activityClass ->
                            startActivity(Intent(this, activityClass))
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier, onNavigate: (Class<*>) -> Unit) {
    Column(
        modifier = modifier
            .fillMaxSize().verticalScroll(rememberScrollState()).padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Text(
            text = "Ejercicios Evaluables",

        )

        Button(onClick = { onNavigate(Ejercicio1Activity::class.java) }, modifier = Modifier.fillMaxWidth()) {
            Text("Ejercicio 1")


        }
        Button(onClick = { onNavigate(Ejercicio2Activity::class.java) }, modifier = Modifier.fillMaxWidth()) {
            Text("Ejercicio 2")

        }
        Button(onClick = { onNavigate(Ejercicio3Activity::class.java) }, modifier = Modifier.fillMaxWidth()) {
            Text("Ejercicio 3")

        }
        Button(onClick = { onNavigate(Ejercicio4Activity::class.java) }, modifier = Modifier.fillMaxWidth()) {
            Text("Ejercicio 4")

        }
        Button(onClick = { onNavigate(Ejercicio5Activity::class.java) }, modifier = Modifier.fillMaxWidth()) {
            Text("Ejercicio 5")

        }
        Button(onClick = { onNavigate(Ejercicio6Activity::class.java) }, modifier = Modifier.fillMaxWidth()) {
            Text("Ejercicio 6")

        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    EjerciciosEvaluablesTheme {
        MainScreen(onNavigate = {}
        )
    }
}
