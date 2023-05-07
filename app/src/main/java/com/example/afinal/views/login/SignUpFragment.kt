package com.example.afinal.views.login

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.afinal.viewmodels.LoginViewModel

@Composable
fun SignUpFragment(navController: NavController, loginViewModel: LoginViewModel) {
    Text(text = "LogIn", Modifier.clickable(onClick = {navController.navigate("Login")}))
}