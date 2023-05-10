package com.example.afinal.views.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.afinal.R

@Composable
fun AdminNavigation(navController: NavController) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {

        IconButton(onClick = { navController.navigate("StaffList") }) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_group_white),
                contentDescription = "StaffList",
                tint = Color.White
            )
        }
        IconButton(onClick = { navController.navigate("CreateStaff") }) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_add_circle_white),
                contentDescription = "AddStaff",
                tint = Color.White
            )
        }
    }
}

@Preview
@Composable
fun ANPreview() {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Magenta)
    ) {
        IconButton(onClick = { }) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_group_white),
                contentDescription = "StaffList",
                tint = Color.White
            )
        }
        IconButton(onClick = { }) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_add_circle_white),
                contentDescription = "AddStaff",
                tint = Color.White
            )
        }
        /*IconButton(onClick = { navController.navigate("CreateStaff") }) {
            Icon(
                imageVector = Icons.Filled.ExitToApp,
                contentDescription = "Exit",
                tint = Color.White
            )
        }*/
    }
}