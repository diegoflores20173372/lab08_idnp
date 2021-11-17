package com.lab04.lab08_idnp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lab04.lab08_idnp.R
import com.lab04.lab08_idnp.model.User

class UserDataActivity : AppCompatActivity() {

    private lateinit var txtFullName: TextView
    private lateinit var txtPhone: TextView
    private lateinit var txtEmail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_data)

        val user = intent.extras?.getSerializable("userSelected")
        if (user != null) {
            txtFullName = findViewById(R.id.txtFullName)
            txtFullName.text = (user as User).fullName
            txtPhone = findViewById(R.id.txtPhone)
            txtPhone.text = user.phone
            txtEmail = findViewById(R.id.txtEmail)
            txtEmail.text = user.email
        }
    }

}