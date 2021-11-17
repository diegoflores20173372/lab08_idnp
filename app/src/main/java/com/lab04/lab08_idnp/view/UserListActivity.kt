package com.lab04.lab08_idnp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lab04.lab08_idnp.R
import com.lab04.lab08_idnp.model.User
import com.lab04.lab08_idnp.viewmodel.UserViewModel

class UserListActivity : AppCompatActivity() {

    private lateinit var newRV: RecyclerView
    private lateinit var adapter: UserListAdapter
    private lateinit var listUser: ArrayList<User?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        setupRecyclerView()

        val userFormViewModel: UserViewModel =
            ViewModelProvider(this).get(UserViewModel::class.java)

        userFormViewModel.listUsers()

        adapter = userFormViewModel.getListUsers().value?.let { UserListAdapter(it) }!!
        newRV.adapter = adapter
        (newRV.adapter as UserListAdapter).setOnItemClickListener(object :
            UserListAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val sIntent =
                    Intent(this@UserListActivity, UserDataActivity::class.java).apply {
                        putExtra("userSelected", userFormViewModel.getListUsers().value!![position])
                    }
                startActivity(sIntent)
            }
        })

        userFormViewModel.getListUsers().observe(this, {
            adapter.updateCurrentListUserData(it as List<User>)
        })

        val floatBtnNewPatient: View = findViewById(R.id.actionBtnNewPatient)
        floatBtnNewPatient.setOnClickListener {
            val intent = Intent(this, UserFormActivity::class.java)
            startActivity(intent)
        }

        val searchView: SearchView = findViewById(R.id.search_input)
        searchView.setOnQueryTextListener(object :  SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
            override fun onQueryTextSubmit(query: String): Boolean {
                val list = userFormViewModel.getListUsers().value
                val result = list!!.filter { u -> u?.fullName!!.contains(query, true) }.toList()
                adapter.updateCurrentListUserData(result as List<User>)
                return false
            }
        })

    }

    private fun setupRecyclerView() {
        newRV = findViewById(R.id.recViewPatientList)
        newRV.layoutManager = LinearLayoutManager(this)
        newRV.setHasFixedSize(true)
        listUser = arrayListOf()
    }
}