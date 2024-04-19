//package com.damir.gamemates.adapters
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import androidx.recyclerview.widget.RecyclerView
//import com.damir.gamemates.R
//import com.damir.gamemates.datas.Game
//
//class GameAdapter(private val gamesList: List<Game>) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {
//
//    class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val gameIcon: ImageView = itemView.findViewById(R.id.game_icon)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
//        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
//        return GameViewHolder(itemView)
//    }
//
//    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
//        val currentGame = gamesList[position]
//        // Assuming you are using drawable resource IDs for icons
//        holder.gameIcon.setImageResource(currentGame.icon)
//    }
//
//    override fun getItemCount(): Int = gamesList.size
//}