package ru.procourt.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.procourt.R
import ru.procourt.databinding.FragmentCardCouchSearchBinding
import ru.procourt.databinding.FragmentCardNewsBinding
import ru.procourt.databinding.FragmentCardPlayerSearchBinding
import ru.procourt.dto.Couch
import ru.procourt.dto.News
import ru.procourt.dto.Player
import ru.procourt.dto.User

interface CouchSearchListener {
    fun onChooseTime(user: User)
}

class CouchSearchAdapter(private val couchSearchListener: CouchSearchListener) :
    ListAdapter<User, CouchSearchViewHolder>(CouchSearchDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CouchSearchViewHolder {
        val binding =
            FragmentCardCouchSearchBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return CouchSearchViewHolder(binding, couchSearchListener)
    }

    override fun onBindViewHolder(holder: CouchSearchViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

}

class CouchSearchViewHolder(
    private val binding: FragmentCardCouchSearchBinding,
    private val couchSearchListener: CouchSearchListener,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User) {

        binding.apply {
            fccsCouchName.text = user.name
            fccsCouchRank.text = user.level

            fccsChooseCouchTimeButton.setOnClickListener {
                couchSearchListener.onChooseTime(user)
            }

        }

    }
}

class CouchSearchDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.userId == newItem.userId
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}