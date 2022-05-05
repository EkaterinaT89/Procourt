package ru.procourt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.procourt.R
import ru.procourt.databinding.FragmentCardPlayerSearchBinding
import ru.procourt.databinding.OneClubForPartnerListBinding
import ru.procourt.databinding.OneMessageForListBinding
import ru.procourt.dto.Club
import ru.procourt.dto.Message
import ru.procourt.dto.Player

interface MessageListener {
    fun onExpandMesssage(message: Message)
}

class MessageAdapter(private val messageListener: MessageListener) :
    ListAdapter<Message, MessageSearchViewHolder>(MessageSearchDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageSearchViewHolder {
        val binding =
            OneMessageForListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MessageSearchViewHolder(messageListener, binding)
    }

    override fun onBindViewHolder(holder: MessageSearchViewHolder, position: Int) {
        val message = getItem(position)
        holder.bind(message)
    }

}

class MessageSearchViewHolder(
    private val messageListener: MessageListener,
    private val binding: OneMessageForListBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(message: Message) {
        binding.apply {
            authorName.text = message.senderName
            messageTime.text = message.date
            contentMessage.text = message.content

            fullMessageButton.setOnClickListener {
                messageListener.onExpandMesssage(message)
            }

        }
    }
}

class MessageSearchDiffCallback : DiffUtil.ItemCallback<Message>() {
    override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean {
        return oldItem == newItem
    }
}