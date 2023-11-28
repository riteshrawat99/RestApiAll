package com.pupup.restapiall

import retrofit2.Call
import retrofit2.http.GET

interface UserInterfaceApi {

    @GET("users")
    fun getUserData() : Call<List<UserModelItemItem>>
}