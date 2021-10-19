package com.lab04.lab04_idnp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lab04.lab04_idnp.model.Patient
import com.lab04.lab04_idnp.service.PatientService

class PatientViewModel : ViewModel() {
    private val patientsLiveData = MutableLiveData<ArrayList<Patient?>>(arrayListOf())
    private val patientLiveData = MutableLiveData<Patient?>()
    fun listPatients() {
        patientsLiveData.value = PatientService.list()
    }

    fun getListPatients(): LiveData<ArrayList<Patient?>> {
        return patientsLiveData
    }

    fun fetchPatient(id: Int) {
        patientLiveData.value = PatientService.findById(id)
    }

    fun updatePatient(id: Int, patient: Patient) {
        PatientService.update(id, patient)
        patientLiveData.value = PatientService.findById(id)
    }

    fun savePatient(patient: Patient) {
        patientLiveData.value = PatientService.findById(PatientService.save(patient))
    }

    fun delete(patient: Patient) {
        if (PatientService.delete(patient))
            patientLiveData.value = null
    }
}