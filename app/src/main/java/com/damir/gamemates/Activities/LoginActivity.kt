package com.damir.gamemates.Activities

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.damir.gamemates.R
import com.damir.gamemates.fragments.LoadingDialog
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var loadingDialog: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)

        loadingDialog = LoadingDialog(this)
        auth = FirebaseAuth.getInstance()

        val continueButton: Button = findViewById(R.id.login_continue_button)
        val emailInput: EditText = findViewById(R.id.login_email_input)
        val passwordInput: EditText = findViewById(R.id.login_password_input)

        // Logic for the "Sign up" TextView
        val signUpTextView: TextView = findViewById(R.id.sign_up_text)
        signUpTextView.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }

        val instagramButton: ImageButton = findViewById(R.id.instagram_icon_login)

        instagramButton.setOnClickListener {
            Toast.makeText(this, "Instagram integration coming soon!", Toast.LENGTH_SHORT).show()
        }

        //Google button function (Not created yet)
        val googleButton: ImageButton = findViewById(R.id.google_icon_login)

        googleButton.setOnClickListener {
            Toast.makeText(this, "Google integration coming soon!", Toast.LENGTH_SHORT).show()

        }

        //Apple button function (Not implemented yet)
        val appleButton: ImageButton = findViewById(R.id.apple_icon_login)

        appleButton.setOnClickListener {
            Toast.makeText(this, "Apple integration coming soon!", Toast.LENGTH_SHORT).show()
        }


        // Login button logic
        continueButton.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            if (validateInput(email, password)) {

                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        loadingDialog.StartingLoadingAnimation()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                    }
                }
            } else
                Toast.makeText(this,"Empty fields are not allowed", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    //Checking if email pole is empty or not. If it occurs, a toast message will appear
    private fun validateInput(email: String, password: String): Boolean {
        if (email.isEmpty()) {
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
            return false
        }
        //Checking if password pole is empty or not. If it occurs, a toast message will appear

        if (password.isEmpty()) {
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }








}
