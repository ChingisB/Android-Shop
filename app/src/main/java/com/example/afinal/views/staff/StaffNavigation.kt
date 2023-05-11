package com.example.afinal.views.staff

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.afinal.R

@Composable
fun StaffNavigation(navController: NavController) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(onClick = { navController.navigate("CategoryList") }) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_category_white),
                contentDescription = "CategoryList",
                tint = Color.White
            )
        }
        IconButton(onClick = { navController.navigate("ProductList") }) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_shopping_basket_white),
                contentDescription = "ProductList",
                tint = Color.White
            )
        }
        IconButton(onClick = { navController.navigate("VendorList") }) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_vendor_white),
                contentDescription = "VendorList",
                tint = Color.White
            )
        }
    }
}

@Preview
@Composable
fun SNPreview() {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().background(color = Color.Magenta)
    ) {
        IconButton(onClick = {  }) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_category_white),
                contentDescription = "CategoryList",
                tint = Color.White
            )
        }
        IconButton(onClick = {  }) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_vendor_white),
                contentDescription = "VendorList",
                tint = Color.White
            )
        }
        IconButton(onClick = {  }) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_shopping_basket_white),
                contentDescription = "ProductList",
                tint = Color.White
            )
        }
    }
}
