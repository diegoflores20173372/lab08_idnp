package com.lab04.lab08_idnp.service

import com.lab04.lab08_idnp.model.User

// Service
object PatientService {

    // Repository
    private var users: ArrayList<User?> = arrayListOf()

    fun list(): ArrayList<User?> {
        return users
    }

    fun findById(id: Int): User? {
        return if (id >= users.size)
            null
        else
            users[id]
    }

    fun save(user: User): Int {
        users.add(user)
        return users.lastIndex
    }

}