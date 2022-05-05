package ru.procourt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.procourt.R
import ru.procourt.databinding.FragmentCardPlayerSearchBinding
import ru.procourt.databinding.OneClubForPartnerListBinding
import ru.procourt.dto.Club
import ru.procourt.dto.Player

class ClubSearchAdapter() :
    ListAdapter<Club, ClubSearchViewHolder>(ClubSearchDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubSearchViewHolder {
        val binding =
            OneClubForPartnerListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClubSearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ClubSearchViewHolder, position: Int) {
        val club = getItem(position)
        holder.bind(club)
    }

}

class ClubSearchViewHolder(
    private val binding: OneClubForPartnerListBinding
) : RecyclerView.ViewHolder(binding.root) {

    val playerRecyclerView: RecyclerView

    val playerAdapter = PlayerSearchAdapter(object : PlayerSearchListener{
        override fun onChooseTime(player: Player) {

        }

    })

    init {
        val context = itemView.context
        playerRecyclerView = itemView.findViewById(R.id.list_of_partners)

//        horizontalAdapter = Horizontal_RVAdapter(context) ????? надо ли
        playerRecyclerView.adapter = playerAdapter

    }
    fun bind(club: Club) {
        binding.apply {
            clubName.text = club.name
            clubLocation.text = club.location

        }
    }
}

class ClubSearchDiffCallback : DiffUtil.ItemCallback<Club>() {
    override fun areItemsTheSame(oldItem: Club, newItem: Club): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Club, newItem: Club): Boolean {
        return oldItem == newItem
    }
}