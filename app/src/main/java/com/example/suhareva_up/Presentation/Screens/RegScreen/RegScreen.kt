package com.example.suhareva_up.Presentation.Screens.RegScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.suhareva_up.Presentation.Components.BackButton
import com.example.suhareva_up.Presentation.Components.EmailTextField
import com.example.suhareva_up.Presentation.Components.MainButton
import com.example.suhareva_up.Presentation.Components.MainTextField
import com.example.suhareva_up.Presentation.Components.PasswordTextField

@Composable
fun RegScreen(navController: NavController, regViewModel: RegViewModel = viewModel()){

    val uiState = regViewModel.UiState
    
    Column(
        modifier = Modifier
            .fillMaxSize() .background(Color.White)
    ) {
        BackButton()
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Регистрация",
                fontSize = 32.sp,
                fontWeight = FontWeight.W400,
                modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp),
                color = Color.Black
            )
            Text(
                text = "Заполните свои данные",
                fontSize = 18.sp,
                fontWeight = FontWeight.W400,
                modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp),
                color = Color(112, 123, 129) 
            )

        }
        Spacer(Modifier.height(40.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Ваше имя",
                fontSize = 19.sp,
                color = Color.Black,
                modifier = Modifier.padding(15.dp, 0.dp, 0.dp, 0.dp)
            )
            Spacer(Modifier.height(20.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                MainTextField(uiState.name) { regViewModel.UpdateRegClass(uiState.copy(name = it)) }
            }
            Spacer(Modifier.height(20.dp))
             Text(
                 text = "Email",
                 fontSize = 19.sp,
                 color = Color.Black,
                 modifier = Modifier.padding(15.dp, 0.dp, 0.dp, 0.dp)
             )
            Spacer(Modifier.height(20.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                EmailTextField(uiState.email, uiState.isEmailError) {
                    regViewModel.UpdateRegClass(
                        uiState.copy(email = it)
                    )
                }
            }
             Spacer(Modifier.height(20.dp))
             Text(
                 text = "Пароль",
                 fontSize = 19.sp,
                 color = Color.Black,
                 modifier = Modifier.padding(15.dp, 0.dp, 0.dp, 0.dp)
             )
            Spacer(Modifier.height(20.dp))
             Column(
                 modifier = Modifier.fillMaxWidth(),
                 horizontalAlignment = Alignment.CenterHorizontally
             ) {
                 PasswordTextField(uiState.password) {
                     regViewModel.UpdateRegClass(
                         uiState.copy(
                             password = it
                         )
                     )
                 }
             }
             Spacer(Modifier.height(20.dp))
             Column(
                 modifier = Modifier.fillMaxWidth(),
                 horizontalAlignment = Alignment.CenterHorizontally
             ) {
                 MainButton("Зарегистрироваться") { regViewModel.SignUp() }
             }
        }
    }
}