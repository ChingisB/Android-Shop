package com.example.afinal.views.staff
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.afinal.viewmodels.VendorViewModel

@Composable
fun VendorList(vendorViewModel: VendorViewModel, navController: NavController) {
    val vendors by vendorViewModel.vendors.collectAsState()
    LazyColumn(modifier = Modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally) {
        items(vendors.size) {index ->
            Card(modifier = Modifier.padding(10.dp),
                elevation = 5.dp
            ){
                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween){
                    Text(vendors[index].name)
                    IconButton(onClick = { vendorViewModel.deleteVendor(vendors[index].id)}) {
                        Icon(
                            imageVector = Icons.Filled.Delete,
                            contentDescription = "delete vendor",
                            tint = Color.LightGray
                        )
                    }
                }
            }
        }
        item{
            Button(
                onClick = {navController.navigate("CreateVendor")},
                shape = CircleShape,
                modifier = Modifier.padding(20.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(255, 220, 95, 255))
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "add vendor",
                    tint = Color.White
                )
            }
        }
    }
}