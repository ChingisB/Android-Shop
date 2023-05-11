package com.example.afinal.views.staff

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.afinal.data.models.product.Vendor
import com.example.afinal.viewmodels.VendorViewModel
import kotlinx.coroutines.launch

@Composable
fun CreateVendor(vendorViewModel: VendorViewModel, navController: NavController) {
    var vendorName by remember { mutableStateOf("") }
    var vendorDescription by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()

    LazyColumn(modifier = Modifier.fillMaxSize().padding(20.dp)){
        item{
            OutlinedTextField(
                value = vendorName,
                onValueChange = {
                    if(it.length<=30){
                        vendorName = it
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
                label = { Text("Vendor name") },
            )
            OutlinedTextField(
                value = vendorDescription,
                onValueChange = { vendorDescription = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(45, 155, 240),
                    unfocusedBorderColor = Color.LightGray,
                    placeholderColor = Color.Gray,
                    cursorColor = Color(45, 155, 240),
                ),
                label = { Text("Vendor description") },
            )
            Button(
                onClick = {
                    coroutineScope.launch {
                        vendorViewModel.createVendor(Vendor(vendorName,vendorDescription))
                    }
                    navController.navigate("VendorList")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 25.dp),
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(45, 155, 240))
            ) {
                Text(
                    text = "Create Vendor",
                    modifier = Modifier.padding(5.dp),
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
        }
    }
}