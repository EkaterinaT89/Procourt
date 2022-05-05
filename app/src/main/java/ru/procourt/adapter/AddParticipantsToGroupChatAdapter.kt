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

interface AddParticipsntaToGroupChatListener {
    fun onChoose(player: Player)
}

class AddParticipsntaToGroupChatAdapter(private val groupChatListener: AddParticipsntaToGroupChatListener) :
    ListAdapter<Player, AddParticipsntaToGroupChatViewHolder>(AddParticipsntaToGroupChatDiffCallback()) {

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
        val player = getItem(position)
        holder.bind(player)
    }

}

class AddParticipsntaToGroupChatViewHolder(
    private val groupChatListener: AddParticipsntaToGroupChatListener,
    private val binding: OneParticipantForAddedToGroupChatBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(player: Player) {

        binding.apply {
            friendName.text = player.name
            date.text = player.date

            if (player.isOnline == true) {
                online.visibility = View.VISIBLE
                date.visibility = View.GONE
            } else {
                online.visibility = View.GONE
                date.visibility = View.VISIBLE
            }

        }

    }
}

class AddParticipsntaToGroupChatDiffCallback : DiffUtil.ItemCallback<Player>() {
    override fun areItemsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem == newItem
    }
}