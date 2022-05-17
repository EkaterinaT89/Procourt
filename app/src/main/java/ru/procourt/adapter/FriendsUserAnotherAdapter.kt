package ru.procourt.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.procourt.databinding.*
import ru.procourt.dto.User

interface FriendsUserAnotherlListener {
    fun onWrite(user: User)

}

class FriendsUserAnotherAdapter(private val listener: FriendsUserAnotherlListener) :
    ListAdapter<User, FriendsUserAnotherViewHolder>(FriendsUserAnotherDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsUserAnotherViewHolder {
        val binding =
            FragmentCardFriendPlayerPersonalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return FriendsUserAnotherViewHolder(listener, binding)
    }

    override fun onBindViewHolder(holder: FriendsUserAnotherViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

}

class FriendsUserAnotherViewHolder(
    private val listener: FriendsUserAnotherlListener,
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

class FriendsUserAnotherDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.userId == newItem.userId
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}