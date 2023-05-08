package com.example.afinal.views

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.core.content.ContextCompat.startActivity
import com.example.afinal.AdminActivity
import com.example.afinal.ClientActivity
import com.example.afinal.StaffActivity
import com.example.afinal.viewmodels.LoginViewModel
import kotlin.math.log

@Composable
fun LoginScreen(loginViewModel: LoginViewModel) {
    val context = LocalContext.current
    Column() {
        
    }
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        var username by remember { mutableStateOf("") }
//        OutlinedTextField(
//            value = username,
//            onValueChange = { newUsername -> username = newUsername })
//        var password by remember { mutableStateOf("") }
//        OutlinedTextField(
//            value = password,
//            onValueChange = { newPassword -> password = newPassword },
//            visualTransformation = PasswordVisualTransformation(),
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
//        )
//        Button(onClick = {
//            loginViewModel.login(username, password)
//            if (loginViewModel.isAuthenticated.value) {
//                if (loginViewModel.user.value!!.isSuperuser) {
//                    val intent = Intent(context, AdminActivity::class.java)
//                    context.startActivity(intent)
//                } else if (loginViewModel.user.value!!.isStaff) {
//                    val intent = Intent(context, StaffActivity::class.java)
//                    context.startActivity(intent)
//                } else {
//                    val intent = Intent(context, ClientActivity::class.java)
//                    context.startActivity(intent)
//                }
//            } else {
//                val toast = Toast.makeText(
//                    context,
//                    "Error happened ${loginViewModel.errorMessage}",
//                    Toast.LENGTH_SHORT
//                )
//                toast.show()
//            }
//        }) {
//            Text("Login")
//        }
//    }
}