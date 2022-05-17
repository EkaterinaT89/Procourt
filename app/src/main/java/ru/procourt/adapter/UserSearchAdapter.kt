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
import ru.procourt.dto.News
import ru.procourt.dto.Player
import ru.procourt.dto.User

interface UserSearchListener {
    fun onChooseTime(user: User)
}

class UserSearchAdapter(private val playerSearchListener: UserSearchListener) :
    ListAdapter<User, UserSearchViewHolder>(PlayerSearchDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserSearchViewHolder {
        val binding =
            FragmentCardPlayerSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserSearchViewHolder(binding, playerSearchListener)
    }

    override fun onBindViewHolder(holder: UserSearchViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

}

class UserSearchViewHolder(
    private val binding: FragmentCardPlayerSearchBinding,
    private val playerSearchListener: UserSearchListener,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User) {

        binding.apply {
            fcpsPlayerName.text = user.name
            fcpsPlayerRank.text = user.level

            fcpsChoosePlayerTimeButton.setOnClickListener {
                playerSearchListener.onChooseTime(user)
            }

            }

        }
    }

class PlayerSearchDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.userId == newItem.userId
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}