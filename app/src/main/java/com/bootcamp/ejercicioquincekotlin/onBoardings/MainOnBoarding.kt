package com.bootcamp.ejercicioquincekotlin.onBoardings


import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.bootcamp.ejercicioquincekotlin.R
import com.bootcamp.ejercicioquincekotlin.OnBoardingPage

import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainOnBoarding(navController: NavController) {
    val items = ArrayList<PageData>()

    items.add(
        PageData(
            R.raw.hola_android, "Introducción al IMC", "Descubre qué es el Índice de" +
                    " Masa Corporal y cómo puede ayudarte a evaluar tu salud."
        )
    )
    items.add(
        PageData(
            R.raw.page_dos, "Cómo calcular tu IMC", "Aprende a " +
                    "calcular tu IMC usando tu peso y altura con una fórmula sencilla."
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
        navController = navController
    )

}