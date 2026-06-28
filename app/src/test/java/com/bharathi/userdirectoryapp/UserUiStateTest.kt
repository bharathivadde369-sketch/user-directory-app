package com.bharathi.userdirectoryapp

import com.bharathi.userdirectoryapp.presentation.UserUiState
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class UserUiStateTest {

    @Test
    fun `default state should be empty`() {
        val state = UserUiState()

        assertFalse(state.isLoading)
        assertTrue(state.users.isEmpty())
        assertTrue(state.error.isEmpty())
    }
}