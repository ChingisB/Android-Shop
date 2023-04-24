package com.example.afinal.views

import android.annotation.SuppressLint
import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.navigation.NavController
import com.example.afinal.data.models.user.UserSignUp
import com.example.afinal.viewmodels.StaffViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CreateStaff(staffViewModel: StaffViewModel, navController: NavController) {
    val context = LocalContext.current
    Scaffold(bottomBar = {
        BottomAppBar() {
            AdminNavigation(navController = navController)
        }
    }, content = {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var username by remember { mutableStateOf("") }
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var confirmPassword by remember { mutableStateOf("") }

            OutlinedTextField(value = username, onValueChange = { username = it })
            OutlinedTextField(value = email, onValueChange = { email = it })
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                visualTransformation = PasswordVisualTransformation()
            )
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                visualTransformation = PasswordVisualTransformation()
            )
            Button(onClick = {
                staffViewModel.createStaff(
                    UserSignUp(
                        username, email, password, confirmPassword
                    )
                )
                if (!staffViewModel.status) {
                    val toast = Toast.makeText(
                        context,
                        "Error! ${staffViewModel.errorMessage}",
                        Toast.LENGTH_SHORT
                    )
                    toast.show()
                } else {
                    val toast = Toast.makeText(
                        context,
                        "Success! Staff ${username} was created successfully",
                        Toast.LENGTH_SHORT
                    )
                    toast.show()
                    username = ""
                    email = ""
                    password = ""
                    confirmPassword = ""
                }
            }) {
                Text("Create staff user")
            }
        }
    })

}