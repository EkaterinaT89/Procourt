package ru.procourt.fragment.tournament

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.adapter.GamesTournamentAdapter
import ru.procourt.adapter.TournamentPartsAdapter
import ru.procourt.databinding.FragmentTournamentBinding
import ru.procourt.viewModel.GameViewModel
import ru.procourt.viewModel.PlayerViewModel

class TournamentFragment: Fragment() {

    private val partViewModel: PlayerViewModel by viewModels()
    private val gameViewModel: GameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentTournamentBinding.inflate(
            inflater,
            container,
            false
        )

        val partsAdapter = TournamentPartsAdapter()

        binding.listOfParticipants.adapter = partsAdapter

        partViewModel.data.observe(viewLifecycleOwner) { parts ->
            partsAdapter.submitList(parts)
        }

        val gameAdapter = GamesTournamentAdapter()

        binding.listOfGames.adapter = gameAdapter

        gameViewModel.data.observe(viewLifecycleOwner) { games ->
            gameAdapter.submitList(games)
        }

        with(binding) {
            backButton.setOnClickListener {
                findNavController().navigate(R.id.tournamentsSearchFragment)
            }

            takePartButton.setOnClickListener {
                findNavController().navigate(R.id.takePartTournamentPopUpFragment)
            }

//если уже участвует, то чат появляется
            tournamentChatButton.setOnClickListener {
                findNavController().navigate(R.id.chatFragment)
            }

            games.setOnClickListener {
                findNavController().navigate(R.id.gamesTournamentFragment)
            }

        }

        return binding.root
    }

}