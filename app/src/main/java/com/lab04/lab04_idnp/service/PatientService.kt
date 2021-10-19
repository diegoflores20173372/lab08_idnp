package com.lab04.lab04_idnp.service

import com.lab04.lab04_idnp.model.Patient

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

    fun update(id: Int, patient: Patient): Patient? {
        return if (id >= patients.size)
            null
        else
            patients[id].apply {
                this?.name = patient.name
                this?.lastName = patient.lastName
                this?.address = patient.address
                this?.DNI = patient.DNI
                this?.visits = patient.visits
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