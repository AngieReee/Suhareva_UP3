package com.example.suhareva_up.Presentation.Components

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.suhareva_up.R


@Composable
fun MainTextField(value: String, onvaluechange: (String) -> Unit){
    TextField(
        value = value,
        onValueChange = {
            onvaluechange(it)
        },
        modifier = Modifier.width(335.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(247, 247, 249),
            focusedContainerColor = Color(247, 247, 249),
            focusedTextColor = Color(106, 106, 106),
            unfocusedTextColor = Color(106, 106, 106)
        ),
            shape = RoundedCornerShape (15.dp))
}


@Composable
fun PasswordTextField(value: String, onvaluechange: (String) -> Unit){
    var passwordVisible by remember { mutableStateOf(true) } //видимость пароля
    TextField(
        value = value,
        onValueChange = {
            onvaluechange(it)
        },
        placeholder = { Text("12345") },
        modifier = Modifier.width(335.dp),
        colors = TextFieldDefaults . colors (
            unfocusedContainerColor = Color(247, 247, 249),
            focusedContainerColor = Color(247, 247, 249),
            focusedTextColor = Color(106, 106, 106),
            unfocusedTextColor = Color(106, 106, 106)
    ),
        shape = RoundedCornerShape (15.dp),
        visualTransformation = if (passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            IconButton(onClick = {
                passwordVisible = !passwordVisible
            }) {
                if (passwordVisible) {
                    Icon(
                        painter = painterResource(id = R.drawable.eye_close),
                        contentDescription = ""
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.eye_open),
                        contentDescription = ""
                    )
                }
            }
        }
    )
}


@Composable
fun EmailTextField(value: String, onvaluechange: (String) -> Unit){
    TextField(
        value = value,
        onValueChange = {
            onvaluechange(it)
        },
        placeholder = { Text("xyz@gmail.com") },
        modifier = Modifier.width(335.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(247, 247, 249),
            focusedContainerColor = Color(247, 247, 249),
            focusedTextColor = Color(106, 106, 106),
            unfocusedTextColor = Color(106, 106, 106)
        ),
        shape = RoundedCornerShape (15.dp))
}
