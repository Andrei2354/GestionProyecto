import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

class TareaScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val blanco = Color(0xFFefeff2)
        val lila = Color(0xFFa69eb0)
        val pastel = Color(0xFFf2e2cd)
        val gris = Color(0xFFdadae3)
        val negro = Color(0xFF011f4b)
        Column(modifier = Modifier.fillMaxSize().background(lila), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(modifier = Modifier.fillMaxWidth().padding(20.dp), horizontalArrangement = Arrangement.End) {
                Card(elevation = 12.dp) {
                    Column(
                        modifier = Modifier.padding(6.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier,
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                "Andrei",
                                modifier = Modifier.padding(3.dp),
                                fontSize = TextUnit(value = 10f, type = TextUnitType.Sp)
                            )
                            Text(
                                "DAM2",
                                modifier = Modifier.padding(3.dp),
                                fontSize = TextUnit(value = 10f, type = TextUnitType.Sp)
                            )
                        }
                        Text(
                            "Desconectar",
                            fontSize = TextUnit(value = 10f, type = TextUnitType.Sp),
                            style = TextStyle(textDecoration = TextDecoration.Underline, color = Color.Blue),
                            modifier = Modifier.clickable {
                                navigator?.push(LoginScreen())
                            }

                        )
                    }
                }
            }
        }
    }
}