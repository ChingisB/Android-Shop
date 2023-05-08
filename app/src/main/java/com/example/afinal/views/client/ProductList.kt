package com.example.afinal.views.client

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.example.afinal.viewmodels.ProductViewModel
import com.example.afinal.views.common.ProductCard

@Composable
fun ProductList(productViewModel: ProductViewModel, navController: NavController) {
    val products by productViewModel.products.collectAsState()
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(products.size) { index ->
            ProductCard(
                product = products[index],
                onClick = { navController.navigate("ProductCard/${products[index].id}") })
        }
    }
}