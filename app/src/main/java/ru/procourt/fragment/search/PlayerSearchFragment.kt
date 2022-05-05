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
import ru.procourt.databinding.FragmentPlayerSearchBinding
import ru.procourt.dto.Couch
import ru.procourt.dto.News
import ru.procourt.dto.Player
import ru.procourt.dto.Search
import ru.procourt.viewModel.ClubViewModel
import ru.procourt.viewModel.CouchViewModel
import ru.procourt.viewModel.PlayerViewModel
import ru.procourt.viewModel.SearchViewModel

class PlayerSearchFragment: Fragment() {

    private val playerViewModel: PlayerViewModel by viewModels()
    private val couchViewModel: CouchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentPlayerSearchBinding.inflate(
            inflater,
            container,
            false
        )

        val playerSearchAdapter = PlayerSearchAdapter(object : PlayerSearchListener {
            override fun onChooseTime(player: Player) {
                playerViewModel.chooseTime(player.id)
            }

        })

        binding.fpsListOfClubsPlayersContainer.adapter = playerSearchAdapter

        playerViewModel.data.observe(viewLifecycleOwner) { players ->
            playerSearchAdapter.submitList(players)
        }

        val couchSearchAdapter = CouchSearchAdapter(object : CouchSearchListener {
            override fun onChooseTime(couch: Couch) {
                couchViewModel.chooseTime(couch.id)
            }

        })

        binding.fpsListOfClubsCouchesContainer.adapter = couchSearchAdapter

        couchViewModel.data.observe(viewLifecycleOwner) { couches ->
           couchSearchAdapter.submitList(couches)
        }

        with(binding) {

            fpsCouchButtonLight.setOnClickListener {
                fpsCouchButtonLight.visibility = View.GONE
                fpsCouchButton.visibility = View.VISIBLE
                fpsListOfClubsCouchesContainer.visibility = View.VISIBLE
                fpsListOfClubsPlayersContainer.visibility = View.GONE
                fpsParnterButton.visibility = View.GONE
                fpsParnterButtonLight.visibility = View.VISIBLE
                fpsPlayerFiltr.visibility = View.GONE
                fpsCouchFiltr.visibility = View.VISIBLE
            }

            fpsParnterButtonLight.setOnClickListener {
                fpsParnterButton.visibility = View.VISIBLE
                fpsParnterButtonLight.visibility = View.GONE
                fpsListOfClubsCouchesContainer.visibility = View.GONE
                fpsListOfClubsPlayersContainer.visibility = View.VISIBLE
                fpsCouchButtonLight.visibility = View.VISIBLE
                fpsCouchButton.visibility = View.GONE
                fpsPlayerFiltr.visibility = View.VISIBLE
                fpsCouchFiltr.visibility = View.GONE
            }

            fpsBottomNav.setOnItemSelectedListener { item ->
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
            
            fpsCouchFiltr.setOnClickListener {
                findNavController().navigate(R.id.filtrCouchSearchFragment)
            }

            fpsPlayerFiltr.setOnClickListener {
                findNavController().navigate(R.id.filtrPlayerSearchFragment)
            }
        }

        return binding.root
    }

}