package com.example.suhareva_up.Presentation.Components


import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color


@Composable
fun MainButton(title: String, onClick:()-> Unit){
    Button(onClick = {
        onClick()
    },
        modifier = Modifier.width(335.dp) .height(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(72, 178, 231)
        ),
        shape = RoundedCornerShape (10.dp)
    ) {
        Text(title,
            fontSize = 18.sp,
            color = Color.White)
    }
}

@Composable
fun BackButton(){
    IconButton(onClick = {  },
        modifier = Modifier.padding(15.dp)
            .size(40.dp),
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = Color(247, 247, 249)
        )
    ) {
        Icon(
            Icons.Filled.KeyboardArrowLeft,
            contentDescription = "Назад",
            modifier = Modifier.size(50.dp),
            tint = Color(43, 43, 43))
    }
}
