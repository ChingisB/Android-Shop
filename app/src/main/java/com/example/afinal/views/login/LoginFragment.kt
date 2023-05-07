package com.example.afinal.views.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.afinal.viewmodels.LoginViewModel

@Composable
fun LoginFragment(navController: NavController, loginViewModel: LoginViewModel) {
    Column(modifier = Modifier
        .fillMaxWidth()
    ) {
        Text(text = "email", color = Color.DarkGray, fontSize = 25.sp)
    }
//    Text(text = "SignUp", Modifier.clickable(onClick = {navController.navigate("SignUp")}))
}