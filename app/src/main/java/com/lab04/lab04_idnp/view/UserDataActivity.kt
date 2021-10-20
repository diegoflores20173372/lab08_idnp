package com.lab04.lab04_idnp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lab04.lab04_idnp.R
import com.lab04.lab04_idnp.model.Visit
import com.lab04.lab04_idnp.viewmodel.PatientViewModel

class UserDataActivity : AppCompatActivity() {

    private lateinit var recViewVisitList:RecyclerView
    private lateinit var visitList:ArrayList<Visit>
    private lateinit var txtFullName:TextView
    private lateinit var txtDNI:TextView
    private lateinit var txtAddress:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_data)

        txtFullName = findViewById(R.id.txtFullName)
        txtDNI = findViewById(R.id.txtDNI)
        txtAddress = findViewById(R.id.txtAddress)

        val viewModel: PatientViewModel = ViewModelProvider(this).get(PatientViewModel::class.java)
        var pos = intent.getIntExtra("currentPatient", 0)
        viewModel.fetchPatient(pos)
        viewModel.getCurrentPatient().observe(this, {
            txtFullName.text = it?.name + " " + it?.lastName
            txtDNI.text = it?.DNI
            txtAddress.text = it?.address
            it?.visits?.let { it1 -> setupRecyclerView(it1) }
            recViewVisitList.adapter = VisitListAdapter(it?.visits)
        })

        val floatBtnNewVisit: View = findViewById(R.id.actionBtnNewVisit)
        floatBtnNewVisit.setOnClickListener {
            val intent = Intent(this, VisitFormActivity::class.java).apply {
                putExtra("currentPatient", pos)
            }
            startActivity(intent)
        }
    }

    private fun setupRecyclerView(visits: ArrayList<Visit>) {
        recViewVisitList = findViewById(R.id.recViewVisitList)
        recViewVisitList.layoutManager = LinearLayoutManager(this)
        recViewVisitList.setHasFixedSize(true)
        visitList = arrayListOf<Visit>()
    }
}