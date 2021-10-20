package com.lab04.lab04_idnp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.lab04.lab04_idnp.R
import com.lab04.lab04_idnp.model.Visit
import com.lab04.lab04_idnp.viewmodel.PatientViewModel

class VisitFormActivity : AppCompatActivity() {

    private lateinit var edtWeight: EditText
    private lateinit var edtTemperature: EditText
    private lateinit var edtPressure: EditText
    private lateinit var edtSaturationLevel: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visit_form)

        val pos = intent.getIntExtra("currentPatient", 0)

        edtWeight = findViewById(R.id.edtWeight)
        edtTemperature = findViewById(R.id.edtTemperature)
        edtPressure = findViewById(R.id.edtPressure)
        edtSaturationLevel = findViewById(R.id.edtSaturation)

        val viewModel: PatientViewModel = ViewModelProvider(this).get(PatientViewModel::class.java)
        var btnSave2 = findViewById<Button>(R.id.btnSave_2)

        btnSave2.setOnClickListener {
            viewModel.addVisitToPatient(pos,
                Visit(
                    edtWeight.text.toString().toDouble(),
                    edtTemperature.text.toString().toDouble(),
                    edtPressure.text.toString().toDouble(),
                    edtSaturationLevel.text.toString().toDouble()
                )
            )
            val intent = Intent(this, UserDataActivity::class.java).apply {
                putExtra("currentPatient", pos)
            }
            startActivity(intent)
        }

        var btnCancel2 = findViewById<Button>(R.id.btnCancel_2)
        btnCancel2.setOnClickListener {
            val intent = Intent(this, UserDataActivity::class.java).apply {
                putExtra("currentPatient", pos)
            }
            startActivity(intent)
        }
    }
}