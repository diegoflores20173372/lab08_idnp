package com.lab04.lab04_idnp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lab04.lab04_idnp.R
import com.lab04.lab04_idnp.model.Patient
import com.lab04.lab04_idnp.model.Visit
import com.lab04.lab04_idnp.viewmodel.PatientViewModel

class UserListActivity : AppCompatActivity(){

    private lateinit var viewModel:PatientViewModel
    private lateinit var newRV:RecyclerView
    private lateinit var listPatient: ArrayList<Patient>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        setupViewModel()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        newRV = findViewById(R.id.recViewList)
        newRV.layoutManager = LinearLayoutManager(this)
        newRV.setHasFixedSize(true)
        listPatient = arrayListOf<Patient>()
        getUserList()
    }

    private fun getUserList() {
        listPatient.add(Patient("Diego", "Flores", "73641789", "CalleTarapaca", ArrayList<Visit>()))
        listPatient.add(Patient("Diego2", "Flores3", "736417895", "CalleTarapaca7", ArrayList<Visit>()))
        listPatient.add(Patient("Diego2", "Flores4", "736417896", "CalleTarapaca8", ArrayList<Visit>()))
        listPatient.add(Patient("Diego", "Flores", "73641789", "CalleTarapaca", ArrayList<Visit>()))
        listPatient.add(Patient("Diego2", "Flores3", "736417895", "CalleTarapaca7", ArrayList<Visit>()))
        listPatient.add(Patient("Diego2", "Flores4", "736417896", "CalleTarapaca8", ArrayList<Visit>()))
        listPatient.add(Patient("Diego", "Flores", "73641789", "CalleTarapaca", ArrayList<Visit>()))
        listPatient.add(Patient("Diego2", "Flores3", "736417895", "CalleTarapaca7", ArrayList<Visit>()))
        listPatient.add(Patient("Diego2", "Flores4", "736417896", "CalleTarapaca8", ArrayList<Visit>()))
        listPatient.add(Patient("Diego", "Flores", "73641789", "CalleTarapaca", ArrayList<Visit>()))
        listPatient.add(Patient("Diego2", "Flores3", "736417895", "CalleTarapaca7", ArrayList<Visit>()))
        listPatient.add(Patient("Diego2", "Flores4", "736417896", "CalleTarapaca8", ArrayList<Visit>()))
        listPatient.add(Patient("Diego", "Flores", "73641789", "CalleTarapaca", ArrayList<Visit>()))
        listPatient.add(Patient("Diego2", "Flores3", "736417895", "CalleTarapaca7", ArrayList<Visit>()))
        listPatient.add(Patient("Diego2", "Flores4", "736417896", "CalleTarapaca8", ArrayList<Visit>()))
        listPatient.add(Patient("Diego", "Flores", "73641789", "CalleTarapaca", ArrayList<Visit>()))
        listPatient.add(Patient("Diego2", "Flores3", "736417895", "CalleTarapaca7", ArrayList<Visit>()))
        listPatient.add(Patient("Diego2", "Flores4", "736417896", "CalleTarapaca8", ArrayList<Visit>()))
        newRV.adapter = UserListAdapter(listPatient)
    }

    private fun setupViewModel(){
        viewModel = ViewModelProvider(this).get(PatientViewModel::class.java)

        val listPatientObserver = Observer<ArrayList<Patient?>> {
            Log.d("Pacientes", it.toString())
        }

        viewModel.getListPatients().observe(this, listPatientObserver)
    }
}