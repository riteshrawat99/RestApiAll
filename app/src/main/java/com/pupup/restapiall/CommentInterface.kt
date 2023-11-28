package com.pupup.restapiall

import retrofit2.Call
import retrofit2.http.GET


interface CommentInterface {

    @GET("comments")
    fun getData() : Call<List<CommentsModel>>
}