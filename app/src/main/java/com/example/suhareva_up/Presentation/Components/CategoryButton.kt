package com.example.suhareva_up.Presentation.Components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.suhareva_up.Data.Models.Categories

@Composable
fun CategoryButton(categories: Categories){
    Button(onClick = {

    },
        modifier = Modifier.width(180.dp)
            .height(50.dp)
            .padding(5.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row {
            Text(
                text = categories.title.toString(),
                fontSize = 18.sp,
                fontWeight = FontWeight.W300,
                color = Color.Black)
        }

    }
}