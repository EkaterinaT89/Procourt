package ru.procourt.fragment.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.databinding.FragmentIntroSignUpBinding

class IntroSignUpFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentIntroSignUpBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fisuBackButton.setOnClickListener {
                findNavController().navigate(R.id.introAuthReccomendFragment)
            }
            fisuAlreadyRegistedButton.setOnClickListener {
                findNavController().navigate(R.id.introAuthFragment)
            }
            fisuSignUpButton.setOnClickListener {
//                alreadyExist()
            }
        }

        return binding.root
    }

    fun alreadyExist(email: String, inputEmail: String) {
        if (email == inputEmail) {
            Toast.makeText(context, R.string.email_already_exist, Toast.LENGTH_SHORT).show()
        }

    }

}