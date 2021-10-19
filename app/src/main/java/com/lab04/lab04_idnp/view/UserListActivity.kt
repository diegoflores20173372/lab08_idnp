package com.lab04.lab04_idnp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lab04.lab04_idnp.R
import com.lab04.lab04_idnp.model.Patient
import com.lab04.lab04_idnp.viewmodel.UserListViewModel

class UserListActivity : AppCompatActivity(){

    private lateinit var viewModel:UserListViewModel

    private lateinit var layout:LayoutInflater

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        setupViewModel()
    }

    private fun setupViewModel(){
        viewModel = ViewModelProvider(this).get(UserListViewModel::class.java)

        val listPatientObserver = Observer<List<*>> {
            Log.d("Pacientes", it.toString())
        }

        viewModel.getListPatient().observe(this, listPatientObserver)
    }
}