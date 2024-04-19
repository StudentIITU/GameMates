package com.damir.gamemates.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.damir.gamemates.R
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

// ... (imports) ...

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_page)

        val signOutButton: Button = findViewById(R.id.sign_out_button)
        signOutButton.setOnClickListener {
            // Implement sign-out logic here (e.g., using Firebase Auth)
            Firebase.auth.signOut()
            // Navigate to LoginActivity or another screen
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}



