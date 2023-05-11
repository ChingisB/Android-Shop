package com.example.afinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.afinal.ui.theme.FinalTheme
import com.example.afinal.viewmodels.LoginViewModel
import com.example.afinal.views.login.EntranceScreen
import com.example.afinal.views.login.LoginFragment
import com.example.afinal.views.login.SignUpFragment

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    val loginViewModel = viewModel<LoginViewModel>()
                    loginViewModel.logout()
                    NavHost(navController = navController, startDestination = "Login"){
                        composable(route = "Login"){
                            EntranceScreen {
                                LoginFragment(
                                    loginViewModel = loginViewModel,
                                    navController = navController
                                )
                            }
                        }
                        composable(route = "SignUp"){
                            EntranceScreen{
                                SignUpFragment(
                                    loginViewModel = loginViewModel,
                                    navController = navController
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
