package com.bharathi.userdirectoryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.bharathi.userdirectoryapp.data.User
import com.bharathi.userdirectoryapp.data.UserRepository
import com.bharathi.userdirectoryapp.network.RetrofitInstance
import com.bharathi.userdirectoryapp.presentation.UserDetailScreen
import com.bharathi.userdirectoryapp.presentation.UserListScreen
import com.bharathi.userdirectoryapp.presentation.UserViewModel
import androidx.activity.compose.BackHandler

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = UserRepository(RetrofitInstance.api)
        val viewModel = UserViewModel(repository)

        setContent {
            var selectedUser by remember { mutableStateOf<User?>(null) }

            BackHandler(enabled = selectedUser != null) {
                selectedUser = null
            }

            if (selectedUser == null) {
                UserListScreen(
                    viewModel = viewModel,
                    onUserClick = { user ->
                        selectedUser = user
                    }
                )
            } else {
                UserDetailScreen(
                    user = selectedUser!!,
                    onBackClick = {
                        selectedUser = null
                    }
                )
            }
        }
    }
}