package com.example.suhareva_up.Presentation.Screens.MainScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.suhareva_up.Domain.State.RegClass
import com.example.suhareva_up.Presentation.Components.CategoryButton
import com.example.suhareva_up.Presentation.Components.ProductCard
import com.example.suhareva_up.Presentation.Components.SearchLine
import com.example.suhareva_up.R


@SuppressLint("UnrememberedMutableState")
@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel = viewModel()){


    var searchText by mutableStateOf("")

    mainViewModel.OutputProducts()
    mainViewModel.OutputCategories()

    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color(247, 247, 249))
    ){
        Row(modifier = Modifier.fillMaxWidth()
            .padding(0.dp, 45.dp, 0. dp, 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            IconButton(onClick = {  }) {
                Icon(
                    painter = painterResource(R.drawable.hamburger),
                    contentDescription = "", modifier = Modifier.size(30.dp),
                    tint = Color.Black
                )}


                Text(text="Главная",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.W300,
                    color = Color.Black)

            IconButton(onClick = {  }) {
                Icon(
                    painter = painterResource(R.drawable.bag),
                    contentDescription = "", modifier = Modifier.size(30.dp),
                    tint = Color.Black
                )}
        }

        Row(modifier = Modifier.fillMaxWidth()
            .padding(10.dp, 15.dp, 10. dp, 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
            SearchLine(searchText) { text -> (searchText)}
            IconButton(onClick = {  }, modifier = Modifier.background(Color(72, 178, 231), shape = CircleShape)) {
                Icon(
                    painter = painterResource(R.drawable.sliders),
                    contentDescription = "", modifier = Modifier.size(30.dp),
                    tint = Color.White,

                )}
        }

        Row(modifier = Modifier.fillMaxWidth()
            .padding(20.dp, 15.dp, 10. dp, 0.dp),
            horizontalArrangement = Arrangement.Start){
            Text(text="Категории",
                fontSize = 15.sp,
                fontWeight = FontWeight.W400,
                color = Color.Black)
        }


        LazyRow {
            items(mainViewModel.categoriesList) {
                CategoryButton(categories = it)
            }
        }

        Row(modifier = Modifier.fillMaxWidth()
            .padding(20.dp, 15.dp, 10. dp, 0.dp),
            horizontalArrangement = Arrangement.Start){
            Text(text="Популярное",
                fontSize = 15.sp,
                fontWeight = FontWeight.W400,
                color = Color.Black)
        }
        
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)){
            items(mainViewModel.productList){
                ProductCard(products = it)
            }
        }
    }

}