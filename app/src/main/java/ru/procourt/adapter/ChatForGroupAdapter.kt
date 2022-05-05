package ru.procourt.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.procourt.R
import ru.procourt.databinding.CardSentDateBinding
import ru.procourt.databinding.FragmentCardOneMessageForChatBinding
import ru.procourt.databinding.FragmentCardPlayerSearchBinding
import ru.procourt.databinding.OneClubForPartnerListBinding
import ru.procourt.dto.*

//отображается один список (вертикальный) с двумя тиами объектов.
class ChatForGroupAdapter() :
    ListAdapter<Chat, RecyclerView.ViewHolder>(ChatForGroupDiffCallback()) {

    private val typeDate = 0
    private val typeMessage = 1

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is SentDate -> typeDate
            is Message -> typeMessage
            null -> throw IllegalArgumentException("unknown item type")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            typeDate -> DateChatViewHolder(
                CardSentDateBinding.inflate(layoutInflater, parent, false)
            )
            typeMessage -> MessageChatViewHolder(
                FragmentCardOneMessageForChatBinding.inflate(layoutInflater, parent, false)
            )
            else -> throw IllegalArgumentException("unknown view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = getItem(position)) {
            is SentDate -> (holder as DateChatViewHolder).bind(item)
            is Message -> (holder as MessageChatViewHolder).bind(item)
            null -> error("unknown view type: $item")
        }
    }

}

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
//class DateChatViewHolder(
//    private val binding: CardSentDateBinding
//) : RecyclerView.ViewHolder(binding.root) {
//
//    fun bind(date: SentDate) {
//        binding.apply {
//            whenSent.text = date.whenSent
//        }
//    }
//}

class ChatForGroupDiffCallback : DiffUtil.ItemCallback<Chat>() {
    override fun areItemsTheSame(oldItem: Chat, newItem: Chat): Boolean {
        if (oldItem::class != newItem::class) {
            return false
        }

        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Chat, newItem: Chat): Boolean {
        return oldItem == newItem
    }
}