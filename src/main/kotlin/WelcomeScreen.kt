import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import network.MostrarProyectos
import modelo.Proyecto
import modelo.User
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


class WelcomeScreen(val user: User) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val blanco = Color(0xFFefeff2)
        val lila = Color(0xFFa69eb0)
        val pastel = Color(0xFFf2e2cd)
        val gris = Color(0xFFdadae3)
        val negro = Color(0xFF011f4b)


        val proyectoList = remember { mutableStateOf(emptyList<Proyecto>()) }
        MostrarProyectos  {
            proyectoList.value = it
        }
        Column(modifier = Modifier.fillMaxSize().background(lila), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(modifier = Modifier.fillMaxWidth().padding(20.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                Box(
                    modifier = Modifier.width(300.dp).clip(RoundedCornerShape(7.dp)).background(blanco).padding(20.dp),
                    contentAlignment = Alignment.Center) {
                    Text(text = "Bienvenido ${user.nombre}", fontSize = 20.sp)
                }
                Card(elevation = 12.dp){
                    Column(modifier = Modifier.padding(6.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Row(modifier = Modifier, horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                            Text(user.nombre, modifier = Modifier.padding(3.dp), fontSize = TextUnit(value = 10f, type = TextUnitType.Sp))
                            Text("Gestor", modifier = Modifier.padding(3.dp), fontSize = TextUnit(value = 10f, type = TextUnitType.Sp))
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
            Column(modifier = Modifier.fillMaxWidth().padding(15.dp) )
            {
                Row(
                    modifier = Modifier.height(100.dp).fillMaxWidth().clip(RoundedCornerShape(7.dp)).background(blanco).padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Proyectos activos", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                    Button(
                        onClick = {
                            navigator?.push(ProyectosScreen(user))
                        },
                        modifier = Modifier.padding(10.dp),
                        colors = ButtonDefaults.buttonColors(gris)
                    ) {
                        Text("Ver proyectos", color = negro)
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier.width(150.dp).clip(RoundedCornerShape(7.dp)).background(blanco).padding(7.dp),
                    contentAlignment = Alignment.Center) {
                    Text(text = "Historial", fontSize = 20.sp)
                }
                Spacer(modifier = Modifier.height(10.dp))
                LazyColumn(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    items(proyectoList.value) { proyect ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(7.dp))
                                .background(blanco)
                                .clickable {
                                    navigator?.push(ProyectoScreen(proyect))
                                }
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(proyect.nombre)
                            Text(proyect.fecha_inicio)
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
        }
    }
}