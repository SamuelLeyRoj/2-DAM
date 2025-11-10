package com.example.ejerciciosevaluables

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ejerciciosevaluables.ui.theme.EjerciciosEvaluablesTheme
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class Ejercicio6Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EjerciciosEvaluablesTheme {
                PantallaEjercicio6(this)
            }
        }
    }
}

@Composable
fun PantallaEjercicio6(activity: ComponentActivity) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        //FOTO DE PERFIL DEL SURICATO
        Button(
            onClick = { /* Acción */ },
            modifier = Modifier
                .width(250.dp)
                .height(230.dp)
                .padding(3.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            shape = RoundedCornerShape(70.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.suricato),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape),
                contentScale = ContentScale.FillBounds
            )
        }


        //NOMBRE

        Text(
            text = "Samuel Leyton Rojas",
            style = androidx.compose.ui.text.TextStyle(
                fontFamily = FontFamily.Cursive,
                fontSize = 33.sp,
                fontWeight = FontWeight.Black
            ),
            modifier = Modifier.padding(top = 30.dp)
        )


        //DESCRIPCION

        Text(
            text = "Soy una persona proactiva, responsable y con una gran capacidad para adaptarme a diferentes entornos. Me destaco por aprender rápidamente, trabajar en equipo y resolver problemas. ",
            style = androidx.compose.ui.text.TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier.padding(50.dp)
        )


        //BOTONVOLVER


        Button(
            onClick={
                activity.finish()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver")
        }

    }
}
