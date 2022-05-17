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
import ru.procourt.dto.User

interface GroupChatListener {
    fun onWrite(user: User)
    fun onDelete(user: User)
}

class GroupChatAdapter(private val groupChatListener: GroupChatListener) :
    ListAdapter<User, GroupChatViewHolder>(GroupChatDiffCallback()) {

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
        val user = getItem(position)
        holder.bind(user)
    }

}

class GroupChatViewHolder(
    private val groupChatListener: GroupChatListener,
    private val binding: CardFriendForGroupChatBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User) {

        binding.apply {
            friendName.text = user.name

            if (user.isOnline) {
                online.visibility = View.VISIBLE
                date.visibility = View.GONE
            } else {
                online.visibility = View.GONE
                date.visibility = View.VISIBLE
            }

            write.setOnClickListener {
                groupChatListener.onWrite(user)
            }
            deleteGroupChatPart.setOnClickListener {
                groupChatListener.onDelete(user)
            }

        }

    }
}

class GroupChatDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.userId == newItem.userId
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}