package com.example.afinal.views.client

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.afinal.viewmodels.CartViewModel
import com.example.afinal.viewmodels.CategoryViewModel

@Composable
fun CartScreen(cartViewModel: CartViewModel, navController: NavController){
    val cart by cartViewModel.
    LazyVerticalGrid(columns = GridCells.Fixed(2)){
        item()
    }
}