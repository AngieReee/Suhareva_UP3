package com.example.suhareva_up.Domain.State

data class SignInClass (
    val email: String = "",
    val password: String = "",
    var isEmailError:Boolean = false
)