package com.bootcamp.ejercicioquincekotlin.onBoardings


import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.bootcamp.ejercicioquincekotlin.R
import com.bootcamp.ejercicioquincekotlin.OnBoardingPage
import com.bootcamp.ejercicioquincekotlin.dataStore.StoreBoarding

import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainOnBoarding(navController: NavController,
                   store: StoreBoarding


) {
    val items = ArrayList<PageData>()

    items.add(
        PageData(
            R.raw.hola_android, "Introducción al IMC", "Crea un registro de todos tus " +
                    "pacientes y sus datos más importantes, para mantener un orden y seguimiento de cada" +
                    "uno."
        )
    )
    items.add(
        PageData(
            R.raw.page_dos, "Facil de usar", " Un registro intuitivo y rapido"
        )
    )
    items.add(
        PageData(
            R.raw.finish, "Interpretación del IMC", "Entiende " +
                    " lo que significan los valores de IMC y cómo se relacionan con tu bienestar."
        )
    )

    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0)

    OnBoardingPage(
        item = items,
        pagerState = pagerState,
        navController = navController,
        store = store
    )

}