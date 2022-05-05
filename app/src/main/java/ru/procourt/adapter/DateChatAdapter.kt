package ru.procourt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.procourt.R
import ru.procourt.databinding.CardSentDateBinding
import ru.procourt.databinding.FragmentTournamentAdultCardSearchBinding
import ru.procourt.databinding.OneClubForPartnerListBinding
import ru.procourt.dto.Club
import ru.procourt.dto.Player
import ru.procourt.dto.SentDate
import ru.procourt.dto.Tournament

//class DateChatAdapter:
//    ListAdapter<SentDate, DateChatViewHolder>(DateChatDiffCallback()) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateChatViewHolder {
//        val binding =
//            CardSentDateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return DateChatViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: DateChatViewHolder, position: Int) {
//        val date = getItem(position)
//        holder.bind(date)
//    }
//
//}
//
//class DateChatViewHolder(
//    private val binding: CardSentDateBinding
//) : RecyclerView.ViewHolder(binding.root) {
//
//
//    fun bind(date: SentDate) {
//        binding.apply {
//            whenSent.text = date.whenSent
//        }
//    }
//}
//
//class DateChatDiffCallback : DiffUtil.ItemCallback<SentDate>() {
//    override fun areItemsTheSame(oldItem: SentDate, newItem: SentDate): Boolean {
//        return oldItem.id == newItem.id
//    }
//
//    override fun areContentsTheSame(oldItem: SentDate, newItem: SentDate): Boolean {
//        return oldItem == newItem
//    }
//}