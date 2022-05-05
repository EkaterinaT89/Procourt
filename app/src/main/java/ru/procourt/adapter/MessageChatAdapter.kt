package ru.procourt.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.procourt.R
import ru.procourt.databinding.FragmentCardOneMessageForChatBinding
import ru.procourt.databinding.FragmentTournamentAdultCardSearchBinding
import ru.procourt.databinding.OneClubForPartnerListBinding
import ru.procourt.dto.Club
import ru.procourt.dto.Message
import ru.procourt.dto.Player
import ru.procourt.dto.Tournament

//class MessageChatAdapter:
//    ListAdapter<Message, MessageChatViewHolder>(MessageChatDiffCallback()) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageChatViewHolder {
//        val binding =
//            FragmentCardOneMessageForChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return MessageChatViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: MessageChatViewHolder, position: Int) {
//        val message = getItem(position)
//        holder.bind(message)
//    }
//
//}
//
//class MessageChatViewHolder(
//    private val binding: FragmentCardOneMessageForChatBinding
//) : RecyclerView.ViewHolder(binding.root) {
//
//    fun bind(message: Message) {
//        binding.apply {
//            fcomcAmContentMessage.text = message.content
//            fcomcMmContentMessage.text = message.content
//            fcomcAmMessageTime.text = message.time
//            fcomcMmMessageTime.text = message.time
//
//            if(message.isMine) {
//                messageIsMineGroup.visibility = View.VISIBLE
//                messageAnotherGroup.visibility = View.GONE
//            } else {
//                messageIsMineGroup.visibility = View.GONE
//                messageAnotherGroup.visibility = View.VISIBLE
//            }
//        }
//    }
//}
//
//class MessageChatDiffCallback : DiffUtil.ItemCallback<Message>() {
//    override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean {
//        return oldItem.id == newItem.id
//    }
//
//    override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean {
//        return oldItem == newItem
//    }
//}