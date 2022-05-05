package ru.procourt.fragment.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.databinding.FragmentIntroSecondBinding

class IntroSecondFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentIntroSecondBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fisBackButton.setOnClickListener {
                findNavController().navigate(R.id.introFirstFragment)
            }
            fisNextButton.setOnClickListener {
                findNavController().navigate(R.id.introThirdFragment)
            }
            fisSkipButton.setOnClickListener {
                findNavController().navigate(R.id.newsFragment)
            }
        }

        return binding.root
    }

}