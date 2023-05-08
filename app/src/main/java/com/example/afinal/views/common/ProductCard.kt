package com.example.afinal.views.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import com.example.afinal.data.models.product.Product

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProductCard(product: Product, onClick: () -> Unit) {
    Card(onClick = { onClick() }) {
        Column(modifier = Modifier.fillMaxWidth()) {
            var image = product.image.image
            image = image.replace("http://92.47.4.210:59001", "http://192.168.137.1:80")
            AsyncImage(model = image, contentDescription = "product image")
            Text(text = product.name)
            Text(text = product.price)
        }
    }
}