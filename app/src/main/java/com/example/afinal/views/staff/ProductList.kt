package com.example.afinal.views.staff

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.afinal.viewmodels.ProductViewModel
import com.example.afinal.views.common.ProductCard

@Composable
fun ProductList(productViewModel: ProductViewModel) {
    val products by productViewModel.products.collectAsState()
    LazyColumn() {
        items(products) { item ->
            ProductCard(product = item) { println("staff staff") }
        }
    }
}