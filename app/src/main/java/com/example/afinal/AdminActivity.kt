package com.example.afinal

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.afinal.ui.theme.FinalTheme
import com.example.afinal.viewmodels.StaffViewModel
import com.example.afinal.views.admin.AdminNavigation
import com.example.afinal.views.CreateStaff
import com.example.afinal.views.admin.StaffList
import com.example.afinal.views.admin.AdminToolBar

class AdminActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    val staffViewModel = viewModel<StaffViewModel>()
                    Scaffold(
                        topBar = {
                            TopAppBar() {
                                AdminToolBar()
                            }
                        }, bottomBar = {
                            BottomAppBar() {
                                AdminNavigation(navController = navController)
                            }
                        }, content = {
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
                        })
                }
            }
        }
    }
}