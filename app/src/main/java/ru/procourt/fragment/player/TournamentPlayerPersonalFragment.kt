package ru.procourt.fragment.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.procourt.databinding.FragmentTournamentsPersonalPlayerBinding

class TournamentPlayerPersonalFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentTournamentsPersonalPlayerBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            ftppGamesContainer.setOnClickListener {

            }
        }

        return binding.root
    }

}