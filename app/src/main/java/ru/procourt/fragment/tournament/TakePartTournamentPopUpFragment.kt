package ru.procourt.fragment.tournament

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.databinding.FragmentTakeAPartTournamentPopUpBinding

class TakePartTournamentPopUpFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentTakeAPartTournamentPopUpBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            sentButton.setOnClickListener {
                contactsAsk.visibility = View.GONE
                whenSent.visibility = View.VISIBLE
            }

            tournamentBackButton.setOnClickListener {
                findNavController().navigate(R.id.tournamentFragment)
            }
        }

        return binding.root
    }
}