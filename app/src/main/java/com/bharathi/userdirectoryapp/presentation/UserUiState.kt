package com.bharathi.userdirectoryapp.presentation

import com.bharathi.userdirectoryapp.data.User

data class UserUiState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val error: String = ""
)