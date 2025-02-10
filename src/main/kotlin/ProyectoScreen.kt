import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import modelo.Tarea
import network.MostrarMistareas
import modelo.Proyecto


class ProyectoScreen(val proyect: Proyecto): Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val blanco = Color(0xFFefeff2)
        val pastel = Color(0xFFf2e2cd)
        val gris = Color(0xFFdadae3)
        val negro = Color(0xFF011f4b)
        val lila = Color(0xFFa69eb0)

        val misTareas = remember { mutableStateOf(emptyList<Tarea>()) }
        MostrarMistareas(proyect.id) {
            misTareas.value = it
        }


        Column(modifier = Modifier.fillMaxSize().background(lila), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(modifier = Modifier.fillMaxWidth().padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                Box(
                    modifier = Modifier.width(300.dp).height(50.dp).clip(RoundedCornerShape(7.dp)).background(blanco).padding(7.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(proyect.nombre)
                }
                Card(elevation = 12.dp) {
                    Column(
                        modifier = Modifier.padding(6.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier.padding(6.dp),
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
            Column(modifier = Modifier.padding(10.dp).fillMaxWidth()) {
                Card(elevation = 12.dp) {
                    Column(modifier = Modifier.width(400.dp).padding(12.dp)) {
                        Text("ID: ${proyect.id}")
                        Text("Descripción: ${proyect.descripcion}")
                        Text("Fecha_creacion: ${proyect.fecha_creacion}")
                        Text("Fecha_inicio: ${proyect.fecha_inicio}")
                        Text("Fecha_finalizacion: ${proyect.fecha_finalizacion}")
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier.width(300.dp).clip(RoundedCornerShape(7.dp)).background(blanco).padding(7.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Tareas ")
                }
                Spacer(modifier = Modifier.height(10.dp))
                LazyColumn(
                    modifier = Modifier.height(300.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    items(misTareas.value) { tarea ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(7.dp))
                                .background(blanco)
                                .clickable {
                                    navigator?.push(TareaScreen(tarea))
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