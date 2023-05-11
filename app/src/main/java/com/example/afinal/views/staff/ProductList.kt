package com.example.afinal.views.staff

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.afinal.viewmodels.ProductViewModel
import com.example.afinal.views.common.ProductCard

@Composable
fun ProductList(productViewModel: ProductViewModel, navController: NavController) {
    val products by productViewModel.products.collectAsState()
    Column(modifier = Modifier.padding(20.dp).fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally){
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(products.size) { index ->
                ProductCard(
                    product = products[index],
                    onClick = {},
                    clientMode = false,
                    staffMode = true,
                    productViewModel = productViewModel)
            }
        }
        Button(
            onClick = {navController.navigate("CreateProduct")},
            shape = CircleShape,
            modifier = Modifier.padding(20.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(255, 220, 95, 255))
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "add product",
                tint = Color.White
            )
        }
    }
}