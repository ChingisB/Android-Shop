package com.example.afinal

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.afinal.ui.theme.FinalTheme
import com.example.afinal.viewmodels.CartViewModel
import com.example.afinal.viewmodels.CommentViewModel
import com.example.afinal.viewmodels.OrderViewModel
import com.example.afinal.viewmodels.ProductViewModel
import com.example.afinal.views.admin.AdminNavigation
import com.example.afinal.views.admin.AdminToolBar
import com.example.afinal.views.client.ClientNavigation
import com.example.afinal.views.client.ProductDetailsScreen
import com.example.afinal.views.client.ProductList
import kotlinx.coroutines.launch

class ClientActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
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
                    val commentViewModel = viewModel<CommentViewModel>()
                    val coroutineScope = rememberCoroutineScope()
                    Scaffold(
                        topBar = {
                            TopAppBar() {
                                Row(
                                    horizontalArrangement = Arrangement.SpaceAround,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(height = 45.dp)

                                ) {

                                    Text(
                                        text = "Admin Mode",
                                        color = Color.White,
                                        modifier = Modifier.padding(start = 100.dp)
                                    )

                                    IconButton(
                                        onClick = { },
                                        modifier = Modifier.padding(end = 5.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Filled.ExitToApp,
                                            contentDescription = "Exit",
                                            tint = Color.White
                                        )
                                    }
                                }
                            }
                        }, bottomBar = {
                            BottomAppBar() {
                                ClientNavigation(navController = navController)
                            }
                        }, content = {
                            NavHost(
                                navController = navController,
                                startDestination = "ProductList"
                            ) {
                                composable(route = "ProductList") {
                                    productViewModel.getProducts()
                                    ProductList(
                                        productViewModel = productViewModel,
                                        navController = navController
                                    )
                                }
                                composable(route = "ProductDetails/{productID}") { navBackStackEntry ->
                                    val productID = navBackStackEntry.arguments?.getInt("productID")
                                    if(productID != null) {
                                        productViewModel.getProduct(productID)
                                        ProductDetailsScreen(
                                            productViewModel = productViewModel,
                                            commentViewModel = commentViewModel
                                        )
                                    }

                                }
                                composable(route = "Cart") {

                                }
                                composable(route = "Orders") {

                                }
                            }
                        })
                }
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}