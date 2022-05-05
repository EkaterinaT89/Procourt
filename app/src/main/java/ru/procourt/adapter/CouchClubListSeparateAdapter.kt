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
import ru.procourt.dto.Couch
import ru.procourt.dto.News
import ru.procourt.dto.Player

interface CouchClubListSeparateListener {
    fun onChooseTime(couch: Couch)
}

class CouchClubListSeparateAdapter(private val couchClubListSeparateListener: CouchClubListSeparateListener) :
    ListAdapter<Couch, CouchClubListSeparateViewHolder>(CouchClubListSeparateDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CouchClubListSeparateViewHolder {
        val binding =
            FragmentCardCouchForCouchesClubBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return CouchClubListSeparateViewHolder(binding, couchClubListSeparateListener)
    }

    override fun onBindViewHolder(holder: CouchClubListSeparateViewHolder, position: Int) {
        val couch = getItem(position)
        holder.bind(couch)
    }

}

class CouchClubListSeparateViewHolder(
    private val binding: FragmentCardCouchForCouchesClubBinding,
    private val couchClubListSeparateListener: CouchClubListSeparateListener,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(couch: Couch) {

        binding.apply {
            fcpfpcPlayerName.text = couch.name
            fcpfpcPlayerRank.text = couch.rank

            fcFCChooseTime.setOnClickListener {
                couchClubListSeparateListener.onChooseTime(couch)
            }

        }

    }
}

class CouchClubListSeparateDiffCallback : DiffUtil.ItemCallback<Couch>() {
    override fun areItemsTheSame(oldItem: Couch, newItem: Couch): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Couch, newItem: Couch): Boolean {
        return oldItem == newItem
    }
}