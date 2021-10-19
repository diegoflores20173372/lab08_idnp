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

        setupViewModel()
        setupRecyclerView(this)

        val floatBtnNewPatient: View = findViewById(R.id.actionBtnNewPatient)
        floatBtnNewPatient.setOnClickListener {
            val intent = Intent(this, UserFormActivity::class.java)
            startActivity(intent)
        }

        val userFormViewModel: PatientViewModel =
            ViewModelProvider(this).get(PatientViewModel::class.java)

        userFormViewModel.getListPatients().observe(this, {
            newRV.adapter = UserListAdapter(it)
            (newRV.adapter as UserListAdapter).setOnItemClickListener(object :
                UserListAdapter.onItemClickListener {
                override fun onItemClick(position: Int) {
                    val sIntent = Intent(this@UserListActivity, UserDataActivity::class.java)
                    startActivity(sIntent)
                }
            })
        })

    }

    private fun setupRecyclerView(context: Context) {
        newRV = findViewById(R.id.recViewPatientList)
        newRV.layoutManager = LinearLayoutManager(this)
        newRV.setHasFixedSize(true)
        listPatient = arrayListOf()
        getPatientList(context)
    }

    private fun getPatientList(context: Context) {
        listPatient.add(Patient("Diego", "Flores", "73641789", "CalleTarapaca", ArrayList<Visit>()))
        listPatient.add(
            Patient(
                "Diego2",
                "Flores3",
                "736417895",
                "CalleTarapaca7",
                ArrayList<Visit>()
            )
        )
        listPatient.add(
            Patient(
                "Diego2",
                "Flores4",
                "736417896",
                "CalleTarapaca8",
                ArrayList<Visit>()
            )
        )
        listPatient.add(Patient("Diego", "Flores", "73641789", "CalleTarapaca", ArrayList<Visit>()))
        listPatient.add(
            Patient(
                "Diego2",
                "Flores3",
                "736417895",
                "CalleTarapaca7",
                ArrayList<Visit>()
            )
        )
        listPatient.add(
            Patient(
                "Diego2",
                "Flores4",
                "736417896",
                "CalleTarapaca8",
                ArrayList<Visit>()
            )
        )
        listPatient.add(Patient("Diego", "Flores", "73641789", "CalleTarapaca", ArrayList<Visit>()))
        listPatient.add(
            Patient(
                "Diego2",
                "Flores3",
                "736417895",
                "CalleTarapaca7",
                ArrayList<Visit>()
            )
        )
        listPatient.add(
            Patient(
                "Diego2",
                "Flores4",
                "736417896",
                "CalleTarapaca8",
                ArrayList<Visit>()
            )
        )
        listPatient.add(Patient("Diego", "Flores", "73641789", "CalleTarapaca", ArrayList<Visit>()))
        listPatient.add(
            Patient(
                "Diego2",
                "Flores3",
                "736417895",
                "CalleTarapaca7",
                ArrayList<Visit>()
            )
        )
        listPatient.add(
            Patient(
                "Diego2",
                "Flores4",
                "736417896",
                "CalleTarapaca8",
                ArrayList<Visit>()
            )
        )
        listPatient.add(Patient("Diego", "Flores", "73641789", "CalleTarapaca", ArrayList<Visit>()))
        listPatient.add(
            Patient(
                "Diego2",
                "Flores3",
                "736417895",
                "CalleTarapaca7",
                ArrayList<Visit>()
            )
        )
        listPatient.add(
            Patient(
                "Diego2",
                "Flores4",
                "736417896",
                "CalleTarapaca8",
                ArrayList<Visit>()
            )
        )
        listPatient.add(Patient("Diego", "Flores", "73641789", "CalleTarapaca", ArrayList<Visit>()))
        listPatient.add(
            Patient(
                "Diego2",
                "Flores3",
                "736417895",
                "CalleTarapaca7",
                ArrayList<Visit>()
            )
        )
        listPatient.add(
            Patient(
                "Diego2",
                "Flores4",
                "736417896",
                "CalleTarapaca8",
                ArrayList<Visit>()
            )
        )

        val adapter = UserListAdapter(listPatient)
        newRV.adapter = adapter
        adapter.setOnItemClickListener(object : UserListAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val sIntent = Intent(context, UserDataActivity::class.java)
                startActivity(sIntent)
            }

        })
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this).get(PatientViewModel::class.java)

        val listPatientObserver = Observer<ArrayList<Patient?>> {
            Log.d("Pacientes", it.toString())
        }

        viewModel.getListPatients().observe(this, listPatientObserver)
    }
}