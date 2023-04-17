package com.example.afinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.afinal.ui.theme.FinalTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.afinal.data.models.user.UserLogin
import com.example.afinal.data.retrofit.RetrofitHelper
import com.example.afinal.data.retrofit.services.LoginService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Column() {
        var username by remember { mutableStateOf("") }
        TextField(value = username, onValueChange = { it -> username = it })
        var password by remember { mutableStateOf("") }
        TextField(value = password, onValueChange = { it -> password = it })
        Button(onClick = {
            GlobalScope.launch {
                try {

                    print(
                        RetrofitHelper.getInstance().create(LoginService::class.java)
                            .login(userLogin = UserLogin(username, password))
                    )
                } catch (e: Exception) {
                    println(e)
                }
            }
        }){}
    }
}

