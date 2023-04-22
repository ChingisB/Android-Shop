package com.example.afinal.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.afinal.data.models.user.User
import com.example.afinal.viewmodels.StaffViewModel

@Composable
fun StaffList(staffViewModel: StaffViewModel){
    val staffList by staffViewModel.staffList.collectAsState()
    LazyColumn(){
        items(items = staffList){
            item ->
            if(!item.isSuperuser) {
                StaffCard(staff = item)
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun StaffCard(staff: User){
    Card(modifier = Modifier.fillMaxWidth(), onClick = {}) {
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            Column() {
                Text(staff.username)
                Text(staff.email)
            }
            Button(onClick = { /*TODO*/ }) {
                Text("Delete")
            }
        }
    }
}
