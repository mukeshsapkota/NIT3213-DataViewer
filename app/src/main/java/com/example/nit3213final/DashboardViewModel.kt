package com.example.nit3213final

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardViewModel : ViewModel(), KoinComponent {

    private val apiService: ApiService by inject()

    private val _data = MutableLiveData<List<Entity>>()
    val data: LiveData<List<Entity>> = _data

    fun loadData(keypass: String) {

        apiService.getHome(keypass)
            .enqueue(object : Callback<Map<String, Any>> {

                override fun onResponse(
                    call: Call<Map<String, Any>>,
                    response: Response<Map<String, Any>>
                ) {
                    if (response.isSuccessful) {

                        // 👉 Using sample data (same as before)
                        val list = listOf(
                            Entity("Item 1", "Type A", "Description 1"),
                            Entity("Item 2", "Type B", "Description 2"),
                            Entity("Item 3", "Type C", "Description 3")
                        )

                        _data.value = list
                    }
                }

                override fun onFailure(call: Call<Map<String, Any>>, t: Throwable) {
                }
            })
    }
}