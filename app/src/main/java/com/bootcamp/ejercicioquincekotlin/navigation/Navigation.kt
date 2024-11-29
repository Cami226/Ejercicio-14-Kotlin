package com.bootcamp.ejercicioquincekotlin.navigation


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bootcamp.ejercicioquincekotlin.onBoardings.MainOnBoarding

import com.bootcamp.ejercicioquincekotlin.viewmodel.PatientViewModel
import com.bootcamp.ejercicioquincekotlin.view.PatientsView
import com.bootcamp.ejercicioquincekotlin.view.HomeView


@Composable
fun Navigation() {
    val patientViewModel: PatientViewModel = viewModel()

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "tutorial") {
        composable(route = "tutorial") { MainOnBoarding(navController) }
        composable("patients") {
            PatientsView(navController = navController, patientviewModel = patientViewModel)
        }
        composable("home/{patientId}") { backStackEntry ->
            val patientId = backStackEntry.arguments?.getString("patientId")
            HomeView(navController, patientId = patientId,  patientviewModel = patientViewModel)
        }
    }
}
