package com.damir.gamemates.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.damir.gamemates.R
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import android.app.ActivityOptions
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.damir.gamemates.adapters.GameAdapter
import com.damir.gamemates.datas.Game
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import me.ibrahimsn.lib.SmoothBottomBar


class MainActivity : ComponentActivity() {

    private lateinit var googleSignInClient: GoogleSignInClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_page)

        val gamesList = listOf(
            Game(1, "Dota2", R.drawable.dota),
            Game(2, "Cs2", R.drawable.cs2),
            Game(3, "Valorant", R.drawable.valo),
            Game(4, "The finals", R.drawable.the_finals),
            Game(5, "Terraria", R.drawable.terraria),
            Game(6, "Minecraft", R.drawable.minecraft),
            Game(7, "Apex", R.drawable.apex)
            // ... Add more games
        )

        val adapter = GameAdapter(gamesList)
        val gamesRecyclerView = findViewById<RecyclerView>(R.id.games_recycler_view)
        gamesRecyclerView.adapter = adapter
        gamesRecyclerView.layoutManager = LinearLayoutManager(this) // Or any other layout manager




        val signOutButton: Button = findViewById(R.id.sign_out_button)
        signOutButton.setOnClickListener {
            // Implement sign-out logic here (e.g., using Firebase Auth)
            Firebase.auth.signOut()

            // Create intent for the new activity (e.g., LoginActivity)
            val intent = Intent(this, LoginActivity::class.java)

            // Create ActivityOptions for transition animation
            val options = ActivityOptions.makeSceneTransitionAnimation(this)

            // Start the new activity with options
            startActivity(intent, options.toBundle())
        }

        //BottomTab
        val bottomBar:SmoothBottomBar = findViewById(R.id.bottomBar)

    }


//

}



