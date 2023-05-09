package com.example.afinal.views.login

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.afinal.AdminActivity
import com.example.afinal.ClientActivity
import com.example.afinal.StaffActivity
import com.example.afinal.viewmodels.AuthenticationStatus
import com.example.afinal.viewmodels.LoginViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun LoginFragment(navController: NavController, loginViewModel: LoginViewModel) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
    ) {
        Text(
            text = "username",
            color = Color.Gray,
            fontSize = 18.sp
        )
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            placeholder = { Text("Your username") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(45, 155, 240),
                unfocusedBorderColor = Color.LightGray,
                placeholderColor = Color.Gray,
                cursorColor = Color(45, 155, 240),
            )
        )
        Text(
            text = "password",
            color = Color.Gray,
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 15.dp)
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("Your password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(45, 155, 240),
                unfocusedBorderColor = Color.LightGray,
                placeholderColor = Color.Gray,
                cursorColor = Color(45, 155, 240),
            )
        )
        Button(
            onClick = {
                coroutineScope.launch {
                    loginViewModel.login(username, password)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 25.dp),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(45, 155, 240))
        ) {
            Text(
                text = "Login",
                modifier = Modifier.padding(5.dp),
                color = Color.White,
                fontSize = 20.sp
            )
        }
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Don't have an account? ", fontSize = 20.sp)
            Text(
                text = "Sign Up",
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                fontSize = 20.sp,
                modifier = Modifier.clickable(onClick = {
                    navController.navigate("SignUp")
                })
            )
        }
        val user by loginViewModel.user.collectAsState()
        val status by loginViewModel.status.collectAsState()
        if (status == AuthenticationStatus.SUCCESS) {
            if (user!!.isSuperuser) {
                val intent = Intent(context, AdminActivity::class.java)
                context.startActivity(intent)
            } else if (user!!.isStaff) {
                val intent = Intent(context, StaffActivity::class.java)
                context.startActivity(intent)
            } else {
                val intent = Intent(context, ClientActivity::class.java)
                context.startActivity(intent)
            }
        } else if (status == AuthenticationStatus.FAIL){
            val toast = Toast.makeText(
                context,
                "Error happened ${loginViewModel.errorMessage}",
                Toast.LENGTH_SHORT
            )
            toast.show()
        }
    }
}
