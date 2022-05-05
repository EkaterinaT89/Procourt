package ru.procourt.fragment.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.databinding.FragmentIntroAuthReccomendBinding

class IntroAuthReccomendFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentIntroAuthReccomendBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fiarBackButton.setOnClickListener {
                findNavController().navigate(R.id.introThirdFragment)
            }
            fiarSignUpButton.setOnClickListener {
                findNavController().navigate(R.id.introSignUpFragment)
            }
            fiarSignInButton.setOnClickListener {
                findNavController().navigate(R.id.introAuthFragment)
            }
            //ВРЕМЕННО!!!! ПОТОМ УДАЛИТЬ!!! для проверки
            fiarSkipButton.setOnClickListener {
                findNavController().navigate(R.id.newsFragment)
            }
        }

        return binding.root
    }

}