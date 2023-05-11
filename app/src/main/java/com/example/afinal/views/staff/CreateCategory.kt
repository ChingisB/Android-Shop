package com.example.afinal.views.staff

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.afinal.data.models.product.Category
import com.example.afinal.viewmodels.CategoryViewModel
import kotlinx.coroutines.launch

@Composable
fun CreateCategory(categoryViewModel: CategoryViewModel, navController: NavController) {
    var categoryName by remember { mutableStateOf("")}
    var categoryDescription by remember { mutableStateOf("")}
    val coroutineScope = rememberCoroutineScope()

    LazyColumn(modifier = Modifier.fillMaxSize().padding(20.dp)){
        item{
            OutlinedTextField(
                value = categoryName,
                onValueChange = {
                if(it.length<=30){
                    categoryName = it
                }
                                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(45, 155, 240),
                    unfocusedBorderColor = Color.LightGray,
                    placeholderColor = Color.Gray,
                    cursorColor = Color(45, 155, 240),
                ),
                maxLines = 1,
                label = {Text("Category name")},
            )
            OutlinedTextField(
                value = categoryDescription,
                onValueChange = { categoryDescription = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(45, 155, 240),
                    unfocusedBorderColor = Color.LightGray,
                    placeholderColor = Color.Gray,
                    cursorColor = Color(45, 155, 240),
                ),
                label = {Text("Category description")},
            )
            Button(
                onClick = {
                    coroutineScope.launch {
                        categoryViewModel.createCategory(Category(categoryName,categoryDescription))
                    }
                    navController.navigate("CategoryList")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 25.dp),
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(45, 155, 240))
            ) {
                Text(
                    text = "Create Category",
                    modifier = Modifier.padding(5.dp),
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
        }
    }
}