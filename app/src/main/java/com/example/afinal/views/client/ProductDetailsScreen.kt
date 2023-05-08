package com.example.afinal.views.client

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import coil.compose.AsyncImage
import com.example.afinal.data.models.product.Image
import com.example.afinal.data.models.product.ProductDetails

@Composable
fun ProductDetailsScreen(productDetails: ProductDetails) {
    Column() {
        ImageCarousel(images = productDetails.images)
        Text(text = productDetails.name)
        Text(text = productDetails.description)
    }
}

@Composable
fun ImageCarousel(images: List<Image>) {
    val state = rememberLazyListState()
    LazyRow(state = state) {
        items(images.size) { index ->
            AsyncImage(model = images[index].image, contentDescription = "image")
        }
    }
}