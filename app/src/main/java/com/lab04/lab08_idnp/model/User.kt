package com.lab04.lab08_idnp.model

data class User(
    var fullName: String,
    var phone: String,
    var email: String,
    var beenVaccinated: Boolean,
    var typeVaccine: String
)