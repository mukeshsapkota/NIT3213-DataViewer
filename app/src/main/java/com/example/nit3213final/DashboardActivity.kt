package com.example.nit3213final

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DashboardActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: DashboardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // 🔹 Setup RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // 🔹 Get keypass from login
        val keypass = intent.getStringExtra("keypass") ?: ""

        // 🔹 Initialize ViewModel
        viewModel = ViewModelProvider(this)[DashboardViewModel::class.java]

        // 🔹 Observe data from ViewModel
        viewModel.data.observe(this) { list ->
            recyclerView.adapter = DashboardAdapter(list)
        }

        // 🔹 Load data
        viewModel.loadData(keypass)
    }
}