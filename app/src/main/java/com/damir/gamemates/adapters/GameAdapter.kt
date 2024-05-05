package com.damir.gamemates.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.damir.gamemates.R
import com.damir.gamemates.datas.Game

class GameAdapter(private val gamesList: List<Game>):
        RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gameImage: ImageView = itemView.findViewById(R.id.game_image) // Assuming you have an ImageView with this ID in your item layout
        val gameName: TextView = itemView.findViewById(R.id.game_name) // Assuming you have a TextView with this ID
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        return GameViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = gamesList[position]
        holder.gameName.text = game.name

        // Load the image using Glide, Picasso, or another image loading library
        Glide.with(holder.itemView.context)
            .load(game.imageResId) // Use the correct property name
            .placeholder(R.drawable.placeholder) // Optional: Placeholder image
            .error(R.drawable.error_placeholder) // Optional: Error image
            .into(holder.gameImage)
    }
    }



