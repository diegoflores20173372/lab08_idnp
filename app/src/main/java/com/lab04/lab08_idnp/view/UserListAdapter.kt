package com.lab04.lab08_idnp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lab04.lab08_idnp.R
import com.lab04.lab08_idnp.model.User

class UserListAdapter(listUserData: List<User?>) :
    RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener
    private var currentListUserData: List<User> = listUserData.filterNotNull() as ArrayList<User>

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
        currentListUserData[position].let { holder.bind(it, position) }
    }

    override fun getItemCount(): Int = currentListUserData.size

    fun updateCurrentListUserData(users: List<User>) {
        currentListUserData = users
        notifyDataSetChanged()
    }

    class ViewHolder(view: View, listener: onItemClickListener) : RecyclerView.ViewHolder(view) {

        private val txtFullName: TextView = itemView.findViewById(R.id.txtFullName)
        private val txtPhone: TextView = itemView.findViewById(R.id.txtPhone)
        private val txtEmail: TextView = itemView.findViewById(R.id.txtEmail)

        init {
            view.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

        fun bind(item: User, position: Int) {
            txtFullName.text = item.fullName
            txtPhone.text = item.phone
            txtEmail.text = item.email
        }
    }
}