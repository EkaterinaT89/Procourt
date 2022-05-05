package ru.procourt.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.procourt.R
import ru.procourt.databinding.FragmentCardNewsBinding
import ru.procourt.databinding.FragmentCardParticipantsTournamentBinding
import ru.procourt.databinding.FragmentCardPlayerSearchBinding
import ru.procourt.dto.News
import ru.procourt.dto.Player

class TournamentPartsAdapter() :
    ListAdapter<Player, TournamentPartsViewHolder>(TournamentPartsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TournamentPartsViewHolder {
        val binding =
            FragmentCardParticipantsTournamentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return TournamentPartsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TournamentPartsViewHolder, position: Int) {
        val player = getItem(position)
        holder.bind(player)
    }

}

class TournamentPartsViewHolder(
    private val binding: FragmentCardParticipantsTournamentBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(player: Player) {

        binding.apply {
            playerName.text = player.name
            playerRank.text = player.rank
            playerPrice.text = "1 место"
        }

    }
}

class TournamentPartsDiffCallback : DiffUtil.ItemCallback<Player>() {
    override fun areItemsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem == newItem
    }
}