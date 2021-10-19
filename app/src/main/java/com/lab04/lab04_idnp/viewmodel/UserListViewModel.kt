package com.lab04.lab04_idnp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lab04.lab04_idnp.model.Patient

class UserListViewModel: ViewModel() {

    private val listPatient = MutableLiveData<List<Patient>>()

    fun setListPatient(listPatientData:List<Patient>){
        listPatient.value = listPatientData
    }

    fun getListPatient():LiveData<List<Patient>>{
        return listPatient
    }

}