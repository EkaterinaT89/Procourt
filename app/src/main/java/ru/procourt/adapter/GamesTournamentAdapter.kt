package ru.procourt.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.procourt.R
import ru.procourt.databinding.*
import ru.procourt.dto.Club
import ru.procourt.dto.Game
import ru.procourt.dto.Player
import ru.procourt.dto.Tournament

class GamesTournamentAdapter:
    ListAdapter<Game, GamesTournamentViewHolder>(GamesTournamentDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesTournamentViewHolder {
        val binding =
            FragmentCardGamesTournamentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GamesTournamentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GamesTournamentViewHolder, position: Int) {
        val game = getItem(position)
        holder.bind(game)
    }

}

class GamesTournamentViewHolder(
    private val binding: FragmentCardGamesTournamentBinding
) : RecyclerView.ViewHolder(binding.root) {


    @SuppressLint("SetTextI18n")
    fun bind(game: Game) {
        binding.apply {
            fcgppNamePlayerLeft.text = game.playerOne.name
            fcgppNamePlayerRight.text = game.playerTwo.name
            fcgppCountLeft.text = game.playeOneScore.toString()
            fcgppCountRight.text = game.playerTwoScore.toString()
            date.text = game.gameDate
        }
    }
}

class GamesTournamentDiffCallback : DiffUtil.ItemCallback<Game>() {
    override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean {
        return oldItem == newItem
    }
}