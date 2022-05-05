package ru.procourt.fragment.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.adapter.GamesPlayerPersonalAdapter
import ru.procourt.databinding.FragmentGamesPersonalPlayerBinding
import ru.procourt.viewModel.GameViewModel

class GamesPersonalPlayerFragment: Fragment() {

    val gameViewModel: GameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentGamesPersonalPlayerBinding.inflate(
            inflater,
            container,
            false
        )

        val gameAdapter = GamesPlayerPersonalAdapter()

        binding.fcppGamesContainer.adapter = gameAdapter

        gameViewModel.data.observe(viewLifecycleOwner) { games ->
            gameAdapter.submitList(games)
        }

        with(binding) {
            fcppGamesContainer.setOnClickListener {
//                фрагмент с играми и кнопками
            }
            fgppBackButton.setOnClickListener {
                findNavController().navigate(R.id.playerPersonalFragment)
            }
        }

        return binding.root
    }

}