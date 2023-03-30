package com.mullatoes.retrofit2

import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/users")
    suspend fun getAllUsers(): User
}