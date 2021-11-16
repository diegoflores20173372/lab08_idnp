package com.lab04.lab08_idnp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lab04.lab08_idnp.R

class UserDataActivity : AppCompatActivity() {

    private lateinit var recViewVisitList:RecyclerView
    private lateinit var txtFullName:TextView
    private lateinit var txtDNI:TextView
    private lateinit var txtAddress:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_data)


    }

}