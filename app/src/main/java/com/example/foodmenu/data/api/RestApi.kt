package com.example.foodmenu.data.api

import com.example.foodmenu.data.entities.MenuData
import retrofit2.Call
import retrofit2.http.*

interface RestApi {
    @Headers("Content-Type: application/json")
    @GET("burgers")
    fun getUser(): Call<List<MenuData>>

}
