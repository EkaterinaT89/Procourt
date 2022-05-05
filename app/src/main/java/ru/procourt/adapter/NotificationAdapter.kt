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
import ru.procourt.databinding.OneNotificationForListBinding
import ru.procourt.dto.Club
import ru.procourt.dto.Message
import ru.procourt.dto.Notification
import ru.procourt.dto.Player


class NotificationAdapter() :
    ListAdapter<Notification, NotificationSearchViewHolder>(NotificationSearchDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationSearchViewHolder {
        val binding =
            OneNotificationForListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotificationSearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotificationSearchViewHolder, position: Int) {
        val notification = getItem(position)
        holder.bind(notification)
    }
}

class NotificationSearchViewHolder(
    private val binding: OneNotificationForListBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(notification: Notification) {
        binding.apply {
            authorName.text = notification.senderName
            notificationTime.text = notification.date
            notificationContent.text = notification.content
        }
    }
}

class NotificationSearchDiffCallback : DiffUtil.ItemCallback<Notification>() {
    override fun areItemsTheSame(oldItem: Notification, newItem: Notification): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Notification, newItem: Notification): Boolean {
        return oldItem == newItem
    }
}