package ru.procourt.adapter

import android.animation.ObjectAnimator
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
import ru.procourt.databinding.FragmentCardPlayerForPlayersClubBinding
import ru.procourt.databinding.FragmentCardPlayerSearchBinding
import ru.procourt.dto.News
import ru.procourt.dto.Player

interface ClubPlayerListSeparateListener {
    fun onChooseTime(player: Player)
}

class ClubPlayerListSeparateAdapter(private val clubPlayerListSeparateListener: ClubPlayerListSeparateListener) :
    ListAdapter<Player, ClubPlayerListSeparateViewHolder>(ClubPlayerListSeparateDiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ClubPlayerListSeparateViewHolder {
        val binding =
            FragmentCardPlayerForPlayersClubBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ClubPlayerListSeparateViewHolder(binding, clubPlayerListSeparateListener)
    }

    override fun onBindViewHolder(holder: ClubPlayerListSeparateViewHolder, position: Int) {
        val player = getItem(position)
        holder.bind(player)
    }

}

class ClubPlayerListSeparateViewHolder(
    private val binding: FragmentCardPlayerForPlayersClubBinding,
    private val clubPlayerListSeparateListener: ClubPlayerListSeparateListener,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(player: Player) {

        binding.apply {
            fcpfpcPlayerName.text = player.name
            fcpfpcPlayerRank.text = player.rank

            fcpfpcChooseTime.setOnClickListener {
                clubPlayerListSeparateListener.onChooseTime(player)
            }

        }

    }
}

class ClubPlayerListSeparateDiffCallback : DiffUtil.ItemCallback<Player>() {
    override fun areItemsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem == newItem
    }
}