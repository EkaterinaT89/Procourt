package ru.procourt.fragment.club

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.adapter.ClubPlayerAdapter
import ru.procourt.adapter.ClubPlayerListSeparateAdapter
import ru.procourt.adapter.ClubPlayerListSeparateListener
import ru.procourt.adapter.ClubPlayerListener
import ru.procourt.databinding.FragmentPlayersClubBinding
import ru.procourt.dto.Player
import ru.procourt.viewModel.PlayerViewModel

class ClubPlayersFragment: Fragment() {

    val playerViewModel: PlayerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentPlayersClubBinding.inflate(
            inflater,
            container,
            false
        )

        val playerAdapter = ClubPlayerListSeparateAdapter(object : ClubPlayerListSeparateListener {
            override fun onChooseTime(player: Player) {
                playerViewModel.chooseTime(player.id)
            }
        })

        binding.fpcPlayersListContainer.adapter = playerAdapter

        playerViewModel.data.observe(viewLifecycleOwner) { players ->
            playerAdapter.submitList(players)
        }

        with(binding) {
            fpcBackButton.setOnClickListener {
                findNavController().navigate(R.id.clubFragment)
            }
        }

        return binding.root
    }

}