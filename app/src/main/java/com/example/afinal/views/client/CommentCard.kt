package com.example.afinal.views.client

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.afinal.data.models.product.Comment

@Composable
fun CommentCard(comment: Comment){
    Card(modifier = Modifier.fillMaxWidth()){
        Column() {
            Text(comment.user.username)
            Text(comment.text)
        }
    }
}