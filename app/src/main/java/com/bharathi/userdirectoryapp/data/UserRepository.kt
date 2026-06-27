package com.bharathi.userdirectoryapp.data


import com.bharathi.userdirectoryapp.network.UserApi

class UserRepository(
    private val api: UserApi
) {
    suspend fun getUsers(): List<User> {
        return api.getUsers()
    }
}