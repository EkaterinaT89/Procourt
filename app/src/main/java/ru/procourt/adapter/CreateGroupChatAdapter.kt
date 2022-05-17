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
import ru.procourt.dto.User

interface CreateGroupChatListener {
    fun onWrite(user: User)
}

class CreateGroupChatAdapter(private val createGroupChatListener: CreateGroupChatListener) :
    ListAdapter<User, CreateGroupChatViewHolder>(CreateGroupChatDiffCallback()) {

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
        val user = getItem(position)
        holder.bind(user)
    }

}

class CreateGroupChatViewHolder(
    private val createGroupChatListener: CreateGroupChatListener,
    private val binding: FriendsForListGroupChatBinding
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
                createGroupChatListener.onWrite(user)
            }

        }

    }
}

class CreateGroupChatDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.userId == newItem.userId
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}