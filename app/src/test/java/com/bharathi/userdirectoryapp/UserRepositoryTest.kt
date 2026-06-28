package com.bharathi.userdirectoryapp

import com.bharathi.userdirectoryapp.data.User
import com.bharathi.userdirectoryapp.data.UserRepository
import com.bharathi.userdirectoryapp.network.UserApi
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class UserRepositoryTest {

    private val api = mockk<UserApi>()
    private val repository = UserRepository(api)

    @Test
    fun `getUsers returns user list`() = runBlocking {
        val users = listOf(
            User(1, "Bharathi", "bharathi@gmail.com", "ANZ", "999999999", "anz.com")
        )

        coEvery { api.getUsers() } returns users

        val result = repository.getUsers()

        assertEquals(1, result.size)
        assertEquals("Bharathi", result[0].name)
    }
}