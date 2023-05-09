package com.example.afinal.views.client

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.afinal.viewmodels.CommentViewModel

@Composable
fun CommentList(commentViewModel: CommentViewModel){
    val comments by commentViewModel.comments.collectAsState()
    LazyColumn(){
        items(comments.size) { index ->
            comments[index]?.let { CommentCard(comment = it) }
        }
    }
}