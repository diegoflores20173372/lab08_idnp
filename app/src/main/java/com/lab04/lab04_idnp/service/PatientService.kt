package com.lab04.lab04_idnp.service

import com.lab04.lab04_idnp.model.Patient
import com.lab04.lab04_idnp.model.Visit

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

    fun delete(patient: Patient): Boolean {
        return if (patients.indexOf(patient) != -1) {
            patients[patients.indexOf(patient)] = null
            true
        } else {
            false
        }
    }
}