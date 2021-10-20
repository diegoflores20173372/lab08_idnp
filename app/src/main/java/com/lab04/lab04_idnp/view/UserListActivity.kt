package com.lab04.lab04_idnp.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lab04.lab04_idnp.R
import com.lab04.lab04_idnp.model.Patient
import com.lab04.lab04_idnp.model.Visit
import com.lab04.lab04_idnp.viewmodel.PatientViewModel

class UserListActivity : AppCompatActivity() {

    private lateinit var viewModel: PatientViewModel
    private lateinit var newRV: RecyclerView
    private lateinit var listPatient: ArrayList<Patient?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        setupRecyclerView()

        val floatBtnNewPatient: View = findViewById(R.id.actionBtnNewPatient)
        floatBtnNewPatient.setOnClickListener {
            val intent = Intent(this, UserFormActivity::class.java)
            startActivity(intent)
        }

        val userFormViewModel: PatientViewModel =
            ViewModelProvider(this).get(PatientViewModel::class.java)
        userFormViewModel.listPatients()
        userFormViewModel.getListPatients().observe(this, {
            newRV.adapter = UserListAdapter(it)
            (newRV.adapter as UserListAdapter).setOnItemClickListener(object :
                UserListAdapter.onItemClickListener {
                override fun onItemClick(position: Int) {
                    val sIntent = Intent(this@UserListActivity, UserDataActivity::class.java).apply {
                        putExtra("currentPatient", position)
                    }
                    startActivity(sIntent)
                }
            })
        })
    }

    private fun setupRecyclerView() {
        newRV = findViewById(R.id.recViewPatientList)
        newRV.layoutManager = LinearLayoutManager(this)
        newRV.setHasFixedSize(true)
        listPatient = arrayListOf()
    }
}