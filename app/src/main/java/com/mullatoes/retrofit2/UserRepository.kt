package com.mullatoes.retrofit2

import retrofit2.Response

class UserRepository(
    private val apiInterface: ApiInterface
) {
    suspend fun getAllUsers(): User {
        return apiInterface.getAllUsers()
    }
}