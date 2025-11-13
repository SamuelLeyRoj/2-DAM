package com.example.practica1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practica1.ui.theme.Practica1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica1Theme {
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = colorResource(id = R.color.white)
                ) { innerPadding ->

                    NavHost(
                        navController = navController,
                        startDestination = "inicio",
                        modifier = Modifier.padding(innerPadding)
                    ) {

                        // Pantalla principal
                        composable("inicio") {
                            Greeting(
                                name = "Android",
                                onNavigateDetalles = { navController.navigate("detalle") },
                                onNavigateAjustes = { navController.navigate("ajustes") }
                            )
                        }

                        // Pantalla de detalles
                        composable("detalle") {
                            PantallaDetalles(onBack = { navController.popBackStack() })
                        }

                        // Pantalla de ajustes
                        composable("ajustes") {
                            PantallaAjustes(onBack = { navController.popBackStack() })
                        }
                    }
                }
            }
        }
    }
}

// -------------------- PANTALLA PRINCIPAL --------------------
@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
    onNavigateDetalles: () -> Unit,
    onNavigateAjustes: () -> Unit
) {

    var numTelefono by remember { mutableStateOf("") }
    var numTelefonoSalida by remember { mutableStateOf("") }
    var suscrito by remember { mutableStateOf(false) }
    val context = LocalContext.current
    var mensaje by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "FORMULARIO ACTIVIDAD 1",
            style = MaterialTheme.typography.titleLarge,
            color = colorResource(id = R.color.text_color_custom)
        )


        //EditText (campo de texto)
        OutlinedTextField(
            value = numTelefono,
            onValueChange = { numTelefono = it },
            label = { Text("Introduce tu teléfono") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
        )

        //Switch (interruptor)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Suscribirse al boletín")
            Switch(
                checked = suscrito,
                onCheckedChange = { suscrito = it }
            )
        }

        Button(onClick = {

            numTelefonoSalida=numTelefono
            if (numTelefonoSalida.isBlank()){
                mensaje="Por favor, introduce tu número"

            }
            else if (suscrito==false){
            mensaje="Num $numTelefonoSalida \n NO estás suscrito."
        }else{
            mensaje="Num $numTelefonoSalida \n Guardado."
        }
            Toast.makeText(context,mensaje, Toast.LENGTH_LONG).show()
        }) {
            Text("Enviar")
        }


        }


        Spacer(modifier = Modifier.height(32.dp))


        // Botones para navegar a otras pantallas
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {

            Button(onClick = onNavigateDetalles) {
                Text("Ir a Detalles")
            }
            Button(onClick = onNavigateAjustes) {
                Text("Ir a Ajustes")
            }
        }
    }


// -------------------- PANTALLA DETALLES --------------------
@Composable
fun PantallaDetalles(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onBack) {
            Text("Volver")
        }
    }
}

// -------------------- PANTALLA AJUSTES --------------------
@Composable
fun PantallaAjustes(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Pantalla de ajustes")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onBack) {
            Text("Volver")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Practica1Theme {
        Greeting(
            name = "Android",
            onNavigateDetalles = {},
            onNavigateAjustes = {}
        )
    }

}
