package com.bootcamp.ejercicioquincekotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge


import com.bootcamp.ejercicioquincekotlin.ui.theme.EjercicioQuinceKotlinTheme

import com.bootcamp.ejercicioquincekotlin.navigation.Navigation


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjercicioQuinceKotlinTheme {

                Navigation()
            }
        }
    }
}