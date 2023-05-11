package com.example.afinal.views.client

import android.util.Log
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.example.afinal.viewmodels.CartViewModel
import com.example.afinal.views.common.ProductCard


@Composable
fun CartScreen(cartViewModel: CartViewModel, navController: NavController) {
    val cart by cartViewModel.cart.collectAsState()
    if (cart != null) {
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(cart!!.cart.size) { index ->
                ProductCard(
                    product = cart!!.cart[index].product,
                    onClick = { navController.navigate("ProductDetails/${cart!!.cart[index].product}") },
                    clientMode = false
                )
            }
        }
    } else {
        cartViewModel.errorMessage?.let { Log.e("aaa", it) }
    }
}