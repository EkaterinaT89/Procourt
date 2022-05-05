package ru.procourt.fragment.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.procourt.R
import ru.procourt.databinding.FragmentGamesForConfirmPlayerPersonalBinding
import ru.procourt.databinding.FragmentScoreInputPlayerPersonalBinding

class ScoreInputPlayerPersonalFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentScoreInputPlayerPersonalBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fsippConfirmButton.setOnClickListener {

            }

        }

        return binding.root
    }

}