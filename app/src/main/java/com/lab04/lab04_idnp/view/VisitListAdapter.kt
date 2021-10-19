package com.lab04.lab04_idnp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lab04.lab04_idnp.R
import com.lab04.lab04_idnp.model.Visit

class VisitListAdapter(private val listVisitData:ArrayList<Visit>): RecyclerView.Adapter<VisitListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.visit_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listVisitData[position], position)
    }

    override fun getItemCount(): Int = listVisitData.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val txtWeight: TextView = itemView.findViewById(R.id.txtWeight)
        private val txtTemperature: TextView = itemView.findViewById(R.id.txtTemperature)
        private val txtPressure: TextView = itemView.findViewById(R.id.txtPressure)
        private val txtSaturationLevel: TextView = itemView.findViewById(R.id.txtSaturationLevel)

        fun bind(item: Visit, position: Int){
            txtWeight.text = item.weight.toString()
            txtTemperature.text = item.weight.toString()
            txtPressure.text = item.weight.toString()
            txtSaturationLevel.text = item.saturation_lvl.toString()
        }
    }
}