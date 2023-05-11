package com.example.afinal.views.client

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.afinal.data.models.product.Category
import com.example.afinal.data.models.product.Vendor
import com.example.afinal.viewmodels.CategoryViewModel
import com.example.afinal.viewmodels.ProductViewModel
import com.example.afinal.viewmodels.VendorViewModel
import com.example.afinal.views.common.ProductCard

@Composable
fun ProductList(productViewModel: ProductViewModel, navController: NavController) {
    val products by productViewModel.products.collectAsState()
    Column() {
        Row() {
            var name by remember {
                mutableStateOf("")
            }
            OutlinedTextField(value = name, onValueChange = { it ->
                name = it
                productViewModel.getProducts(name = name)
            }, leadingIcon = { Icon(imageVector = Icons.Default.Search, "", tint = Color.Black) })
            IconButton(onClick = { navController.navigate("Filter") }) {
                Icon(Icons.Default.Menu, "")
            }
        }
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(products.size) { index ->
                ProductCard(
                    product = products[index],
                    onClick = { navController.navigate("ProductDetails/${products[index].id}") },
                    clientMode = true,
                    productViewModel = productViewModel
                )
            }
        }
    }
}

@Composable
fun Filter(
    productViewModel: ProductViewModel,
    vendorViewModel: VendorViewModel,
    categoryViewModel: CategoryViewModel,
    navController: NavController
) {
    val categories by categoryViewModel.categories.collectAsState()
    val vendors by vendorViewModel.vendors.collectAsState()
    var categoriesExpanded by remember { mutableStateOf(false) }
    var vendorsExpanded by remember { mutableStateOf(false) }
    var chosenCategory by remember {
        mutableStateOf<Category?>(productViewModel.category)
    }
    var chosenVendor by remember {
        mutableStateOf<Vendor?>(productViewModel.vendor)
    }
    var minPrice by remember { mutableStateOf(productViewModel.minPrice) }
    var maxPrice by remember { mutableStateOf(productViewModel.maxPrice) }
    Column() {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { navController.popBackStack() }) {
                Text("Back")
            }
            Button(onClick = {
                minPrice = null
                maxPrice = null
                chosenCategory = null
                chosenVendor = null
                productViewModel.resetFilter()
            }) {
                Text("Reset")
            }
        }
        Box() {
            Text(
                chosenCategory?.name ?: "Choose category",
                modifier = Modifier.clickable { categoriesExpanded = true })
            DropdownMenu(
                expanded = categoriesExpanded,
                onDismissRequest = { categoriesExpanded = false }) {
                categories.forEach { category ->
                    Text(
                        text = category.name,
                        modifier = Modifier.clickable { chosenCategory = category })
                }
            }
        }
        Box() {
            Text(
                chosenVendor?.name ?: "Choose vendor",
                modifier = Modifier.clickable { vendorsExpanded = true })
            DropdownMenu(
                expanded = vendorsExpanded,
                onDismissRequest = { vendorsExpanded = false }) {
                vendors.forEach { vendor ->
                    Text(
                        text = vendor.name,
                        modifier = Modifier.clickable { chosenVendor = vendor })
                }
            }
        }
        OutlinedTextField(
            value = if (minPrice != null) minPrice.toString() else "",
            onValueChange = {
                if (it.length <= 30) {
                    minPrice = it.toInt()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(45, 155, 240),
                unfocusedBorderColor = Color.LightGray,
                placeholderColor = Color.Gray,
                cursorColor = Color(45, 155, 240),
            ),
            maxLines = 1,
            label = { Text("Minimum price") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = if (maxPrice != null) maxPrice.toString() else "",
            onValueChange = {
                if (it.length <= 30) {
                    maxPrice = it.toInt()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(45, 155, 240),
                unfocusedBorderColor = Color.LightGray,
                placeholderColor = Color.Gray,
                cursorColor = Color(45, 155, 240),
            ),
            maxLines = 1,
            label = { Text("Maximum price") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(onClick = {
            val minPriceSearch: Int? = minPrice?.toInt()
            val maxPriceSearch: Int? = maxPrice?.toInt()
            productViewModel.setFilter(
                chosenCategory,
                chosenVendor,
                minPriceSearch,
                maxPriceSearch
            )
            navController.popBackStack()
        }) {
            Text("Search")
        }
    }
}