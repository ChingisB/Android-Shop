package com.example.afinal.views.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.DeviceFontFamilyName
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.afinal.R
import com.example.afinal.viewmodels.LoginViewModel

@Composable
fun EntranceScreen(content: @Composable () -> Unit) {
    Column {
        Image(painter = painterResource(id = R.drawable.tyagi_logo_4), contentDescription = "logo", Modifier.fillMaxWidth())
        Box(
            Modifier
                .background(Color(220,220,220))
                .fillMaxSize(), contentAlignment = Alignment.TopCenter){
            Column{
                Text(text = "Welcome to Keftemarket", modifier = Modifier.padding(vertical = 50.dp),
                fontSize = 30.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily(Font(DeviceFontFamilyName("arial.ttf")))
                    )
                content()
            }
        }
    }
}
