package ru.procourt.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.procourt.R
import ru.procourt.databinding.FragmentCardPlayerPersonalSheduleBinding
import ru.procourt.databinding.FragmentCardTournamentPlayerPersonalBinding
import ru.procourt.databinding.FragmentTournamentAdultCardSearchBinding
import ru.procourt.databinding.OneClubForPartnerListBinding
import ru.procourt.dto.Club
import ru.procourt.dto.Player
import ru.procourt.dto.Tournament

class TournamentUserPersonalAdapter:
    ListAdapter<Tournament, TournamentUserPersonalViewHolder>(TournamentUserPersonalDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TournamentUserPersonalViewHolder {
        val binding =
            FragmentCardTournamentPlayerPersonalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TournamentUserPersonalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TournamentUserPersonalViewHolder, position: Int) {
        val tournament = getItem(position)
        holder.bind(tournament)
    }

}

class TournamentUserPersonalViewHolder(
    private val binding: FragmentCardTournamentPlayerPersonalBinding
) : RecyclerView.ViewHolder(binding.root) {


    @SuppressLint("SetTextI18n")
    fun bind(tournament: Tournament) {
        binding.apply {
            fctppInputRank.text = tournament.rank
            inputPrice.text = tournament.price
            fctppInputPlace.text = tournament.place
            fctppInputDate.text = tournament.date
            fctppInputLevel.text = tournament.level

            if(tournament.maxPartsNumber > tournament.partsNumber) {
                fctppIsGoing.visibility = View.GONE
                val numberParts = tournament.maxPartsNumber - tournament.partsNumber
                fctppNotEnoughParticipants.visibility = ViewGroup.VISIBLE
                fctppNotEnoughParticipants.text = "ДЛЯ СТАРТА НЕ ХВАТАЕТ $numberParts УЧАСТНИКОВ"
            } else {
                fctppIsGoing.visibility = View.VISIBLE
                fctppNotEnoughParticipants.visibility = ViewGroup.GONE
            }

        }
    }
}

class TournamentUserPersonalDiffCallback : DiffUtil.ItemCallback<Tournament>() {
    override fun areItemsTheSame(oldItem: Tournament, newItem: Tournament): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Tournament, newItem: Tournament): Boolean {
        return oldItem == newItem
    }
}