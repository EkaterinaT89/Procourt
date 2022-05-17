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
import ru.procourt.databinding.FragmentCardPlayerClubBinding
import ru.procourt.databinding.FragmentCardPlayerSearchBinding
import ru.procourt.dto.News
import ru.procourt.dto.Player
import ru.procourt.dto.User

interface ClubPlayerListener {
    fun onChooseTime(user: User)
}

class ClubPlayerAdapter(private val clubPlayerListener: ClubPlayerListener) :
    ListAdapter<User, ClubPlayerViewHolder>(ClubPlayerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubPlayerViewHolder {
        val binding =
            FragmentCardPlayerClubBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClubPlayerViewHolder(binding, clubPlayerListener)
    }

    override fun onBindViewHolder(holder: ClubPlayerViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

}

class ClubPlayerViewHolder(
    private val binding: FragmentCardPlayerClubBinding,
    private val clubPlayerListener: ClubPlayerListener,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User) {

        binding.apply {
            fcpcPlayerName.text = user.name
            fcpcPlayerRank.text = user.level

            fcpcChoosePlayerTimeButton.setOnClickListener {
                clubPlayerListener.onChooseTime(user)
            }

            }

        }
    }

class ClubPlayerDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.userId == newItem.userId
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}