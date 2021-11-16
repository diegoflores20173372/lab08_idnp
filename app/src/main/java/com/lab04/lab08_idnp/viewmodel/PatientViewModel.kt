package com.lab04.lab08_idnp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lab04.lab08_idnp.model.User
import com.lab04.lab08_idnp.service.PatientService

class PatientViewModel : ViewModel() {
    private val patientsLiveData = MutableLiveData<ArrayList<User?>>(arrayListOf())
    private val patientLiveData = MutableLiveData<User?>()
    fun listPatients() {
        patientsLiveData.value = PatientService.list()
    }

    fun getListPatients(): LiveData<ArrayList<User?>> {
        return patientsLiveData
    }

    fun getCurrentPatient(): LiveData<User?> {
        return patientLiveData
    }

    fun fetchPatient(id: Int) {
        patientLiveData.value = PatientService.findById(id)
    }

    fun savePatient(user: User) {
        patientLiveData.value = PatientService.findById(PatientService.save(user))
    }
}