package com.example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.Chain_of_Responsibility.Demo_CoR

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        // Run test
        // Admin account
        Demo_CoR().runDemo("admin@example.com", "admin_pass")
        // User account
        Demo_CoR().runDemo("user@example.com", "user_pass")
        // Invalid account
        Demo_CoR().runDemo("abc@example.com", "user_pass")
        Demo_CoR().runDemo("admin@example.com", "123")
    }
}
