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
import com.example.afinal.viewmodels.CategoryViewModel
import com.example.afinal.viewmodels.ProductViewModel
import com.example.afinal.viewmodels.VendorViewModel
import com.example.afinal.views.staff.ProductList

class StaffActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    val categoryViewModel = viewModel<CategoryViewModel>()
                    val vendorViewModel = viewModel<VendorViewModel>()
                    val productViewModel = viewModel<ProductViewModel>()
                    NavHost(navController = navController, startDestination = "ProductList"){
                        composable(route = "ProductList"){
                            ProductList(productViewModel = productViewModel)
                        }
                        composable(route = "CreateProduct"){

                        }
                        composable(route = "VendorList"){
                            VendorList()
                        }
                        composable(route = "CreateVendor"){

                        }
                        composable(route = "CategoryList"){

                        }
                        composable(route = "CreateCategory"){

                        }
                    }
                }
            }
        }
    }
}