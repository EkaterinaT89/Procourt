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
import ru.procourt.fragment.player.CardFriendPlayerPersonalFragment

interface FriendsUserPersonalListener {
    fun onWrite(user: User)

}

class FriendsPlayerPersonalAdapter(private val listener: FriendsUserPersonalListener) :
    ListAdapter<User, FriendsUserPersonalViewHolder>(FriendsUserPersonalDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsUserPersonalViewHolder {
        val binding =
            FragmentCardFriendPlayerPersonalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return FriendsUserPersonalViewHolder(listener, binding)
    }

    override fun onBindViewHolder(holder: FriendsUserPersonalViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

}

class FriendsUserPersonalViewHolder(
    private val listener: FriendsUserPersonalListener,
    private val binding: FragmentCardFriendPlayerPersonalBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User) {

        binding.apply {
            fcfppFriendName.text = user.name

            if (user.isOnline) {
                fcfppOnline.visibility = View.VISIBLE
                fcfppDate.visibility = View.GONE
            } else {
                fcfppOnline.visibility = View.GONE
                fcfppDate.visibility = View.VISIBLE
            }

            fcfppWriteButton.setOnClickListener {
                listener.onWrite(user)
            }

        }

    }
}

class FriendsUserPersonalDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.userId == newItem.userId
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}