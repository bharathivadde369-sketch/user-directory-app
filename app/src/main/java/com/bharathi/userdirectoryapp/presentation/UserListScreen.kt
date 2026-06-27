package com.bharathi.userdirectoryapp.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bharathi.userdirectoryapp.data.User

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserListScreen(
    viewModel: UserViewModel,
    onUserClick: (User) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "User Directory",
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            )
        }
    ) { paddingValues ->

        when {
            uiState.isLoading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            uiState.error.isNotEmpty() -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = uiState.error)
                }
            }

            else -> {
                LazyColumn(
                    modifier = Modifier.padding(paddingValues)
                ) {
                    items(uiState.users) { user ->
                        UserItem(user, onUserClick)
                    }
                }
            }
        }
    }
}

@Composable
fun UserItem(
    user: User,
    onUserClick: (User) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .clickable { onUserClick(user) },
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Surface(
                modifier = Modifier.size(56.dp),
                shape = CircleShape,
                tonalElevation = 4.dp
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = user.name.first().toString(),
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = user.name,
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = user.email,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = user.company,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}