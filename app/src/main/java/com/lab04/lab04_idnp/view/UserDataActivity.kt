package com.lab04.lab04_idnp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lab04.lab04_idnp.R
import com.lab04.lab04_idnp.model.Visit

class UserDataActivity : AppCompatActivity() {

    private lateinit var recViewVisitList:RecyclerView
    private lateinit var visitList:ArrayList<Visit>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_data)

        setupRecyclerView()

        val floatBtnNewVisit: View = findViewById(R.id.actionBtnNewVisit)
        floatBtnNewVisit.setOnClickListener {
            val intent = Intent(this, VisitFormActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupRecyclerView() {
        recViewVisitList = findViewById(R.id.recViewVisitList)
        recViewVisitList.layoutManager = LinearLayoutManager(this)
        recViewVisitList.setHasFixedSize(true)
        visitList = arrayListOf<Visit>()
        getVisitList()
    }

    private fun getVisitList() {
        visitList.add(Visit(70.0, 36.0, 115.0, 92.0))
        visitList.add(Visit(70.0, 36.0, 115.0, 92.0))
        visitList.add(Visit(70.0, 36.0, 115.0, 92.0))
        visitList.add(Visit(70.0, 36.0, 115.0, 92.0))
        visitList.add(Visit(70.0, 36.0, 115.0, 92.0))
        visitList.add(Visit(70.0, 36.0, 115.0, 92.0))
        visitList.add(Visit(70.0, 36.0, 115.0, 92.0))
        visitList.add(Visit(70.0, 36.0, 115.0, 92.0))
        visitList.add(Visit(70.0, 36.0, 115.0, 92.0))
        visitList.add(Visit(70.0, 36.0, 115.0, 92.0))
        recViewVisitList.adapter = VisitListAdapter(visitList)

    }
}