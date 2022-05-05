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
import ru.procourt.databinding.FragmentCourtSearchBinding
import ru.procourt.dto.Couch
import ru.procourt.dto.Court
import ru.procourt.dto.Player
import ru.procourt.viewModel.CouchViewModel
import ru.procourt.viewModel.CourtViewModel

class CourtSearchFragment: Fragment() {

    private val courtViewModel: CourtViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentCourtSearchBinding.inflate(
            inflater,
            container,
            false
        )

        val courtSearchAdapter = CourtSearchAdapter(object : CourtSearchListener {
            override fun onExpand(court: Court) {
                courtViewModel.expand()
            }

            override fun onAutoBook(court: Court) {
                courtViewModel.autoBook()
            }

            override fun onChoose(court: Court) {
                courtViewModel.choose(court.id)
            }


        })

        binding.fcrsCourtsList.adapter = courtSearchAdapter

        courtViewModel.data.observe(viewLifecycleOwner) { courts ->
            courtSearchAdapter.submitList(courts)
        }

        with(binding) {

            fcrsBottomNav.setOnItemSelectedListener { item ->
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
            fcrsFiltr.setOnClickListener {
                findNavController().navigate(R.id.filtrCourtSearchFragment)
            }

        }

        return binding.root
    }

}