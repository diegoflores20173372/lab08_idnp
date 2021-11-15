package com.lab04.lab08_idnp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lab04.lab08_idnp.R
import com.lab04.lab08_idnp.model.Visit

class VisitListAdapter(private val listVisitData:ArrayList<Visit>?): RecyclerView.Adapter<VisitListAdapter.ViewHolder>() {

    private var currentListVisitData: ArrayList<Visit> = listVisitData?.filterNotNull() as ArrayList<Visit>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.visit_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentListVisitData[position], position)
    }

    override fun getItemCount(): Int = currentListVisitData?.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val txtWeight: TextView = itemView.findViewById(R.id.txtWeight)
        private val txtTemperature: TextView = itemView.findViewById(R.id.txtTemperature)
        private val txtPressure: TextView = itemView.findViewById(R.id.txtPressure)
        private val txtSaturationLevel: TextView = itemView.findViewById(R.id.txtSaturationLevel)

        fun bind(item: Visit, position: Int){
            txtWeight.text = "Peso: " + item.weight.toString()
            txtTemperature.text = "Tempetura: " + item.temperature.toString()
            txtPressure.text = "Presión: " + item.pressure.toString()
            txtSaturationLevel.text = "Saturación: " + item.saturation_lvl.toString()
        }
    }
}