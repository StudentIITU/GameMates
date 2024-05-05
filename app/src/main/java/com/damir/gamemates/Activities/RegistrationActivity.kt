package com.damir.gamemates.Activities

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.damir.gamemates.R
import com.damir.gamemates.fragments.LoadingDialog
//import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth


class RegistrationActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var loadingDialog: LoadingDialog

//    private lateinit var gso: GoogleSignInOptions







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_page)

        auth = FirebaseAuth.getInstance()
        loadingDialog = LoadingDialog(this)




        // Add your logic to handle UI elements and registration here
        val continueButton: Button = findViewById(R.id.registration_continue_button)
        val emailInput: EditText = findViewById(R.id.registration_email_input)
        val passwordInput: EditText = findViewById(R.id.registration_password_input)

        // Add this part for the "Log in" TextView
        val LoginTextView: TextView = findViewById(R.id.log_in_text)
        LoginTextView.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        //Instagram button function (Not created yet)
        val instagramButton: ImageButton = findViewById(R.id.instagram_icon_registration)

        instagramButton.setOnClickListener {
            Toast.makeText(this, "Instagram integration coming soon!", Toast.LENGTH_SHORT).show()
        }

        //Google button function (Not created yet)
        val googleButton: ImageButton = findViewById(R.id.google_icon_registration)

        googleButton.setOnClickListener {
            Toast.makeText(this, "Google integration coming soon!", Toast.LENGTH_SHORT).show()

        }

        //Apple button function (Not implemented yet)
        val appleButton: ImageButton = findViewById(R.id.registration_icon_apple)

        appleButton.setOnClickListener {
            Toast.makeText(this, "Apple integration coming soon!", Toast.LENGTH_SHORT).show()
        }

        continueButton.setOnClickListener {

            // ... (Your existing code for validation and Firebase registration) ...
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            if (validateInput(email, password)) {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        // Registration successful, navigate to LoginActivity
                        loadingDialog.StartingLoadingAnimation()
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this,"Empty fields are not allowed", Toast.LENGTH_SHORT).show()
            }


        }





    }



    //Logic to check if the input is empty or not
    private fun validateInput(email: String, password: String): Boolean {
        if (email.isEmpty()) {
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
            return false
        }

        if (password.isEmpty()) {
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }





}

