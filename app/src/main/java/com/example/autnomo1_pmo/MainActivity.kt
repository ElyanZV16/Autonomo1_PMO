package com.example.autnomo1_pmo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.autnomo1_pmo.ui.theme.EnviroAppTheme
import androidx.compose.ui.Alignment
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EnviroAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") { HomeScreen(navController) }
                    composable("form") { FormScreen(navController) }
                    composable("gracias") { ThankYouScreen() }

                }
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "¡Bienvenido a Firma Por Una Causa!")
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { navController.navigate("form") }) {
                Text("Firma ahora")
            }
        }
    }
}

@Composable
fun FormScreen(navController: NavHostController) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val (firstName, setFirstName) = remember { mutableStateOf("") }
            val (lastName, setLastName) = remember { mutableStateOf("") }
            val (phoneNumber, setPhoneNumber) = remember { mutableStateOf("") }
            val (email, setEmail) = remember { mutableStateOf("") }

            TextField(value = firstName, onValueChange = setFirstName, label = { Text("Nombres") })
            Spacer(modifier = Modifier.height(8.dp))
            TextField(value = lastName, onValueChange = setLastName, label = { Text("Apellidos") })
            Spacer(modifier = Modifier.height(8.dp))
            TextField(value = phoneNumber, onValueChange = setPhoneNumber, label = { Text("Número de Teléfono") })
            Spacer(modifier = Modifier.height(8.dp))
            TextField(value = email, onValueChange = setEmail, label = { Text("Correo Electrónico") })
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate("gracias") }) {
                Text("Enviar")
            }
        }
    }
}

@Composable
fun ThankYouScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "¡Muchas gracias por aportar al medioambiente con tu firma!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    EnviroAppTheme {
        HomeScreen(navController = rememberNavController())
    }
}

@Preview(showBackground = true)
@Composable
fun FormScreenPreview() {
    EnviroAppTheme {
        FormScreen(navController = rememberNavController())
    }
}

@Preview(showBackground = true)
@Composable
fun ThankYouScreenPreview() {
    EnviroAppTheme {
        ThankYouScreen()
    }
}