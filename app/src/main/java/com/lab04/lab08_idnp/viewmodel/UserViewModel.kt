package com.lab04.lab08_idnp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lab04.lab08_idnp.model.User
import com.lab04.lab08_idnp.service.UserService

class UserViewModel : ViewModel() {
    private val usersLiveData = MutableLiveData<List<User?>>(listOf())
    private val userLiveData = MutableLiveData<User?>()
    fun listUsers() {
        usersLiveData.value = UserService.list()
    }

    fun getListUsers(): LiveData<List<User?>> {
        return usersLiveData
    }

    fun getCurrentUser(): LiveData<User?> {
        return userLiveData
    }

    fun fetchUser(id: Int) {
        userLiveData.value = UserService.findById(id)
    }

    fun saveUser(user: User) {
        userLiveData.value = UserService.findById(UserService.save(user))
    }
}