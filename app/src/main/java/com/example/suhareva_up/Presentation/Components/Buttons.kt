package com.example.suhareva_up.Presentation.Components


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.example.suhareva_up.R

val buttonWeidht: Int = 300

@Composable
fun MainButton(title: String, checked: Boolean, onClick:()-> Unit){
    Button(onClick = {
        onClick()
    },
        enabled = checked,
        modifier = Modifier.width(buttonWeidht.dp) .height(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(72, 178, 231),
            disabledContainerColor = Color(43, 107, 139)
        ),
        shape = RoundedCornerShape (10.dp)
    ) {
        Text(title,
            fontSize = 18.sp,
            color = Color.White)
    }
}

@Composable
fun NavButton(title1: String, title2: String, onClick:()-> Unit){
    Button(onClick = {
        onClick()
    },
        modifier = Modifier.width(buttonWeidht.dp) .height(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape (10.dp)
    ) {
        Row {
            Text(title1,
                fontSize = 18.sp,
                fontWeight = FontWeight.W300,
                color = Color(106, 106, 106))
            Text(title2,
                fontSize = 18.sp,
                fontWeight = FontWeight.W300,
                color = Color.Black,
                modifier = Modifier.padding(7.dp, 0.dp, 0.dp, 0.dp))
        }

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

@Composable
fun CustomCheckbox(
    modifier: Modifier,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    IconButton(modifier = modifier, onClick = { onCheckedChange(!checked) }) {
        //the box image frame unchecked
        Image(
            painter = painterResource(id = R.drawable.checkbox),
            contentDescription = "Unchecked",
            modifier = Modifier.size(30.dp)
        )
        AnimatedVisibility(
            visible = checked,
            modifier = Modifier.size(30.dp)
            /*exit = shrinkOut(shrinkTowards = Alignment.TopStart) + fadeOut()*/
        ) {
            //the check only (without the surrounding box)
            Image(
                painter = painterResource(id = R.drawable.checkbox),
                contentDescription = "Checked",
                modifier = Modifier.background(color = Color(72, 178, 231))
            )
        }
    }
}
