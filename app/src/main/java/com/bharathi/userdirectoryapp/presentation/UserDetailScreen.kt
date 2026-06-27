package com.bharathi.userdirectoryapp.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bharathi.userdirectoryapp.data.User



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetailScreen( user: User,
                      onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("User Details") },
                navigationIcon = {
                    IconButton(onClick = { onBackClick() }) {
                        Text("←")
                    }
                }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            modifier = Modifier.size(72.dp),
                            shape = CircleShape
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = user.name.first().toString(),
                                    style = MaterialTheme.typography.headlineLarge
                                )
                            }
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        Column {
                            Text(
                                text = user.name,
                                style = MaterialTheme.typography.headlineSmall
                            )
                            Text(text = user.company)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            DetailRow("Email", user.email)
            DetailRow("Phone", user.phone)
            DetailRow("Website", user.website)
            DetailRow("Company", user.company)
        }
    }
}
@Composable
fun DetailRow(title: String, value: String?) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        elevation = CardDefaults.cardElevation(3.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.labelMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text =  value ?: "N/A",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}