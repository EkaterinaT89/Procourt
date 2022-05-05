package ru.procourt.fragment.search

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.adapter.*
import ru.procourt.databinding.OneClubForCouchListBinding
import ru.procourt.databinding.OneClubForPartnerListBinding
import ru.procourt.dto.News
import ru.procourt.dto.Player
import ru.procourt.fragment.player.PlayerAnotherFragment
import ru.procourt.viewModel.ClubViewModel
import ru.procourt.viewModel.NewsViewModel
import ru.procourt.viewModel.PlayerViewModel

class CardOneClubForPartnerSearchFragment: Fragment() {

    val playerViewModel: PlayerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = OneClubForPartnerListBinding.inflate(
            inflater,
            container,
            false
        )

        val playerAdapter = PlayerSearchAdapter(object : PlayerSearchListener{
            override fun onChooseTime(player: Player) {
                playerViewModel.chooseTime(player.id)
            }

        })

        binding.listOfPartners.adapter = playerAdapter

        playerViewModel.data.observe(viewLifecycleOwner) { players ->
            playerAdapter.submitList(players)
        }



        with(binding) {

        }

        return binding.root
    }

}