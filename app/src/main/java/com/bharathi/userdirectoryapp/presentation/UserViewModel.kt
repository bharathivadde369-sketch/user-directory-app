package com.bharathi.userdirectoryapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bharathi.userdirectoryapp.data.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserViewModel(
    private val repository: UserRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(UserUiState())
    val uiState = _uiState.asStateFlow()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            _uiState.value = UserUiState(isLoading = true)

            try {
                val users = repository.getUsers()
                _uiState.value = UserUiState(users = users)
            } catch (e: Exception) {
                _uiState.value =
                    UserUiState(error = e.message ?: "Something went wrong")
            }
        }
    }
}