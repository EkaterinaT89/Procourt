package ru.procourt.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.procourt.R
import ru.procourt.databinding.FragmentCardCouchClubBinding
import ru.procourt.databinding.FragmentCardCouchSearchBinding
import ru.procourt.databinding.FragmentCardNewsBinding
import ru.procourt.databinding.FragmentCardPlayerSearchBinding
import ru.procourt.dto.Couch
import ru.procourt.dto.News
import ru.procourt.dto.Player
import ru.procourt.dto.User

interface CouchClubListener {
    fun onChooseTime(user: User)
}

class CouchClubAdapter(private val couchClubListener: CouchClubListener) :
    ListAdapter<User, CouchClubViewHolder>(CouchClubDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CouchClubViewHolder {
        val binding =
            FragmentCardCouchClubBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return CouchClubViewHolder(binding, couchClubListener)
    }

    override fun onBindViewHolder(holder: CouchClubViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

}

class CouchClubViewHolder(
    private val binding: FragmentCardCouchClubBinding,
    private val couchClubListener: CouchClubListener,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User) {

        binding.apply {
            fcocCouchName.text = user.name
            fcocCouchRank.text = user.level

            fcocChooseCouchTimeButton.setOnClickListener {
                couchClubListener.onChooseTime(user)
            }

        }

    }
}

class CouchClubDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.userId == newItem.userId
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}