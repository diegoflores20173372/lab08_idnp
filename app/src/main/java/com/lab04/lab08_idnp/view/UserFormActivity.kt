package com.lab04.lab08_idnp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.lab04.lab08_idnp.R
import com.lab04.lab08_idnp.model.Patient
import androidx.lifecycle.ViewModelProvider
import com.lab04.lab08_idnp.viewmodel.PatientViewModel

class UserFormActivity : AppCompatActivity() {

    private lateinit var edtFirstName: EditText
    private lateinit var edtLastName: EditText
    private lateinit var edtDNI: EditText
    private lateinit var edtAddress: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_form)

        this.edtFirstName = findViewById(R.id.edtFirstName)
        this.edtLastName = findViewById(R.id.edtLastName)
        this.edtDNI = findViewById(R.id.edtDNI)
        this.edtAddress = findViewById(R.id.edtAddress)

        val viewModel: PatientViewModel = ViewModelProvider(this).get(PatientViewModel::class.java)
        val btnSave = findViewById<Button>(R.id.btnSave)

        btnSave.setOnClickListener {
            viewModel.savePatient(
                Patient(
                    edtFirstName.text.toString(),
                    edtLastName.text.toString(),
                    edtDNI.text.toString(),
                    edtAddress.text.toString()
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