package ru.procourt.fragment.club

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.adapter.ClubPlayerListSeparateAdapter
import ru.procourt.adapter.ClubPlayerListSeparateListener
import ru.procourt.adapter.CouchClubListSeparateAdapter
import ru.procourt.adapter.CouchClubListSeparateListener
import ru.procourt.databinding.FragmentCouchesClubBinding
import ru.procourt.dto.Couch
import ru.procourt.dto.Player
import ru.procourt.viewModel.CouchViewModel

class ClubCoushesFragment: Fragment() {

    val couchViewModel: CouchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentCouchesClubBinding.inflate(
            inflater,
            container,
            false
        )

        val couchAdapter = CouchClubListSeparateAdapter(object : CouchClubListSeparateListener {
            override fun onChooseTime(couch: Couch) {
                couchViewModel.chooseTime(couch.id)
            }
        })

        binding.fccCouchesListContainer.adapter = couchAdapter

        couchViewModel.data.observe(viewLifecycleOwner) { couches ->
            couchAdapter.submitList(couches)
        }

        with(binding) {
            fccBackButton.setOnClickListener {
                findNavController().navigate(R.id.clubFragment)
            }
        }

        return binding.root
    }

}