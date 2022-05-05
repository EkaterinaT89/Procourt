package ru.procourt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.procourt.R
import ru.procourt.databinding.FragmentTournamentAdultCardSearchBinding
import ru.procourt.databinding.FragmentTournamentChildCardSearchBinding
import ru.procourt.databinding.OneClubForPartnerListBinding
import ru.procourt.dto.Club
import ru.procourt.dto.Player
import ru.procourt.dto.Tournament

interface TournamentChildSearchListener {
    fun onChooseTournament(tournament: Tournament)
}

class TournamentChildSearchAdapter(private val tournamentChildSearchListener: TournamentChildSearchListener):
    ListAdapter<Tournament, TournamentChildSearchViewHolder>(TournamentChildSearchDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TournamentChildSearchViewHolder {
        val binding =
            FragmentTournamentChildCardSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TournamentChildSearchViewHolder(binding, tournamentChildSearchListener)
    }

    override fun onBindViewHolder(holder: TournamentChildSearchViewHolder, position: Int) {
        val tournament = getItem(position)
        holder.bind(tournament)
    }

}

class TournamentChildSearchViewHolder(
    private val binding: FragmentTournamentChildCardSearchBinding,
    private val tournamentChildSearchListener: TournamentChildSearchListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(tournament: Tournament) {
        binding.apply {
            ftccsInputRank.text = tournament.rank
            ftccsInputPrice.text = tournament.price
            ftccsInputPlace.text = tournament.place
            ftccsInputDate.text = tournament.date
            ftccsInputLevel.text = tournament.level
            ftccsTitle.text = tournament.title

            tournamentChildMore.setOnClickListener {
                tournamentChildSearchListener.onChooseTournament(tournament)
            }

        }
    }
}

class TournamentChildSearchDiffCallback : DiffUtil.ItemCallback<Tournament>() {
    override fun areItemsTheSame(oldItem: Tournament, newItem: Tournament): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Tournament, newItem: Tournament): Boolean {
        return oldItem == newItem
    }
}