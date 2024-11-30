package com.bootcamp.ejercicioquincekotlin.navigation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bootcamp.ejercicioquincekotlin.dataStore.StoreBoarding
import com.bootcamp.ejercicioquincekotlin.onBoardings.MainOnBoarding

import com.bootcamp.ejercicioquincekotlin.viewmodel.PatientViewModel
import com.bootcamp.ejercicioquincekotlin.view.PatientsView
import com.bootcamp.ejercicioquincekotlin.view.HomeView


@Composable
fun Navigation() {
    val context = LocalContext.current
    val dataStore = StoreBoarding(context)
    val store = dataStore.getBoarding.collectAsState(initial = true)
    val patientViewModel: PatientViewModel = viewModel()

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = if (store.value) "patients" else "tutorial") {
        composable(route = "tutorial") { MainOnBoarding(navController, dataStore) }
        composable("patients") {
            PatientsView(navController = navController, patientviewModel = patientViewModel)
        }
        composable("home/{patientId}") { backStackEntry ->
            val patientId = backStackEntry.arguments?.getString("patientId")
            HomeView(navController, patientId = patientId,  patientviewModel = patientViewModel)
        }
    }
}
