package com.example.afinal.views.staff

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.afinal.data.models.product.Category
import com.example.afinal.data.models.product.CreateProduct
import com.example.afinal.data.models.product.Vendor
import com.example.afinal.viewmodels.CategoryViewModel
import com.example.afinal.viewmodels.ProductViewModel
import com.example.afinal.viewmodels.VendorViewModel
import kotlinx.coroutines.launch

@Composable
fun CreateProduct(
    productViewModel: ProductViewModel,
    navController: NavController,
    categoryViewModel: CategoryViewModel,
    vendorViewModel: VendorViewModel
) {
    val coroutineScope = rememberCoroutineScope()
    var productCategoryId by remember { mutableStateOf(-1) }
    var productDescription by remember { mutableStateOf("") }
    var productName by remember { mutableStateOf("") }
    var productPrice by remember { mutableStateOf("") }
    var productQuantity by remember { mutableStateOf("") }
    var productVendorId by remember { mutableStateOf(-1) }
    var categoryListExpanded by remember { mutableStateOf(false) }
    var vendorListExpanded by remember { mutableStateOf(false) }
    val categories by categoryViewModel.categories.collectAsState()
    val vendors by vendorViewModel.vendors.collectAsState()
    var selectedVendor by remember { mutableStateOf(Vendor("", "")) }
    var selectedCategory by remember { mutableStateOf(Category("", "")) }



    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        item {
            OutlinedTextField(
                value = productName,
                onValueChange = {
                    if (it.length <= 30) {
                        productName = it
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
                label = { Text("Product name") },
            )
            OutlinedTextField(
                value = productDescription,
                onValueChange = { productDescription = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(45, 155, 240),
                    unfocusedBorderColor = Color.LightGray,
                    placeholderColor = Color.Gray,
                    cursorColor = Color(45, 155, 240),
                ),
                label = { Text("Product description") },
            )
            OutlinedTextField(
                value = productPrice,
                onValueChange = { productPrice = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(45, 155, 240),
                    unfocusedBorderColor = Color.LightGray,
                    placeholderColor = Color.Gray,
                    cursorColor = Color(45, 155, 240),
                ),
                label = { Text("Product price") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            OutlinedTextField(
                value = productQuantity,
                onValueChange = { productQuantity = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(45, 155, 240),
                    unfocusedBorderColor = Color.LightGray,
                    placeholderColor = Color.Gray,
                    cursorColor = Color(45, 155, 240),
                ),
                label = { Text("Product quantity") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Box(modifier = Modifier.wrapContentSize(Alignment.TopStart)) {
                Text(
                    text = selectedCategory.name,
                    modifier = Modifier
                        .clickable(onClick = { categoryListExpanded = true })
                        .background(Color.LightGray)
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .border(1.dp, Color.Black, RoundedCornerShape(4.dp)),
                )
                DropdownMenu(
                    expanded = categoryListExpanded,
                    onDismissRequest = { categoryListExpanded = false },
                    modifier = Modifier.background(Color.White)
                ) {
                    categories.forEach { category ->
                        DropdownMenuItem(
                            onClick = {
                                selectedCategory = category
                                productCategoryId = category.id
                                categoryListExpanded = false
                            }
                        ) {
                            Text(text = category.name)
                        }
                    }
                }
            }

            Box(modifier = Modifier.wrapContentSize(Alignment.TopStart)) {
                Text(
                    text = selectedVendor.name,
                    modifier = Modifier
                        .clickable(onClick = { vendorListExpanded = true })
                        .background(Color.LightGray)
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .border(1.dp, Color.Black, RoundedCornerShape(4.dp)),
                )
                DropdownMenu(
                    expanded = vendorListExpanded,
                    onDismissRequest = { vendorListExpanded = false },
                    modifier = Modifier.background(Color.White)
                ) {
                    vendors.forEach { vendor ->
                        DropdownMenuItem(
                            onClick = {
                                selectedVendor = vendor
                                productVendorId = vendor.id
                                vendorListExpanded = false
                            }
                        ) {
                            Text(text = vendor.name)
                        }
                    }
                }
            }



            Button(
                onClick = {
                    productViewModel.createProduct(
                        CreateProduct(
                            productCategoryId,
                            productDescription,
                            productName,
                            productPrice.toInt(),
                            productQuantity.toInt(),
                            productVendorId
                        ), emptyList()
                    )
                    navController.navigate("CategoryList")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 25.dp),
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(45, 155, 240))
            ) {
                Text(
                    text = "Create Category",
                    modifier = Modifier.padding(5.dp),
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
        }
    }
}

