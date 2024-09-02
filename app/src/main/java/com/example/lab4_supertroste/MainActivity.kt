package com.example.lab4_supertroste

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab4_supertroste.ui.theme.Lab4_SupertrosteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab4_SupertrosteTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainContent(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    val checkedState = remember { mutableStateOf(false) }
    val selectedOption = remember { mutableStateOf("Option 1") }

    Column(modifier = modifier.fillMaxSize()) {
        Text(
            text = "Lista de Tareas",
            modifier = Modifier.padding(16.dp)
        )
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(List(10) { "Tarea $it" }) { item ->
                Text(
                    text = item,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }

        Text(
            text = "Categorías",
            modifier = Modifier.padding(16.dp)
        )
        LazyRow(modifier = Modifier.weight(1f)) {
            items(List(10) { "Categoría $it" }) { item ->
                Text(
                    text = item,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }

        Text(
            text = "Recordatorio",
            modifier = Modifier.padding(16.dp)
        )
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it },
            modifier = Modifier.padding(8.dp)
        )

        Text(
            text = "Prioridad",
            modifier = Modifier.padding(16.dp)
        )
        Row(modifier = Modifier.padding(8.dp)) {
            listOf("Baja", "Media", "Alta").forEach { text ->
                RadioButton(
                    selected = selectedOption.value == text,
                    onClick = { selectedOption.value = text }
                )
                Text(
                    text = text,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainContentPreview() {
    Lab4_SupertrosteTheme {
        MainContent()
    }
}