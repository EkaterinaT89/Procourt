package ru.procourt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.procourt.databinding.FragmentCardPlayerForPlayersClubBinding
import ru.procourt.dto.User

interface ClubPlayerListSeparateListener {
    fun onChooseTime(user: User)
}

class ClubPlayerListSeparateAdapter(private val clubPlayerListSeparateListener: ClubPlayerListSeparateListener) :
    ListAdapter<User, ClubPlayerListSeparateViewHolder>(ClubPlayerListSeparateDiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ClubPlayerListSeparateViewHolder {
        val binding =
            FragmentCardPlayerForPlayersClubBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ClubPlayerListSeparateViewHolder(binding, clubPlayerListSeparateListener)
    }

    override fun onBindViewHolder(holder: ClubPlayerListSeparateViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

}

class ClubPlayerListSeparateViewHolder(
    private val binding: FragmentCardPlayerForPlayersClubBinding,
    private val clubPlayerListSeparateListener: ClubPlayerListSeparateListener,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User) {

        binding.apply {
            fcpfpcPlayerName.text = user.name
            fcpfpcPlayerRank.text = user.level

            fcpfpcChooseTime.setOnClickListener {
                clubPlayerListSeparateListener.onChooseTime(user)
            }

        }

    }
}

class ClubPlayerListSeparateDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.userId == newItem.userId
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}