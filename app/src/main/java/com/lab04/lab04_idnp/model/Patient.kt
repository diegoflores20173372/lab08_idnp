package com.lab04.lab04_idnp.model

data class Patient (var name:String, var lastName:String,
                    var DNI:String, var address:String,
                    var visits:ArrayList<Visit>)