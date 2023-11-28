package com.pupup.restapiall

data class CommentsModel(
    val postId : Int,
    val id : Int,
    val name : String,
    val email : String,
    val body : String
)
