package ru.procourt.fragment.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.adapter.*
import ru.procourt.databinding.FragmentTournamentsSearchBinding
import ru.procourt.dto.Club
import ru.procourt.dto.Tournament
import ru.procourt.viewModel.ClubViewModel
import ru.procourt.viewModel.TournamentChildViewModel
import ru.procourt.viewModel.TournamentViewModel

class TournamentsSearchFragment: Fragment() {

    private val tournamentViewModel: TournamentViewModel by viewModels()
    private val tournamentChildViewModel: TournamentChildViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentTournamentsSearchBinding.inflate(
            inflater,
            container,
            false
        )

        val tournamentAdultSearchAdapter = TournamentAdultSearchAdapter(object : TournamentAdultSearchListener {
            override fun onChooseTournament(tournament: Tournament) {
                tournamentViewModel.choose(tournament.id)
                findNavController().navigate(R.id.tournamentFragment)
            }

        })
        val tournamentChildSearchAdapter = TournamentChildSearchAdapter(object : TournamentChildSearchListener {
            override fun onChooseTournament(tournament: Tournament) {
                tournamentChildViewModel.choose(tournament.id)
                findNavController().navigate(R.id.tournamentFragment)
            }
        })

        binding.ftsListOfTournamentsAdultContainer.adapter = tournamentAdultSearchAdapter
        binding.ftsListOfTournamentsChildContainer.adapter = tournamentChildSearchAdapter

        tournamentViewModel.data.observe(viewLifecycleOwner) { tournaments ->
            tournamentAdultSearchAdapter.submitList(tournaments)
        }

        tournamentChildViewModel.data.observe(viewLifecycleOwner) { tournaments ->
            tournamentChildSearchAdapter.submitList(tournaments)
        }

        with(binding) {
            ftsChildButtonLight.setOnClickListener {
                ftsChildButtonLight.visibility = View.GONE
                ftsChildButton.visibility = View.VISIBLE
                ftsListOfTournamentsChildContainer.visibility = View.VISIBLE
                ftsListOfTournamentsAdultContainer.visibility = View.GONE
                ftsAdultsButton.visibility = View.GONE
                ftsAdultsButtonLight.visibility = View.VISIBLE
                ftsChildFiltr.visibility = View.VISIBLE
                ftsAdultsFiltr.visibility = View.GONE
            }

            ftsAdultsButtonLight.setOnClickListener {
                ftsAdultsButton.visibility = View.VISIBLE
                ftsAdultsButtonLight.visibility = View.GONE
                ftsListOfTournamentsChildContainer.visibility = View.GONE
                ftsListOfTournamentsAdultContainer.visibility = View.VISIBLE
                ftsChildButtonLight.visibility = View.VISIBLE
                ftsChildButton.visibility = View.GONE
                ftsAdultsFiltr.visibility = View.VISIBLE
                ftsChildFiltr.visibility = View.GONE
            }

            ftsAdultsFiltr.setOnClickListener {
                findNavController().navigate(R.id.filtrTournamentAdultFragment)
            }
            ftsChildFiltr.setOnClickListener {
                findNavController().navigate(R.id.filtrTournamentChildFragment)
            }

            ftsBottomNav.setOnItemSelectedListener { item ->
                when(item.itemId) {
                    R.id.rectangle -> {
                        findNavController().navigate(R.id.newsFragment)
                        true
                    }
                    R.id.search -> {
                        findNavController().navigate(R.id.searchFragment)
                        true
                    }
                    R.id.notifications -> {
                        findNavController().navigate(R.id.messagesNotificationsFragment)
                        true
                    }
                    R.id.person -> {
                        findNavController().navigate(R.id.playerPersonalFragment)
                        true
                    }

                    else -> false
                }

            }
        }

        return binding.root
    }

}