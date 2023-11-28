package com.pupup.restapiall

import retrofit2.Call
import retrofit2.http.GET

interface AlbumInterfaceApi {
    @GET("albums")
    fun getAlubmData() : Call<List<AlbumsModel>>
}