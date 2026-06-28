package com.bharathi.userdirectoryapp

import com.bharathi.userdirectoryapp.data.User
import com.bharathi.userdirectoryapp.data.UserRepository
import com.bharathi.userdirectoryapp.presentation.UserViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class UserViewModelTest {

    private val repository = mockk<UserRepository>()

    @Test
    fun `fetchUsers updates ui state with users`() = runTest {

        val users = listOf(
            User(1, "Bharathi", "bharathi@gmail.com", "ANZ", "99999999", "anz.com")
        )

        coEvery { repository.getUsers() } returns users

        val viewModel = UserViewModel(repository)

        assertEquals(1, viewModel.uiState.value.users.size)
        assertEquals("Bharathi", viewModel.uiState.value.users[0].name)
    }
}