package com.example.suhareva_up.Presentation.Screens.MainScreen

import android.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.suhareva_up.Data.Models.Categories
import com.example.suhareva_up.Data.Models.Products
import com.example.suhareva_up.Domain.Constant
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {

    var productList by mutableStateOf<List<Products>>(listOf())
    var categoriesList by mutableStateOf<List<Categories>>(listOf())

    @Composable
    fun OutputProducts(){
        LaunchedEffect(Unit) {
            productList = withContext(Dispatchers.IO) {
                Constant.supabase.from("products").select().decodeList<Products>()
            }
        }
    }

    @Composable
    fun OutputCategories(){
        LaunchedEffect(Unit) {
            categoriesList = withContext(Dispatchers.IO) {
                Constant.supabase.from("categories").select().decodeList<Categories>()
            }
        }
    }


}