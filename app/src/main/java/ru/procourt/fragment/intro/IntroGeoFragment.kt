package ru.procourt.fragment.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.databinding.FragmentIntroGeoBinding

class IntroGeoFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentIntroGeoBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            figSkipButton.setOnClickListener {
                findNavController().navigate(R.id.introAuthReccomendFragment)
            }
//            сделать включение геолокации!!!!! на устройстве!!! + проверка включена или нет
            figTurnOnButton.setOnClickListener {
                findNavController().navigate(R.id.introAuthReccomendFragment)
            }
            figBackButton.setOnClickListener {
                findNavController().navigate(R.id.introThirdFragment)
            }
        }

        return binding.root
    }

}