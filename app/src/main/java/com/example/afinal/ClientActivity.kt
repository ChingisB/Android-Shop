package com.example.afinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.afinal.ui.theme.FinalTheme
import com.example.afinal.viewmodels.CartViewModel
import com.example.afinal.viewmodels.OrderViewModel
import com.example.afinal.viewmodels.ProductViewModel
import com.example.afinal.views.client.ProductList

class ClientActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    val productViewModel = viewModel<ProductViewModel>()
                    val cartViewModel = viewModel<CartViewModel>()
                    val orderViewModel = viewModel<OrderViewModel>()
                    NavHost(navController = navController, startDestination = "ProductList") {
                        composable(route = "ProductList") {
                            productViewModel.getProducts()
                            ProductList(
                                productViewModel = productViewModel,
                                navController = navController
                            )
                        }
                        composable(route = "ProductDetails/{productID}") {

                        }
                        composable(route = "Cart") {

                        }
                        composable(route = "Orders") {

                        }
                    }
                }
            }
        }
    }
}