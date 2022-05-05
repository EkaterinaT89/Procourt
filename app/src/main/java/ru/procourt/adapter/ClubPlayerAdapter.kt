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
import ru.procourt.databinding.FragmentCardPlayerClubBinding
import ru.procourt.databinding.FragmentCardPlayerSearchBinding
import ru.procourt.dto.News
import ru.procourt.dto.Player

interface ClubPlayerListener {
    fun onChooseTime(player: Player)
}

class ClubPlayerAdapter(private val clubPlayerListener: ClubPlayerListener) :
    ListAdapter<Player, ClubPlayerViewHolder>(ClubPlayerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubPlayerViewHolder {
        val binding =
            FragmentCardPlayerClubBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClubPlayerViewHolder(binding, clubPlayerListener)
    }

    override fun onBindViewHolder(holder: ClubPlayerViewHolder, position: Int) {
        val player = getItem(position)
        holder.bind(player)
    }

}

class ClubPlayerViewHolder(
    private val binding: FragmentCardPlayerClubBinding,
    private val clubPlayerListener: ClubPlayerListener,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(player: Player) {

        binding.apply {
            fcpcPlayerName.text = player.name
            fcpcPlayerRank.text = player.rank

            fcpcChoosePlayerTimeButton.setOnClickListener {
                clubPlayerListener.onChooseTime(player)
            }

            }

        }
    }

class ClubPlayerDiffCallback : DiffUtil.ItemCallback<Player>() {
    override fun areItemsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem == newItem
    }
}