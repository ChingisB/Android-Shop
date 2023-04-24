package com.example.afinal.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController

@Composable
fun AdminNavigation(navController: NavController) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(onClick = { navController.navigate("StaffList") }) {
            Text("Staff List")
        }
        Button(onClick = { navController.navigate("CreateStaff") }) {
            Text("Create Staff")
        }
    }
}