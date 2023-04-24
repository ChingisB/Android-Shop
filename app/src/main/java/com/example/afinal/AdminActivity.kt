package com.example.afinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.afinal.ui.theme.FinalTheme
import com.example.afinal.viewmodels.StaffViewModel
import com.example.afinal.views.CreateStaff
import com.example.afinal.views.StaffList

class AdminActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    val navController = rememberNavController()
                    val staffViewModel = viewModel<StaffViewModel>()
                    NavHost(navController = navController, startDestination = "StaffList") {
                        composable(route = "StaffList") {
                            staffViewModel.getStaff()
                            StaffList(
                                staffViewModel = staffViewModel,
                                navController = navController
                            )
                        }
                        composable(route = "CreateStaff") {
                            CreateStaff(
                                staffViewModel = staffViewModel,
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}