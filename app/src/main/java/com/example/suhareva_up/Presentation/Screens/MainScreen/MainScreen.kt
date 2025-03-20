package com.example.suhareva_up.Presentation.Screens.MainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.suhareva_up.Presentation.Components.ProductCard


@Composable
fun MainScreen(navController: NavHostController, mainViewModel: MainViewModel = viewModel()){

    mainViewModel.OutputProducts()
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color(247, 247, 249))
    ){
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)){
            items(mainViewModel.productList){
                ProductCard(products = it)
            }
        }
    }

}