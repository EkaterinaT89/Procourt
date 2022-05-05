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
import ru.procourt.databinding.FragmentGamesTournamentBinding
import ru.procourt.viewModel.GameViewModel

class GamesTournamentFragment: Fragment() {

    private val gameViewModel: GameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentGamesTournamentBinding.inflate(
            inflater,
            container,
            false
        )

        val firstCircleAdapter = GamesTournamentAdapter()

        binding.gamesResultFirstCircleContainer.adapter = firstCircleAdapter

        gameViewModel.data.observe(viewLifecycleOwner) { games ->
            firstCircleAdapter.submitList(games)
        }

        val secondCircleAdapter = GamesTournamentAdapter()

        binding.gamesResultSecondCircleContainer.adapter = secondCircleAdapter

        gameViewModel.data.observe(viewLifecycleOwner) { games ->
            secondCircleAdapter.submitList(games)
        }

        val thirdCircleAdapter = GamesTournamentAdapter()

        binding.gamesResultFirdCircleContainer.adapter = thirdCircleAdapter

        gameViewModel.data.observe(viewLifecycleOwner) { games ->
            thirdCircleAdapter.submitList(games)
        }

        val fourthCircleAdapter = GamesTournamentAdapter()

        binding.gamesResultFourthCircleContainer.adapter = fourthCircleAdapter

        gameViewModel.data.observe(viewLifecycleOwner) { games ->
            fourthCircleAdapter.submitList(games)
        }

        with(binding) {
            backButton.setOnClickListener {
                findNavController().navigate(R.id.tournamentFragment)
            }
            openGamesFirstCircle.setOnClickListener {
                gamesResultFirstCircleContainer.visibility = View.VISIBLE
                openGamesFirstCircle.visibility = View.GONE
                closeGamesFirstCircle.visibility = View.VISIBLE
            }
            closeGamesFirstCircle.setOnClickListener {
                gamesResultFirstCircleContainer.visibility = View.GONE
                openGamesFirstCircle.visibility = View.VISIBLE
                closeGamesFirstCircle.visibility = View.GONE
            }

            openGamesSecondCircle.setOnClickListener {
                gamesResultSecondCircleContainer.visibility = View.VISIBLE
                openGamesSecondCircle.visibility = View.GONE
                closeGamesSecondCircle.visibility = View.VISIBLE
            }
            closeGamesSecondCircle.setOnClickListener {
                gamesResultSecondCircleContainer.visibility = View.GONE
                openGamesSecondCircle.visibility = View.VISIBLE
                closeGamesSecondCircle.visibility = View.GONE
            }

            openGamesFirdCircle.setOnClickListener {
                gamesResultFirdCircleContainer.visibility = View.VISIBLE
                openGamesFirdCircle.visibility = View.GONE
                closeGamesFirdCircle.visibility = View.VISIBLE
            }
            closeGamesFirdCircle.setOnClickListener {
                gamesResultFirdCircleContainer.visibility = View.GONE
                openGamesFirdCircle.visibility = View.VISIBLE
                closeGamesFirdCircle.visibility = View.GONE
            }

            openGamesFourthCircle.setOnClickListener {
                gamesResultFourthCircleContainer.visibility = View.VISIBLE
                openGamesFourthCircle.visibility = View.GONE
                closeGamesFourthCircle.visibility = View.VISIBLE
            }
            closeGamesFourthCircle.setOnClickListener {
                gamesResultFourthCircleContainer.visibility = View.GONE
                openGamesFourthCircle.visibility = View.VISIBLE
                closeGamesFourthCircle.visibility = View.GONE
            }

        }

        return binding.root
    }
}