package ru.procourt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.procourt.databinding.FragmentCardParticipantsTournamentBinding
import ru.procourt.dto.User

class TournamentPartsAdapter() :
    ListAdapter<User, TournamentPartsViewHolder>(TournamentPartsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TournamentPartsViewHolder {
        val binding =
            FragmentCardParticipantsTournamentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return TournamentPartsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TournamentPartsViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

}

class TournamentPartsViewHolder(
    private val binding: FragmentCardParticipantsTournamentBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User) {

        binding.apply {
            playerName.text = user.name
            playerRank.text = user.level
            playerPrice.text = user.ratingValue
        }

    }
}

class TournamentPartsDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.userId == newItem.userId
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}