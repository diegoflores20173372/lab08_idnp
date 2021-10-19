package com.lab04.lab04_idnp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.lab04.lab04_idnp.R
import com.lab04.lab04_idnp.model.Patient
import androidx.lifecycle.ViewModelProvider
import com.lab04.lab04_idnp.viewmodel.PatientViewModel
import android.view.View


class UserFormActivity : AppCompatActivity() {

    private val edtFirstName = findViewById<EditText>(R.id.edtFirstName)
    private val edtLastName = findViewById<EditText>(R.id.edtLastName)
    private val edtDNI = findViewById<EditText>(R.id.edtDNI)
    private val edtAddress = findViewById<EditText>(R.id.edtAddress)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_form)

        val viewModel: PatientViewModel = ViewModelProvider(this).get(PatientViewModel::class.java)

        val btnSave = findViewById<Button>(R.id.btnSave)

        btnSave.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                viewModel.savePatient(Patient(edtFirstName.text.toString(), edtLastName.text.toString(), edtDNI.text.toString(), edtAddress.text.toString()))
            }
        })

    }
}