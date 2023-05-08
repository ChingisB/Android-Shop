package com.example.afinal.views

import android.annotation.SuppressLint
import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.afinal.AdminActivity
import com.example.afinal.data.models.user.UserSignUp
import com.example.afinal.viewmodels.StaffViewModel
import com.example.afinal.views.admin.AdminToolBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CreateStaff(staffViewModel: StaffViewModel, navController: NavController) {
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()
    ) {
        var username by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var confirmPassword by remember { mutableStateOf("") }

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Name") })
        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            label = { Text("Password") }
        )
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            label = { Text("Confirm Password") }
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
                    Toast.LENGTH_LONG
                )
                toast.show()
            } else {
                val toast = Toast.makeText(
                    context,
                    "Success! Staff ${username} was created successfully",
                    Toast.LENGTH_LONG
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

}
