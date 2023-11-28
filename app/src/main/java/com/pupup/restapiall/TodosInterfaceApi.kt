package com.pupup.restapiall

import retrofit2.Call
import retrofit2.http.GET

interface TodosInterfaceApi {

    @GET("todos")
    fun getTotosData() : Call<List<TodosModel>>
}