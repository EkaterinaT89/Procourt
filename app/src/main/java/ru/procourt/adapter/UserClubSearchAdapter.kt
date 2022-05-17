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
import ru.procourt.dto.Search

//отображается один список (вертикальный) с двумя тиами объектов.
//class PlayerCouchClubSearchAdapter(private val searchListener: PlayerSearchListener) :
//    ListAdapter<Search, RecyclerView.ViewHolder>(PlayerCouchClubSearchDiffCallback()) {
//
//    private val typeClub = 0
//    private val typePlayer = 1
//
//    override fun getItemViewType(position: Int): Int {
//        return when (getItem(position)) {
//            is Club -> typeClub
//            is Player -> typePlayer
//            null -> throw IllegalArgumentException("unknown item type")
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        val layoutInflater = LayoutInflater.from(parent.context)
//        return when (viewType) {
//            typeClub -> ClubSearchViewHolder(
//                OneClubForPartnerListBinding.inflate(layoutInflater, parent, false)
//            )
//            typePlayer -> PlayerSearchViewHolder(
//                FragmentCardPlayerSearchBinding.inflate(layoutInflater, parent, false),
//                searchListener
//            )
//
//            else -> throw IllegalArgumentException("unknown view type: $viewType")
//        }
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        when (val item = getItem(position)) {
//            is Club -> (holder as ClubSearchViewHolder).bind(item)
//            is Player -> (holder as PlayerSearchViewHolder).bind(item)
//            null -> error("unknown view type: $item")
//        }
//    }
//
//}
//
//class PlayerCouchClubSearchDiffCallback : DiffUtil.ItemCallback<Search>() {
//    override fun areItemsTheSame(oldItem: Search, newItem: Search): Boolean {
//        if (oldItem::class != newItem::class) {
//            return false
//        }
//
//        return oldItem.id == newItem.id
//    }
//
//    override fun areContentsTheSame(oldItem: Search, newItem: Search): Boolean {
//        return oldItem == newItem
//    }
//}