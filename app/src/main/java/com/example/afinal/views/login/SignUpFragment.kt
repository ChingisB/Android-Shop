package com.example.afinal.views.login

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat.FocusDirection
import androidx.navigation.NavController
import com.example.afinal.AdminActivity
import com.example.afinal.ClientActivity
import com.example.afinal.StaffActivity
import com.example.afinal.viewmodels.LoginViewModel
import kotlinx.coroutines.launch

@Composable
fun SignUpFragment(navController: NavController, loginViewModel: LoginViewModel) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var passwordCopy by remember { mutableStateOf("") }
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
    ) {
        Text(
            text = "email",
            color = Color.Gray,
            fontSize = 18.sp
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("Your email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(45, 155, 240),
                unfocusedBorderColor = Color.LightGray,
                placeholderColor = Color.Gray,
                cursorColor = Color(45, 155, 240),
            ),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )
        Text(
            text = "username",
            color = Color.Gray,
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 15.dp)
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
            modifier = Modifier.padding(top = 15.dp, bottom = 10.dp)
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("Your password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(45, 155, 240),
                unfocusedBorderColor = Color.LightGray,
                placeholderColor = Color.Gray,
                cursorColor = Color(45, 155, 240),
            ),
            visualTransformation = PasswordVisualTransformation()
        )
        OutlinedTextField(
            value = passwordCopy,
            onValueChange = { passwordCopy = it },
            placeholder = { Text("Your password copy") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(45, 155, 240),
                unfocusedBorderColor = Color.LightGray,
                placeholderColor = Color.Gray,
                cursorColor = Color(45, 155, 240),
            ),
            visualTransformation = PasswordVisualTransformation()
        )
        Button(
            onClick = {
                coroutineScope.launch {
                    loginViewModel.signUp(username, email, password, passwordCopy)
                    loginViewModel.user.collect() {user ->
                        try {
                            if (user!!.isSuperuser) {
                                val intent = Intent(context, AdminActivity::class.java)
                                context.startActivity(intent)
                            } else if (user.isStaff) {
                                val intent = Intent(context, StaffActivity::class.java)
                                context.startActivity(intent)
                            } else {
                                val intent = Intent(context, ClientActivity::class.java)
                                context.startActivity(intent)
                            }
                        } catch (e: Exception) {
                            val toast = Toast.makeText(
                                context,
                                "Error happened ${loginViewModel.errorMessage}",
                                Toast.LENGTH_SHORT
                            )
                            toast.show()
                        }
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(45, 155, 240))
        ) {
            Text(
                text = "Sign Up",
                modifier = Modifier.padding(5.dp),
                color = Color.White,
                fontSize = 20.sp
            )
        }
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Already have an account? ", fontSize = 20.sp)
            Text(
                text = "Log In",
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                fontSize = 20.sp,
                modifier = Modifier.clickable(onClick = {
                    navController.navigate("Login")
                })
            )
        }
    }
}