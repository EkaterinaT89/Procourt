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
import ru.procourt.databinding.FriendsForListGroupChatBinding
import ru.procourt.dto.News
import ru.procourt.dto.Player

interface CreateGroupChatListener {
    fun onWrite(player: Player)
}

class CreateGroupChatAdapter(private val createGroupChatListener: CreateGroupChatListener) :
    ListAdapter<Player, CreateGroupChatViewHolder>(CreateGroupChatDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreateGroupChatViewHolder {
        val binding =
            FriendsForListGroupChatBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return CreateGroupChatViewHolder(createGroupChatListener, binding)
    }

    override fun onBindViewHolder(holder: CreateGroupChatViewHolder, position: Int) {
        val player = getItem(position)
        holder.bind(player)
    }

}

class CreateGroupChatViewHolder(
    private val createGroupChatListener: CreateGroupChatListener,
    private val binding: FriendsForListGroupChatBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(player: Player) {

        binding.apply {
            friendName.text = player.name

            if (player.isOnline == true) {
                online.visibility = View.VISIBLE
                date.visibility = View.GONE
            } else {
                online.visibility = View.GONE
                date.visibility = View.VISIBLE
            }

            write.setOnClickListener {
                createGroupChatListener.onWrite(player)
            }

        }

    }
}

class CreateGroupChatDiffCallback : DiffUtil.ItemCallback<Player>() {
    override fun areItemsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem == newItem
    }
}