package ru.procourt.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import ru.procourt.R
import ru.procourt.databinding.FragmentCardClubSearchBinding
import ru.procourt.databinding.FragmentCardPlayerSearchBinding
import ru.procourt.databinding.OneClubForPartnerListBinding
import ru.procourt.dto.Club
import ru.procourt.dto.Player
import ru.procourt.fragment.search.CardClubSearchFragment

interface ClubSearchPriceListener {
    fun onChooseTime(club: Club)
}

class ClubSearchPriceAdapter(private val clubSearchPriceListener: ClubSearchPriceListener) :
    ListAdapter<Club, ClubSearchPriceViewHolder>(ClubSearchPriceDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubSearchPriceViewHolder {
        val binding =
            FragmentCardClubSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClubSearchPriceViewHolder(clubSearchPriceListener, binding)
    }

    override fun onBindViewHolder(holder: ClubSearchPriceViewHolder, position: Int) {
        val club = getItem(position)
        holder.bind(club)
    }

}

class ClubSearchPriceViewHolder(
    private val clubSearchPriceListener: ClubSearchPriceListener,
    private val binding: FragmentCardClubSearchBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(club: Club) {
        binding.apply {
            fcclClubName.text = club.name
            fcclClubLocation.text = club.location
            fcclPriceButton.setOnClickListener {
                clubSearchPriceListener.onChooseTime(club)
            }
        }
    }
}

class ClubSearchPriceDiffCallback : DiffUtil.ItemCallback<Club>() {
    override fun areItemsTheSame(oldItem: Club, newItem: Club): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Club, newItem: Club): Boolean {
        return oldItem == newItem
    }
}