package com.lab04.lab08_idnp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lab04.lab08_idnp.model.Patient
import com.lab04.lab08_idnp.model.Visit
import com.lab04.lab08_idnp.service.PatientService

class PatientViewModel : ViewModel() {
    private val patientsLiveData = MutableLiveData<ArrayList<Patient?>>(arrayListOf())
    private val patientLiveData = MutableLiveData<Patient?>()
    fun listPatients() {
        patientsLiveData.value = PatientService.list()
    }

    fun getListPatients(): LiveData<ArrayList<Patient?>> {
        return patientsLiveData
    }

    fun getCurrentPatient(): LiveData<Patient?> {
        return patientLiveData
    }

    fun fetchPatient(id: Int) {
        patientLiveData.value = PatientService.findById(id)
    }

    fun addVisitToPatient(id: Int, visitData: Visit) {
        PatientService.addVisit(id, visitData)
        patientLiveData.value = PatientService.findById(id)
    }

    fun savePatient(patient: Patient) {
        patientLiveData.value = PatientService.findById(PatientService.save(patient))
    }
}