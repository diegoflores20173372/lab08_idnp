package com.lab04.lab04_idnp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lab04.lab04_idnp.R
import com.lab04.lab04_idnp.model.Patient

class UserListAdapter(private val context:Context, private val listPatientData:List<Patient>):RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    private var layout:LayoutInflater = LayoutInflater.from(context)

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){

        lateinit var txtFullname:TextView
        lateinit var txtDNI:TextView
        lateinit var txtAddress:TextView

        fun bind(item:Patient, position: Int){
            txtFullname.text = item.name+item.lastName
            txtDNI.text = item.DNI
            txtAddress.text = item.address
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:View = layout.inflate(R.layout.activity_user_list, null)
        return UserListAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listPatientData[position], position)
    }

    override fun getItemCount(): Int = listPatientData.size

}