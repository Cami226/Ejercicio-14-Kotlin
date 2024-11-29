package com.bootcamp.ejercicioquincekotlin.view



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.material3.IconButton
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.compose.material3.TopAppBar
import com.bootcamp.ejercicioquincekotlin.viewmodel.PatientViewModel
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PatientsView(
    navController: NavController,
    patientviewModel: PatientViewModel = viewModel(),

    ) {
    var showDialog by remember { mutableStateOf(false) }
    var patientName by remember { mutableStateOf("") }


Box(modifier = Modifier.fillMaxSize()) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Blue, titleContentColor = Color.White
            ),
            title = { Text("Lista de Pacientes") },
        )


        LazyColumn {
            items(patientviewModel.pacientes) { patient ->
                PatientCard(patient, navController = navController)            }
        }

        if (showDialog) {
            AlertDialog(onDismissRequest = { showDialog = false },
                title = { Text("Agregar Paciente") },
                text = {
                    TextField(value = patientName,
                        onValueChange = { patientName = it },
                        label = { Text("Nombre del Paciente") })
                },
                confirmButton = {
                    TextButton(onClick = {
                        if (patientName.isNotBlank()) {
                            patientviewModel.agregarPaciente(patientName)
                            patientName = ""
                            showDialog = false
                        }
                    }) {
                        Text("Agregar")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Cancelar")
                    }
                })
        }
    }

    FloatingActionButton(
        onClick = { showDialog = true },
        modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(16.dp)
    ) {
        Icon(Icons.Filled.Add, contentDescription = "Agregar Paciente")
    }
}
}