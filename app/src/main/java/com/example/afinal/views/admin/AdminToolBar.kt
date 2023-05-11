package com.example.afinal.views.admin

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.afinal.LoginActivity

@Composable
fun AdminToolBar() {
    val context = LocalContext.current
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 45.dp)

    ) {

        Text(text = "Admin Mode", color = Color.White, modifier = Modifier.padding(start = 100.dp))

        IconButton(onClick = {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }, modifier = Modifier.padding(end = 5.dp)) {
            Icon(
                imageVector = Icons.Filled.ExitToApp,
                contentDescription = "Exit",
                tint = Color.White
            )
        }
    }
}

@Preview
@Composable
fun AdminTB() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 45.dp)

    ) {

        Text(text = "Admin Mode", color = Color.White, modifier = Modifier.padding(start = 150.dp))

        IconButton(onClick = { }, modifier = Modifier.padding(end = 5.dp)) {
            Icon(
                imageVector = Icons.Filled.ExitToApp,
                contentDescription = "Exit",
                tint = Color.White
            )
        }


    }
}