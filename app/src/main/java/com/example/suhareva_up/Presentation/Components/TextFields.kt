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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.suhareva_up.R

@Preview
@Composable
fun MainTextField(){
    TextField(
        value = "",
        onValueChange = {},
        modifier = Modifier.width(335.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(247, 247, 249),
            focusedContainerColor = Color(247, 247, 249),
            focusedTextColor = Color(106, 106, 106),
            unfocusedTextColor = Color(106, 106, 106)
        ),
            shape = RoundedCornerShape (15.dp))
}

@Preview
@Composable
fun PasswordTextField(){
    var passwordVisible by remember { mutableStateOf(true) } //видимость пароля
    TextField(
        value = "",
        onValueChange = {},
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

@Preview
@Composable
fun EmailTextField(){
    TextField(
        value = "",
        onValueChange = {},
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
