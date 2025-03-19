package com.example.suhareva_up.Presentation.Screens.RegScreen


import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.suhareva_up.Data.Models.Profile
import com.example.suhareva_up.Domain.Constant.supabase
import com.example.suhareva_up.Domain.State.RegClass
import com.example.suhareva_up.Domain.State.ResultState
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.exception.AuthRestException
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RegViewModel: ViewModel() {
    private val uiState = mutableStateOf(RegClass()) // переменная, которая взаимодействует с классом RegClass
    val UiState: RegClass get() = uiState.value

    private val resultState = MutableStateFlow<ResultState>(ResultState.Initialized)
    val _ResultState: StateFlow<ResultState> = resultState.asStateFlow()

    fun UpdateRegClass(newState: RegClass) {
        uiState.value = newState
        uiState.value.isEmailError = android.util.Patterns.EMAIL_ADDRESS.matcher(uiState.value.email).matches()
        resultState.value = ResultState.Initialized
    }

    fun SignUp()
    {
        resultState.value = ResultState.Loading
        if (uiState.value.isEmailError && uiState.value.email.isNotEmpty()) {
            viewModelScope.launch {
                try {
                    supabase.auth.signUpWith(Email)
                    {
                        email = uiState.value.email
                        password = uiState.value.password
                    }
                    Log.d("SignUp", "Success")
                    val user = Profile(
                        null,
                        null,
                        null,
                        uiState.value.name,
                        null,
                        uiState.value.email,
                        null)
                    supabase.from("profiles").insert(user)
                    resultState.value = ResultState.Success("Success")
                } catch (ex: AuthRestException) {
                    Log.d("Регистрация","Не вышло")
                    Log.d("Регистрация","${ex.error}")
                    resultState.value = ResultState.Error(ex.errorDescription)
                }
            }
        }else{
            resultState.value = ResultState.Error( "Ошибка ввода почты")
            Log.d("Регистрация", "Проблемы с почтой")
        }
    }
}