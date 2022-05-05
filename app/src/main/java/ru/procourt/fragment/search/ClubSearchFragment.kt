package ru.procourt.fragment.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.adapter.ClubSearchPriceAdapter
import ru.procourt.adapter.ClubSearchPriceListener
import ru.procourt.adapter.PlayerSearchAdapter
import ru.procourt.adapter.PlayerSearchListener
import ru.procourt.databinding.FragmentClubSearchBinding
import ru.procourt.databinding.FragmentPlayerSearchBinding
import ru.procourt.dto.Club
import ru.procourt.dto.Player
import ru.procourt.viewModel.ClubViewModel

class ClubSearchFragment: Fragment() {

    private val clubViewModel: ClubViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentClubSearchBinding.inflate(
            inflater,
            container,
            false
        )

        val clubSearchAdapter = ClubSearchPriceAdapter(object : ClubSearchPriceListener {
            override fun onChooseTime(club: Club) {
                clubViewModel.chooseTime(club.id)
                findNavController().navigate(R.id.clubFragment)
            }

        })

        binding.fclsListOfClubsContainer.adapter = clubSearchAdapter

        clubViewModel.data.observe(viewLifecycleOwner) { clubs ->
            clubSearchAdapter.submitList(clubs)
        }

        with(binding) {
            fclsBottomNav.setOnItemSelectedListener { item ->
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
            fclsFiltr.setOnClickListener {
                findNavController().navigate(R.id.filtrClubSearchFragment)
            }

        }

        return binding.root
    }

}