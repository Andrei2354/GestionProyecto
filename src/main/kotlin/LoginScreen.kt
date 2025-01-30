import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*
import cafe.adriel.voyager.core.screen.Screen
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow


class LoginScreen : Screen {
    @Composable
    override fun Content(){
        val navigator = LocalNavigator.current
        var user by remember { mutableStateOf("") }
        var passwd by remember { mutableStateOf("") }
        val Azulblanco = Color(0xFFb3cde0)
        val Azulgris = Color(0xFF6497b1)
        val Azul = Color(0xFF005b96)
        val Azulmar = Color(0xFF03396c)
        val Azuloscuro = Color(0xFF011f4b)
        Column(modifier = Modifier.background(Color.Gray).fillMaxSize().background(Azul), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Column(modifier = Modifier.background(Azulblanco), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                Text("Login", modifier = Modifier.padding(20.dp), fontSize = TextUnit(value = 40f, type = TextUnitType.Sp))
                OutlinedTextField(
                    value = user,
                    onValueChange = {user = it},
                    label = { Text("Username") },
                    modifier = Modifier,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFF418e8e),
                        focusedLabelColor = Color(0xFF5a4e3c)
                    )
                )
                OutlinedTextField(
                    value = passwd,
                    onValueChange = {passwd = it},
                    label = { Text("Password") },
                    modifier = Modifier,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFF418e8e),
                        focusedLabelColor = Color(0xFF5a4e3c)
                    )
                )
                Button(
                    onClick = {
                        navigator?.push(WelcomeScreen())
                    },
                    modifier = Modifier.padding(20.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Azul)
                ) {
                    Text("Iniciar Sesión")
                }

            }
        }
    }
}