package com.bootcamp.ejercicioquincekotlin.viewmodel


import androidx.lifecycle.ViewModel
import com.bootcamp.ejercicioquincekotlin.state.Patient

import androidx.compose.runtime.mutableStateListOf


class PatientViewModel : ViewModel() {


    private val _pacientes = mutableStateListOf<Patient>()
    val pacientes: List<Patient> get() = _pacientes

    fun agregarPaciente(name: String) {
        val newId = _pacientes.size + 1 // Genera un ID único
        _pacientes.add(
            Patient(
                id = newId,
                name = name, edad = "",
                sexo = null, imc = "", estadoSalud = ""
            )
        )
    }

    fun actualizarPaciente(
        patientId: String?,
        edad: String,
        sexo: Int,
        imc: String,
        estadoSalud: String
    ) {
        val id = patientId!!.toInt()

            val patient = _pacientes[id - 1]
            val actualPaciente = patient.copy(
                edad = edad, imc = imc, sexo = sexo,
                estadoSalud = estadoSalud
            )
            _pacientes[id - 1] = actualPaciente
    }
    }


