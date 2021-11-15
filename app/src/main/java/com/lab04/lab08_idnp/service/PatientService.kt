package com.lab04.lab08_idnp.service

import com.lab04.lab08_idnp.model.Patient
import com.lab04.lab08_idnp.model.Visit

// Service
object PatientService {

    // Repository
    private var patients: ArrayList<Patient?> = arrayListOf()

    fun list(): ArrayList<Patient?> {
        return patients
    }

    fun findById(id: Int): Patient? {
        return if (id >= patients.size)
            null
        else
            patients[id]
    }

    fun save(patient: Patient): Int {
        patients.add(patient)
        return patients.lastIndex
    }

    fun addVisit(id: Int, dataVisit: Visit): Patient? {
        return if (id >= patients.size)
            null
        else
            patients[id].apply {
                this?.visits?.add(dataVisit)
            }
    }
}