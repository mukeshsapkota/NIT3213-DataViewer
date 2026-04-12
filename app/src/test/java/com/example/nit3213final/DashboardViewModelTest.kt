package com.example.nit3213final

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class DashboardViewModelTest {

    // 🔥 Makes LiveData work in unit test
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun testLoadDataReturnsList() {

        val viewModel = DashboardViewModel()

        // Call function
        viewModel.loadData("test_key")

        // Since we use sample data, directly check size
        val data = viewModel.data.value

        // Check data
        assertEquals(3, data?.size)
    }
}