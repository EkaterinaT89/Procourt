package ru.procourt.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.procourt.R
import ru.procourt.databinding.CardFriendForGroupChatBinding
import ru.procourt.databinding.FragmentCardNewsBinding
import ru.procourt.databinding.FragmentCardPlayerSearchBinding
import ru.procourt.databinding.FriendsForListGroupChatBinding
import ru.procourt.dto.News
import ru.procourt.dto.Player

interface GroupChatListener {
    fun onWrite(player: Player)
    fun onDelete(player: Player)
}

class GroupChatAdapter(private val groupChatListener: GroupChatListener) :
    ListAdapter<Player, GroupChatViewHolder>(GroupChatDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupChatViewHolder {
        val binding =
            CardFriendForGroupChatBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return GroupChatViewHolder(groupChatListener, binding)
    }

    override fun onBindViewHolder(holder: GroupChatViewHolder, position: Int) {
        val player = getItem(position)
        holder.bind(player)
    }

}

class GroupChatViewHolder(
    private val groupChatListener: GroupChatListener,
    private val binding: CardFriendForGroupChatBinding
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
                groupChatListener.onWrite(player)
            }
            deleteGroupChatPart.setOnClickListener {
                groupChatListener.onDelete(player)
            }

        }

    }
}

class GroupChatDiffCallback : DiffUtil.ItemCallback<Player>() {
    override fun areItemsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem == newItem
    }
}