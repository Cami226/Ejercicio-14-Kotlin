package com.bootcamp.ejercicioquincekotlin.onBoardings


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bootcamp.ejercicioquincekotlin.dataStore.StoreBoarding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch


@Composable
fun ButtonFinnish(currentPage: Int, navController: NavController,
                  store: StoreBoarding) {
    Row(
        modifier = Modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = if (currentPage != 2) Arrangement.SpaceBetween else Arrangement.Center
    ) {
        if (currentPage == 2) {
            OutlinedButton(
                onClick = {
                    //navController.navigate("patients")
                    CoroutineScope(Dispatchers.IO).launch {
                        store.saveBoarding(true)
                    }
                }

                    //colors = ButtonDefaults.outlinedButtonColors(
                      //  containerColor = Color.Blue, // Color de fondo
                        //contentColor = Color.White   // Color del texto y del borde
                    //)

            ) {
                Text(
                    text = "Entrar",
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 40.dp)
                )
            }
        }
    }
}