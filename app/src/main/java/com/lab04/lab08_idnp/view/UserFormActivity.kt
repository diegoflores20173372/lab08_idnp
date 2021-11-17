package com.lab04.lab08_idnp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.lab04.lab08_idnp.R
import com.lab04.lab08_idnp.model.User
import androidx.lifecycle.ViewModelProvider
import com.lab04.lab08_idnp.viewmodel.UserViewModel

class UserFormActivity : AppCompatActivity() {

    private lateinit var edtFullName: EditText
    private lateinit var edtPhone: EditText
    private lateinit var edtEmail: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_form)

        this.edtFullName = findViewById(R.id.edtFullName)
        this.edtPhone = findViewById(R.id.edtPhone)
        this.edtEmail = findViewById(R.id.edtEmail)

        val viewModel: UserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        val btnSave = findViewById<Button>(R.id.btnSave)

        btnSave.setOnClickListener {
            viewModel.saveUser(
                User(
                    edtFullName.text.toString(),
                    edtPhone.text.toString(),
                    edtEmail.text.toString(),
                    false,
                    ""
                )
            )
            val intent = Intent(this, UserListActivity::class.java)
            startActivity(intent)
        }

        var btnCancel = findViewById<Button>(R.id.btnCancel)
        btnCancel.setOnClickListener {
            val intent = Intent(this, UserListActivity::class.java)
            startActivity(intent)
        }

    }
}