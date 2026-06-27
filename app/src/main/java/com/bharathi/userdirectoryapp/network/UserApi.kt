package com.bharathi.userdirectoryapp.network

import com.bharathi.userdirectoryapp.data.User
import retrofit2.http.GET

interface UserApi {

    @GET("users")
    suspend fun getUsers(): List<User>
}