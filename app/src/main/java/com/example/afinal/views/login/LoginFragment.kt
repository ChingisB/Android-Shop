package com.example.afinal.views.login

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.afinal.viewmodels.LoginViewModel

@Composable
fun LoginFragment(navController: NavController, loginViewModel: LoginViewModel) {
    var username by remember { mutableStateOf("") }
    Column(modifier = Modifier
        .fillMaxWidth().padding(horizontal = 30.dp)
    ) {
        Text(text = "email", color = Color.Gray, fontSize = 18.sp, modifier = Modifier.padding(vertical = 15.dp))
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            placeholder = { Text("Your username") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.LightGray
            )
        )
    }
//    Text(text = "SignUp", Modifier.clickable(onClick = {navController.navigate("SignUp")}))
}