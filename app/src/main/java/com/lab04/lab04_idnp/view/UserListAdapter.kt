package com.lab04.lab04_idnp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lab04.lab04_idnp.R
import com.lab04.lab04_idnp.model.Patient

class UserListAdapter(private val listPatientData: ArrayList<Patient?>) :
    RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.patient_row, parent, false)
        return ViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        listPatientData[position]?.let { holder.bind(it, position) }
    }

    override fun getItemCount(): Int = listPatientData.size

    class ViewHolder(view: View, listener: onItemClickListener) : RecyclerView.ViewHolder(view) {

        private val txtFullName: TextView = itemView.findViewById(R.id.txtFullName)
        private val txtDNI: TextView = itemView.findViewById(R.id.txtDNI)
        private val txtAddress: TextView = itemView.findViewById(R.id.txtAddress)

        init {
            view.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

        fun bind(item: Patient, position: Int) {
            txtFullName.text = item.name + " " + item.lastName
            txtDNI.text = item.DNI
            txtAddress.text = item.address
        }
    }
}