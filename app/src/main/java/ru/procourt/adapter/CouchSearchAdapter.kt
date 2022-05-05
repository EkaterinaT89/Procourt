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

interface CouchSearchListener {
    fun onChooseTime(couch: Couch)
}

class CouchSearchAdapter(private val couchSearchListener: CouchSearchListener) :
    ListAdapter<Couch, CouchSearchViewHolder>(CouchSearchDiffCallback()) {

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
        val couch = getItem(position)
        holder.bind(couch)
    }

}

class CouchSearchViewHolder(
    private val binding: FragmentCardCouchSearchBinding,
    private val couchSearchListener: CouchSearchListener,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(couch: Couch) {

        binding.apply {
            fccsCouchName.text = couch.name
            fccsCouchRank.text = couch.rank

            fccsChooseCouchTimeButton.setOnClickListener {
                couchSearchListener.onChooseTime(couch)
            }

        }

    }
}

class CouchSearchDiffCallback : DiffUtil.ItemCallback<Couch>() {
    override fun areItemsTheSame(oldItem: Couch, newItem: Couch): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Couch, newItem: Couch): Boolean {
        return oldItem == newItem
    }
}