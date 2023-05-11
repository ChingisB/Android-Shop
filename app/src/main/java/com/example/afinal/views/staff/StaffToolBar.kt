package com.example.afinal.views.staff

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.afinal.LoginActivity

@Composable
fun StaffToolBar() {
    val context = LocalContext.current
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 45.dp)
            .padding(start = 30.dp)

    ) {
        Icon(
            imageVector = Icons.Filled.ExitToApp,
            contentDescription = "Exit",
            tint = Color(45, 155, 240)
        )

        Text(text = "Staff Mode", color = Color.White)

        IconButton(onClick = {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }) {
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
fun StaffTB() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 45.dp)

    ) {
        Icon(
            imageVector = Icons.Filled.ExitToApp,
            contentDescription = "Exit",
            tint = Color(45, 155, 240)
        )

        Text(text = "Staff Mode", color = Color.White)

        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Filled.ExitToApp,
                contentDescription = "Exit",
                tint = Color.White
            )
        }
    }
}