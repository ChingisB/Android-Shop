package com.example.afinal.views.admin

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.afinal.data.models.user.User
import com.example.afinal.viewmodels.StaffViewModel


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StaffList(staffViewModel: StaffViewModel, navController: NavController) {
    val staffList by staffViewModel.staffList.collectAsState()
    LazyColumn(modifier = Modifier.padding(top = 10.dp)) {
        items(items = staffList) { item ->
            if (!item.isSuperuser) {
                StaffCard(staff = item, staffViewModel)
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun StaffCard(staff: User, staffViewModel: StaffViewModel) {
    Card(modifier = Modifier.fillMaxWidth(), onClick = {}) {
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            Column() {
                Text(staff.username)
                Text(staff.email)
            }
            /*Button(onClick = {
                staffViewModel.deleteStaff(staff.id)
                staffViewModel.getStaff()
            }) {
                Text("Delete")
            }*/
            IconButton(onClick = { staffViewModel.deleteStaff(staff.id) }) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Delete",
                    tint = Color.Black
                )
            }
        }
    }
}
