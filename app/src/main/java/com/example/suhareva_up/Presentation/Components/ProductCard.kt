package com.example.suhareva_up.Presentation.Components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.suhareva_up.Data.Models.Products
import com.example.suhareva_up.R


@Composable
fun ProductCard(products: Products){

    val imageState = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current).data(products.images)
            .size(coil.size.Size.ORIGINAL).build()
    ).state

    var text: String = ""

    if (products.is_best_seller==true) text = "BEST SELLER"


    Card(
        modifier = Modifier
            .fillMaxSize()
            .height(310.dp)
            .padding(7.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White // Установка фонового цвета
                )
    ){
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start) {
            IconButton(onClick = {  }) {
                Icon(
                    painter = painterResource(R.drawable.heart),
                    contentDescription = "Избранное", modifier = Modifier.size(30.dp),
                    tint = Color.Black
                )
            }
        }


        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            if (imageState is AsyncImagePainter.State.Success) {
                Image(
                    painter = imageState.painter,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp, 7.dp, 0.dp, 0.dp),
            horizontalArrangement = Arrangement.Start) {
            Text(text=text,
                color = Color(72, 178, 231),
                fontWeight = FontWeight.W300,
            )
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp, 5.dp, 0.dp, 0.dp),
            horizontalArrangement = Arrangement.Start) {
            Text(text=products.title.toString(),
                color = Color(106, 106, 106),
                fontWeight = FontWeight.W300,
            )
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp, 12.dp, 0.dp, 5.dp),
            horizontalArrangement = Arrangement.Start) {
            Text(text="₽"+ products.cost.toString(),
                color = Color(106, 106, 106),
                fontWeight = FontWeight.W300,
            )
            Box(modifier = Modifier.fillMaxSize()) {
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color(72, 178, 231), shape = RoundedCornerShape(10.dp))
                        .align(Alignment.BottomEnd),
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }

        }
    }
}