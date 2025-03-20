package com.example.suhareva_up.Presentation.Screens.SignIn

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.suhareva_up.Domain.Constant
import com.example.suhareva_up.Domain.State.ResultState
import com.example.suhareva_up.Domain.State.SignInClass
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.exception.AuthRestException
import io.github.jan.supabase.auth.providers.builtin.Email
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope

class SignInViewModel: ViewModel() {
    private val uiState = mutableStateOf(SignInClass()) // переменная, которая взаимодействует с классом SignInClass
    val UiState: SignInClass get() = uiState.value

    private val resultState = MutableStateFlow<ResultState>(ResultState.Initialized)
    val _ResultState: StateFlow<ResultState> = resultState.asStateFlow()

    fun UpdateSignInClass(newState: SignInClass) {
        uiState.value = newState
        uiState.value.isEmailError = android.util.Patterns.EMAIL_ADDRESS.matcher(uiState.value.email).matches()
        resultState.value = ResultState.Initialized
    }

    fun SignIn() {
        resultState.value = ResultState.Loading
        if (uiState.value.isEmailError) {
            viewModelScope.launch {
                try {
                    Constant.supabase.auth.signInWith(Email)
                    {
                        email = uiState.value.email
                        password = uiState.value.password
                    }
                    Log.d("SignIn", "Success")

                    resultState.value = ResultState.Success("Success")
                } catch (_ex: AuthRestException) {
                    Log.d("SignIn", _ex.message.toString())
                }
            }
        }
        else{
            resultState.value = ResultState.Error( "Ошибка ввода почты")
        }
    }

}