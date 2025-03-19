package com.example.suhareva_up.Domain.State

data class RegClass (
    val name: String = "",
    val email: String = "",
    val password: String = "",
    var isEmailError:Boolean = false
)