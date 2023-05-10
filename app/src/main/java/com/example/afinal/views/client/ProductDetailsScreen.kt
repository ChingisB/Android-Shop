package com.example.afinal.views.client

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import com.example.afinal.data.models.product.Image
import com.example.afinal.viewmodels.CommentViewModel
import com.example.afinal.viewmodels.ProductViewModel

@Composable
fun ProductDetailsScreen(productViewModel: ProductViewModel, commentViewModel: CommentViewModel) {
    val productDetails by productViewModel.product.collectAsState()
    if (productDetails != null) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(text = productDetails!!.name)
            Text(text = productDetails!!.description)
        }
    }
}


@Composable
fun CommentForm(productID: Int, commentViewModel: CommentViewModel) {
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