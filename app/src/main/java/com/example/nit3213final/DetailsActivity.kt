package com.example.nit3213final

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // 🔥 SET TOOLBAR
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val title = findViewById<TextView>(R.id.title)
        val type = findViewById<TextView>(R.id.type)
        val desc = findViewById<TextView>(R.id.description)

        title.text = intent.getStringExtra("title")
        type.text = intent.getStringExtra("type")
        desc.text = intent.getStringExtra("desc")
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}