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
import ru.procourt.databinding.FragmentCardOneCourtSearchBinding
import ru.procourt.databinding.FragmentCardPlayerSearchBinding
import ru.procourt.dto.Court
import ru.procourt.dto.News
import ru.procourt.dto.Player

interface CourtSearchListener {
    fun onExpand(court: Court)
    fun onAutoBook(court: Court)
    fun onChoose(court: Court)
}

class CourtSearchAdapter(private val playerCourtListener: CourtSearchListener) :
    ListAdapter<Court, CourtSearchViewHolder>(CourtSearchDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourtSearchViewHolder {
        val binding =
            FragmentCardOneCourtSearchBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return CourtSearchViewHolder(binding, playerCourtListener)
    }

    override fun onBindViewHolder(holder: CourtSearchViewHolder, position: Int) {
        val court = getItem(position)
        holder.bind(court)
    }

}

class CourtSearchViewHolder(
    private val binding: FragmentCardOneCourtSearchBinding,
    private val courtSearchListener: CourtSearchListener,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(court: Court) {

        binding.apply {
            fcocsExpandCourtsButton.setOnClickListener {
                courtSearchListener.onExpand(court)
                fcocsExpandGroup.visibility = View.VISIBLE
            }
            fcocsCloseCourtsButtonExpand.setOnClickListener {
                fcocsExpandGroup.visibility = View.GONE
            }

            fcocsAutoBookOnOff.setOnClickListener {
                courtSearchListener.onAutoBook(court)
                fcocsGroupForAutoBook.visibility = View.VISIBLE
            }
            if(fcocsAutoBookOnOff.isChecked) {
                fcocsGroupForAutoBook.visibility = View.VISIBLE
            } else {
                fcocsGroupForAutoBook.visibility = View.GONE
            }

            fcocsCourtName.text = court.name
            fcocsCourtNameExpand.text = court.name

            fcocsCourtPrice.text = court.price
            fcocsPriceExpand.text = court.price

            fcocsChooseButton.setOnClickListener {
                courtSearchListener.onChoose(court)
            }

        }

    }
}

class CourtSearchDiffCallback : DiffUtil.ItemCallback<Court>() {
    override fun areItemsTheSame(oldItem: Court, newItem: Court): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Court, newItem: Court): Boolean {
        return oldItem == newItem
    }
}