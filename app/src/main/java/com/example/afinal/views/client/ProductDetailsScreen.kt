package com.example.afinal.views.client

import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import com.example.afinal.data.models.product.Image
import com.example.afinal.data.models.product.ProductDetails
import com.example.afinal.viewmodels.CommentViewModel

@Composable
fun ProductDetailsScreen(productDetails: ProductDetails, commentViewModel: CommentViewModel) {
    Column(modifier = Modifier.fillMaxSize()) {
        ImageCarousel(images = productDetails.images)
        Text(text = productDetails.name)
        Text(text = productDetails.description)
        CommentForm(productID = productDetails.id, commentViewModel = commentViewModel)
        CommentList(commentViewModel = commentViewModel)
    }
}


@Composable
fun CommentForm(productID: Int, commentViewModel: CommentViewModel){
    var text by remember { mutableStateOf("") }
    Column() {
        OutlinedTextField(value = text, onValueChange = { text = it })
        Button(onClick = {
            commentViewModel.createComment(productID, text)
            text = ""
        }) {
            Text("Post")
        }
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