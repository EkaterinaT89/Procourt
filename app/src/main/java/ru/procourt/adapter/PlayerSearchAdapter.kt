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
import ru.procourt.databinding.FragmentCardPlayerSearchBinding
import ru.procourt.dto.News
import ru.procourt.dto.Player

interface PlayerSearchListener {
    fun onChooseTime(player: Player)
}

class PlayerSearchAdapter(private val playerSearchListener: PlayerSearchListener) :
    ListAdapter<Player, PlayerSearchViewHolder>(PlayerSearchDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerSearchViewHolder {
        val binding =
            FragmentCardPlayerSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlayerSearchViewHolder(binding, playerSearchListener)
    }

    override fun onBindViewHolder(holder: PlayerSearchViewHolder, position: Int) {
        val player = getItem(position)
        holder.bind(player)
    }

}

class PlayerSearchViewHolder(
    private val binding: FragmentCardPlayerSearchBinding,
    private val playerSearchListener: PlayerSearchListener,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(player: Player) {

        binding.apply {
            fcpsPlayerName.text = player.name
            fcpsPlayerRank.text = player.rank

            fcpsChoosePlayerTimeButton.setOnClickListener {
                playerSearchListener.onChooseTime(player)
            }

            }

        }
    }

class PlayerSearchDiffCallback : DiffUtil.ItemCallback<Player>() {
    override fun areItemsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem == newItem
    }
}