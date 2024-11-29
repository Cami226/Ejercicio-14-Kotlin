package com.bootcamp.ejercicioquincekotlin.state

data class Patient(
    val id: Int,
    val name: String= "",
    val edad: String= "",
    val sexo: Int?,
    val imc: String = "",
    val estadoSalud: String = ""
)