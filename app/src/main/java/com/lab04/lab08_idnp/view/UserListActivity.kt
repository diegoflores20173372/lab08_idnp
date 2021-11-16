package com.lab04.lab08_idnp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lab04.lab08_idnp.R
import com.lab04.lab08_idnp.model.User
import com.lab04.lab08_idnp.viewmodel.PatientViewModel

class UserListActivity : AppCompatActivity() {

    private lateinit var newRV: RecyclerView
    private lateinit var listUser: ArrayList<User?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        setupRecyclerView()

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

        val floatBtnNewPatient: View = findViewById(R.id.actionBtnNewPatient)
        floatBtnNewPatient.setOnClickListener {
            val intent = Intent(this, UserFormActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupRecyclerView() {
        newRV = findViewById(R.id.recViewPatientList)
        newRV.layoutManager = LinearLayoutManager(this)
        newRV.setHasFixedSize(true)
        listUser = arrayListOf()
    }
}