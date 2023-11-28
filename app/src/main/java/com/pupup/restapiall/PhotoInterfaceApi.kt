package com.pupup.restapiall

import retrofit2.Call
import retrofit2.http.GET

interface PhotoInterfaceApi {
    @GET("photos")
    fun getPhotoData() : Call<List<PhotosModel>>
}