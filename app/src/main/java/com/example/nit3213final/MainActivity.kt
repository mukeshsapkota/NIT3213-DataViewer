package com.example.nit3213final

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    // ✅ Koin Dependency Injection
    private val apiService: ApiService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 🔹 UI Elements
        val usernameField = findViewById<EditText>(R.id.username)
        val passwordField = findViewById<EditText>(R.id.password)
        val loginBtn = findViewById<Button>(R.id.loginBtn)

        // 🔹 Button Click
        loginBtn.setOnClickListener {

            val username = usernameField.text.toString()
            val password = passwordField.text.toString()

            // Basic validation
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val request = LoginRequest(username, password)

            // 🔥 API CALL
            apiService.login(request)
                .enqueue(object : Callback<LoginResponse> {

                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        if (response.isSuccessful) {

                            val keypass = response.body()?.keypass ?: ""

                            Toast.makeText(this@MainActivity, "Login Successful", Toast.LENGTH_SHORT).show()

                            // 👉 Go to Dashboard
                            val intent = Intent(this@MainActivity, DashboardActivity::class.java)
                            intent.putExtra("keypass", keypass)
                            startActivity(intent)

                        } else {
                            Toast.makeText(this@MainActivity, "Login Failed", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_LONG).show()
                    }
                })
        }
    }
}