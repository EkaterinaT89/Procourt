package ru.procourt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.procourt.R
import ru.procourt.databinding.FragmentTournamentAdultCardSearchBinding
import ru.procourt.databinding.OneClubForPartnerListBinding
import ru.procourt.dto.Club
import ru.procourt.dto.Player
import ru.procourt.dto.Tournament

interface TournamentAdultSearchListener {
    fun onChooseTournament(tournament: Tournament)
}

class TournamentAdultSearchAdapter(private val tournamentAdultSearchListener: TournamentAdultSearchListener):
    ListAdapter<Tournament, TournamentAdultSearchViewHolder>(TournamentAdultSearchDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TournamentAdultSearchViewHolder {
        val binding =
            FragmentTournamentAdultCardSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TournamentAdultSearchViewHolder(binding, tournamentAdultSearchListener)
    }

    override fun onBindViewHolder(holder: TournamentAdultSearchViewHolder, position: Int) {
        val tournament = getItem(position)
        holder.bind(tournament)
    }

}

class TournamentAdultSearchViewHolder(
    private val binding: FragmentTournamentAdultCardSearchBinding,
    private val tournamentAdultSearchListener: TournamentAdultSearchListener
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(tournament: Tournament) {
        binding.apply {
            ftacsInputRank.text = tournament.rank
            ftacsInputPrice.text = tournament.price
            ftacsInputPlace.text = tournament.place
            ftacsInputDate.text = tournament.date
            ftacsInputLevel.text = tournament.level
            ftacsTitle.text = tournament.title

            tournamentMore.setOnClickListener {
                tournamentAdultSearchListener.onChooseTournament(tournament)
            }

        }
    }
}

class TournamentAdultSearchDiffCallback : DiffUtil.ItemCallback<Tournament>() {
    override fun areItemsTheSame(oldItem: Tournament, newItem: Tournament): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Tournament, newItem: Tournament): Boolean {
        return oldItem == newItem
    }
}