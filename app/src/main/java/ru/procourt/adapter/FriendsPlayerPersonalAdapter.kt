package ru.procourt.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.procourt.R
import ru.procourt.databinding.*
import ru.procourt.dto.News
import ru.procourt.dto.Player
import ru.procourt.fragment.player.CardFriendPlayerPersonalFragment

interface FriendsPlayerPersonalListener {
    fun onWrite(player: Player)

}

class FriendsPlayerPersonalAdapter(private val listener: FriendsPlayerPersonalListener) :
    ListAdapter<Player, FriendsPlayerPersonalViewHolder>(FriendsPlayerPersonalDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsPlayerPersonalViewHolder {
        val binding =
            FragmentCardFriendPlayerPersonalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return FriendsPlayerPersonalViewHolder(listener, binding)
    }

    override fun onBindViewHolder(holder: FriendsPlayerPersonalViewHolder, position: Int) {
        val player = getItem(position)
        holder.bind(player)
    }

}

class FriendsPlayerPersonalViewHolder(
    private val listener: FriendsPlayerPersonalListener,
    private val binding: FragmentCardFriendPlayerPersonalBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(player: Player) {

        binding.apply {
            fcfppFriendName.text = player.name

            if (player.isOnline == true) {
                fcfppOnline.visibility = View.VISIBLE
                fcfppDate.visibility = View.GONE
            } else {
                fcfppOnline.visibility = View.GONE
                fcfppDate.visibility = View.VISIBLE
            }

            fcfppWriteButton.setOnClickListener {
                listener.onWrite(player)
            }

        }

    }
}

class FriendsPlayerPersonalDiffCallback : DiffUtil.ItemCallback<Player>() {
    override fun areItemsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem == newItem
    }
}