package com.example.afinal.views.client

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
fun ClientNavigation(navController: NavController) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(onClick = { navController.navigate("Cart") }) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_cart_white),
                contentDescription = "Cart",
                tint = Color.White
            )
        }
        IconButton(onClick = { navController.navigate("ProductList") }) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_home_white),
                contentDescription = "Home",
                tint = Color.White
            )
        }
        IconButton(onClick = { navController.navigate("Profile") }) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_profile_white),
                contentDescription = "Profile",
                tint = Color.White
            )
        }
    }
}

@Preview
@Composable
fun CNPreview() {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().background(color = Color.Cyan)
    ) {

        IconButton(onClick = { }) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_cart_white),
                contentDescription = "Cart",
                tint = Color.White
            )
        }
        IconButton(onClick = { }) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_home_white),
                contentDescription = "Home",
                tint = Color.White
            )
        }
        IconButton(onClick = { }) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_profile_white),
                contentDescription = "Profile",
                tint = Color.White
            )
        }
    }
}