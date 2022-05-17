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
import ru.procourt.dto.User

interface AddParticipantsToGroupChatListener {
    fun onChoose(user: User)
}

class AddParticipantsToGroupChatAdapter(private val groupChatListener: AddParticipantsToGroupChatListener) :
    ListAdapter<User, AddParticipsntaToGroupChatViewHolder>(AddParticipsntaToGroupChatDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddParticipsntaToGroupChatViewHolder {
        val binding =
            OneParticipantForAddedToGroupChatBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return AddParticipsntaToGroupChatViewHolder(groupChatListener, binding)
    }

    override fun onBindViewHolder(holder: AddParticipsntaToGroupChatViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

}

class AddParticipsntaToGroupChatViewHolder(
    private val groupChatListener: AddParticipantsToGroupChatListener,
    private val binding: OneParticipantForAddedToGroupChatBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User) {

        binding.apply {
            friendName.text = user.name
            date.text = user.date

            if (user.isOnline) {
                online.visibility = View.VISIBLE
                date.visibility = View.GONE
            } else {
                online.visibility = View.GONE
                date.visibility = View.VISIBLE
            }

        }

    }
}

class AddParticipsntaToGroupChatDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.userId == newItem.userId
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}