package com.example.afinal

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.afinal.ui.theme.FinalTheme
import com.example.afinal.viewmodels.CategoryViewModel
import com.example.afinal.viewmodels.ProductViewModel
import com.example.afinal.viewmodels.VendorViewModel
import com.example.afinal.views.admin.AdminNavigation
import com.example.afinal.views.admin.AdminToolBar
import com.example.afinal.views.staff.*

class StaffActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
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

                    Scaffold(
                        topBar = {
                            TopAppBar() {
                                StaffToolBar()
                            }
                        }, bottomBar = {
                            BottomAppBar() {
                                StaffNavigation(navController = navController)
                            }
                        }, content = {
                            NavHost(
                                navController = navController,
                                startDestination = "ProductList"
                            ) {
                                composable(route = "ProductList") {
                                    productViewModel.getProducts()
                                    ProductList(productViewModel = productViewModel, navController)
                                }
                                composable(route = "CreateProduct") {
                                    vendorViewModel.getVendors()
                                    categoryViewModel.getCategories()
                                    CreateProduct(productViewModel, navController, categoryViewModel, vendorViewModel)
                                }
                                composable(route = "UpdateProduct/{productId}") { backStackEntry ->
                                    val productId = backStackEntry.arguments?.getString("productId")
                                    if (productId != null) {
                                        UpdateProduct(productId.toInt())
                                    }
                                }
                                composable(route = "VendorList") {
                                    vendorViewModel.getVendors()
                                    VendorList(vendorViewModel, navController)
                                }
                                composable(route = "CreateVendor") {
                                    CreateVendor(vendorViewModel, navController)
                                }
                                composable(route = "UpdateVendor/{vendorId}") { backStackEntry ->
                                    val vendorId = backStackEntry.arguments?.getString("vendorId")
                                    if (vendorId != null) {
                                        UpdateProduct(vendorId.toInt())
                                    }
                                }
                                composable(route = "CategoryList") {
                                    categoryViewModel.getCategories()
                                    CategoryList(categoryViewModel, navController)
                                }
                                composable(route = "CreateCategory") {
                                    CreateCategory(categoryViewModel, navController)
                                }
                                composable(route = "UpdateCategory/{categoryId}") { backStackEntry ->
                                    val categoryId =
                                        backStackEntry.arguments?.getString("categoryId")
                                    if (categoryId != null) {
                                        UpdateProduct(categoryId.toInt())
                                    }
                                }
                            }
                        }
                    )
                }
            }
        }

    }
    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}