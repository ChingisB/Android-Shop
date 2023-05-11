package com.example.afinal.views.client

import android.util.Log
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.afinal.data.models.product.Image
import com.example.afinal.viewmodels.CommentViewModel
import com.example.afinal.viewmodels.ProductDetailsViewModel

@Composable
fun ProductDetailsScreen(
    productDetailsViewModel: ProductDetailsViewModel,
    commentViewModel: CommentViewModel
) {
    val productDetails by productDetailsViewModel.productDetails.collectAsState()
    if (productDetails != null) {
        var isFilled by remember { mutableStateOf(productDetails!!.isLiked) }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                ImageCarousel(images = productDetails!!.images)
                IconButton(
                    onClick = {
                        isFilled = !isFilled
                        if (isFilled) {
                            productDetailsViewModel.likeProduct()
                        } else {
                            productDetailsViewModel.deleteLike()
                        }
                    }
                ) {
                    Box(modifier = Modifier.size(24.dp)) {
                        Icon(
                            imageVector = if (isFilled) Icons.Filled.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = null,
                            tint = if (isFilled) Color.Yellow else Color.Black
                        )
                    }
                }
            }
            Text(text = productDetails!!.name)
            Text(text = productDetails!!.description)
            CommentForm(productID = productDetails!!.id, commentViewModel = commentViewModel)
            CommentList(commentViewModel = commentViewModel)
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
    LazyRow(state = state, modifier = Modifier.fillMaxWidth()) {
        items(images.size) { index ->
            AsyncImage(
                model = images[index].image.replace(
                    "http://92.47.4.210:59001",
                    "http://192.168.137.1:80"
                ),
                contentDescription = "image",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
        }
    }
}