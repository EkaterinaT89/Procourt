package ru.procourt.fragment.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.databinding.FragmentIntroAuthBinding

class IntroAuthFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentIntroAuthBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fiaBackButton.setOnClickListener {
                findNavController().navigate(R.id.introAuthReccomendFragment)
            }
            fiaSignUpButton.setOnClickListener {
                findNavController().navigate(R.id.introSignUpFragment)
            }
            fiaEmailAuthorization.setOnClickListener {
                findNavController().navigate(R.id.introEmailAuthFragment)
            }

        }

        return binding.root
    }
}