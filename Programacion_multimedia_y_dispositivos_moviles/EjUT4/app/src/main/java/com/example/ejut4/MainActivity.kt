package com.example.ejut4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejut4.ui.theme.EjUT4Theme
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjUT4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {


    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }

    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        selectedImageUri = uri
    }



    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Sube una foto",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(15.dp))

        Button(onClick = {
            galleryLauncher.launch("image/*")
            println("Hola")
        }
        ) {
            Text("Púlsame",
                fontSize = 28.sp)

        }

        Spacer(modifier = Modifier.height(15.dp))

        selectedImageUri?.let { uri ->
            Text("URI: $uri")
            Spacer(modifier = Modifier.height(16.dp))
            AsyncImage(
                model = uri,
                contentDescription = null,
                modifier = Modifier.size(250.dp),
                contentScale = ContentScale.Crop
            )

        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EjUT4Theme {
        Greeting("Android")
    }
}
