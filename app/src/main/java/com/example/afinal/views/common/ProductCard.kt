package com.example.afinal.views.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.afinal.R
import com.example.afinal.data.models.product.Product
import com.example.afinal.viewmodels.ProductViewModel


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProductCard(
    product: Product,
    onClick: () -> Unit,
    clientMode: Boolean = true,
    staffMode: Boolean = false,
    productViewModel: ProductViewModel? = null
) {
    Card(onClick = { onClick() }) {
        Column(modifier = Modifier.fillMaxWidth()) {
            var image = product.image.image
            if(image != null){
                image = image.replace("http://92.47.4.210:59001", "http://192.168.137.1:80")
            }
            Box() {
                AsyncImage(model = image, contentDescription = "product image")
                if (clientMode) {
                    var isFilled by remember { mutableStateOf(product.isLiked) }
                    IconButton(
                        onClick = {
                            isFilled = !isFilled
                            if (isFilled) {
                                productViewModel?.likeProduct(product.id)
                            } else {
                                productViewModel?.deleteLike(product.id)
                            }

                        },
                        modifier = Modifier.align(alignment = Alignment.TopEnd)
                    ) {
                        Icon(
                            imageVector = if (isFilled) Icons.Filled.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = "Add to favorite",
                            tint = if(isFilled) Color.Yellow else Color.Black
                        )
                    }
                }else if (staffMode){
                    IconButton(onClick = {productViewModel?.deleteProduct(product.id)}) {
                        Icon(
                            imageVector = Icons.Filled.Delete,
                            contentDescription = "delete product",
                            tint = Color.LightGray
                        )
                    }
                }
            }
            Text(
                text = product.name,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 5.dp)
            )
            Text(
                text = product.price,
                fontSize = 25.sp,
                modifier = Modifier.padding(top = 10.dp, start = 5.dp)
            )
            if(clientMode) {
                Button(
                    onClick = { /*TODO*/ }, modifier = Modifier
                        .width(width = 100.dp)
                        .align(alignment = Alignment.CenterHorizontally)
                ) {
                    Text(text = "BUY")
                }
            }
        }
    }
}