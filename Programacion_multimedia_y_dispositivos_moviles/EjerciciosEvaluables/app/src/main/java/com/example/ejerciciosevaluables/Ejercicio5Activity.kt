package com.example.ejerciciosevaluables

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ejerciciosevaluables.ui.theme.EjerciciosEvaluablesTheme

class Ejercicio5Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EjerciciosEvaluablesTheme {
                PantallaCalculadora()
            }
        }
    }
}

// Funciones matemáticas
fun sumar(a: Double, b: Double) = a + b
fun restar(a: Double, b: Double) = a - b
fun multiplicar(a: Double, b: Double) = a * b
fun dividir(a: Double, b: Double) = if (b == 0.0) 0.0 else a / b

@Composable
fun PantallaCalculadora() {

    // Estados
    var pantalla by remember { mutableStateOf("0") }
    var numeroActual by remember { mutableStateOf("") }
    var numeroAnterior by remember { mutableStateOf<Double?>(null) }
    var operacionPendiente by remember { mutableStateOf<String?>(null) }

    // Funciones para los botones
    fun alPresionarNumero(numero: String) {
        numeroActual += numero
        pantalla = numeroActual
    }

    fun alPresionarOperacion(op: String) {
        numeroAnterior = numeroActual.toDoubleOrNull()
        operacionPendiente = op
        numeroActual = ""
    }

    fun alPresionarIgual() {
        val anterior = numeroAnterior
        val actual = numeroActual.toDoubleOrNull()
        if (anterior != null && actual != null && operacionPendiente != null) {
            pantalla = when (operacionPendiente) {
                "+" -> sumar(anterior, actual).toString()
                "-" -> restar(anterior, actual).toString()
                "*" -> multiplicar(anterior, actual).toString()
                "/" -> dividir(anterior, actual).toString()
                else -> actual.toString()
            }
            numeroActual = pantalla
            numeroAnterior = null
            operacionPendiente = null
        }
    }

    fun alPresionarLimpiar() {
        numeroActual = ""
        numeroAnterior = null
        operacionPendiente = null
        pantalla = "0"
    }

    fun alPresionarDecimal() {
        if (!numeroActual.contains(".")) {
            numeroActual += "."
            pantalla = numeroActual
        }
    }

    // Composable para crear un botón con imagen
    @Composable
    fun BotonCalculadora(imagen: Int, onClick: () -> Unit) {
        Button(
            onClick = onClick,
            modifier = Modifier.width(90.dp).height(90.dp).padding(3.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.morenita)),
            shape = RoundedCornerShape(15.dp)
        ) {
            Image(painterResource(imagen), contentDescription = "", modifier = Modifier.size(40.dp))
        }
    }

    // Column principal
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Pantalla de resultados
        Text(
            text = pantalla,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            style = MaterialTheme.typography.headlineMedium,
            maxLines = 1
        )

        // --- Row 5 (superior) ---
        Row {
            BotonCalculadora(R.drawable.ic_launcher_foreground) { }
            BotonCalculadora(R.drawable.c) { alPresionarLimpiar() }
            BotonCalculadora(R.drawable.delete) { alPresionarLimpiar() }
            BotonCalculadora(R.drawable.division) { alPresionarOperacion("/") }
        }

        // --- Row 1 ---
        Row {
            BotonCalculadora(R.drawable.seven) { alPresionarNumero("7") }
            BotonCalculadora(R.drawable.eight) { alPresionarNumero("8") }
            BotonCalculadora(R.drawable.nine) { alPresionarNumero("9") }
            BotonCalculadora(R.drawable.crossed) { alPresionarOperacion("*") }
        }

        // --- Row 2 ---
        Row {
            BotonCalculadora(R.drawable.four) { alPresionarNumero("4") }
            BotonCalculadora(R.drawable.five) { alPresionarNumero("5") }
            BotonCalculadora(R.drawable.six) { alPresionarNumero("6") }
            BotonCalculadora(R.drawable.plus) { alPresionarOperacion("+") }
        }

        // --- Row 3 ---
        Row {
            BotonCalculadora(R.drawable.one) { alPresionarNumero("1") }
            BotonCalculadora(R.drawable.two) { alPresionarNumero("2") }
            BotonCalculadora(R.drawable.tree) { alPresionarNumero("3") }
            BotonCalculadora(R.drawable.subtraction) { alPresionarOperacion("-") }
        }

        // --- Row 4 ---
        Row {
            BotonCalculadora(R.drawable.zero) { alPresionarNumero("0") }
            Button(
                onClick = { alPresionarDecimal() },
                modifier = Modifier.width(90.dp).height(90.dp).padding(3.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.morenita)),
                shape = RoundedCornerShape(15.dp)
            ) { Text(",") }

            Button(
                onClick = { alPresionarIgual() },
                modifier = Modifier.width(180.dp).height(90.dp).padding(3.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.morenita)),
                shape = RoundedCornerShape(15.dp)
            ) { BotonCalculadora(R.drawable.equal) {} }
        }


    }
}
