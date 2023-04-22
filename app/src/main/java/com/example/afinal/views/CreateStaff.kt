package com.example.afinal.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.*
import com.example.afinal.data.models.user.UserSignUp
import com.example.afinal.viewmodels.StaffViewModel

@Composable
fun CreateStaff(staffViewModel: StaffViewModel) {
    Column() {
        var username by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var confirmPassword by remember { mutableStateOf("") }

        OutlinedTextField(value = username, onValueChange = { username = it })
        OutlinedTextField(value = email, onValueChange = { email = it })
        OutlinedTextField(value = password, onValueChange = { password = it })
        OutlinedTextField(value = confirmPassword, onValueChange = { confirmPassword = it })
        Button(onClick = {
            if(password == confirmPassword){
                staffViewModel.createStaff(UserSignUp(username, email, password, confirmPassword))
            }
        }) {
        }
    }
}