package com.example.suhareva_up.Presentation.Screens.SignIn.SignInScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.example.suhareva_up.Presentation.Components.NavButton
import com.example.suhareva_up.Presentation.Components.PasswordTextField
import com.example.suhareva_up.Presentation.Navigations.NavigationRoutes
import com.example.suhareva_up.Presentation.Screens.RegScreen.RegViewModel
import com.example.suhareva_up.Presentation.Screens.SignIn.SignInViewModel

@Composable
fun SignInScreen(navController: NavController, signinViewModel: SignInViewModel = viewModel()) {

    val uiState = signinViewModel.UiState
    var paddingStart: Int = 30;
    var spacer: Int = 15;

    Column(
        modifier = Modifier
            .fillMaxSize().background(Color.White)
    ) {
        BackButton()
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Привет!",
                fontSize = 32.sp,
                fontWeight = FontWeight.W400,
                modifier = Modifier.padding(0.dp, 20.dp, 0.dp, 0.dp),
                color = Color.Black
            )
            Text(
                text = "Заполните свои данные",
                fontSize = 18.sp,
                fontWeight = FontWeight.W300,
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
                text = "Email",
                fontSize = 19.sp,
                color = Color.Black,
                modifier = Modifier.padding(paddingStart.dp, 0.dp, 0.dp, 0.dp)
            )
            Spacer(Modifier.height(spacer.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                EmailTextField(uiState.email, uiState.isEmailError) {
                    signinViewModel.UpdateSignInClass(
                        uiState.copy(email = it)
                    )
                }
            }
            Spacer(Modifier.height(spacer.dp))
            Text(
                text = "Пароль",
                fontSize = 19.sp,
                color = Color.Black,
                modifier = Modifier.padding(paddingStart.dp, 0.dp, 0.dp, 0.dp)
            )
            Spacer(Modifier.height(spacer.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PasswordTextField(uiState.password) {
                    signinViewModel.UpdateSignInClass(
                        uiState.copy(
                            password = it
                        )
                    )
                }
            }
            Spacer(Modifier.height(spacer.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MainButton(
                    "Войти",
                    checked = true
                ) { signinViewModel.SignIn() }
            }
            Spacer(Modifier.height(spacer.dp))
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(0.dp, 0.dp, 0.dp, 45.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    NavButton("Вы впервые?", "Создать") {
                        navController.navigate(NavigationRoutes.REG) {
                            popUpTo(NavigationRoutes.SIGNIN) {
                                inclusive = true
                            }
                        }
                    }
                }
            }
        }
    }
}