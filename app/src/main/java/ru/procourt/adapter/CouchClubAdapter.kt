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

interface CouchClubListener {
    fun onChooseTime(couch: Couch)
}

class CouchClubAdapter(private val couchClubListener: CouchClubListener) :
    ListAdapter<Couch, CouchClubViewHolder>(CouchClubDiffCallback()) {

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
        val couch = getItem(position)
        holder.bind(couch)
    }

}

class CouchClubViewHolder(
    private val binding: FragmentCardCouchClubBinding,
    private val couchClubListener: CouchClubListener,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(couch: Couch) {

        binding.apply {
            fcocCouchName.text = couch.name
            fcocCouchRank.text = couch.rank

            fcocChooseCouchTimeButton.setOnClickListener {
                couchClubListener.onChooseTime(couch)
            }

        }

    }
}

class CouchClubDiffCallback : DiffUtil.ItemCallback<Couch>() {
    override fun areItemsTheSame(oldItem: Couch, newItem: Couch): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Couch, newItem: Couch): Boolean {
        return oldItem == newItem
    }
}