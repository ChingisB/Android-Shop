package com.example.afinal.views.staff

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import coil.compose.AsyncImage
import com.example.afinal.data.models.product.Product
import com.example.afinal.viewmodels.ProductViewModel

@Composable
fun ProductList(productViewModel: ProductViewModel) {
    val products by productViewModel.products.collectAsState()
    LazyColumn() {
        items(products) { item ->
            ProductCard(product = item)
        }
    }
}

@Composable
fun ProductCard(product: Product) {
    Row() {
        AsyncImage(model = product.image, contentDescription = "Product image")
        Column() {
            Text(product.name)
            Text(product.description)
            Text(product.price)
            Text(product.category.name)
            Text(product.vendor.name)
        }
    }
}