package ru.procourt.fragment.intro

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.databinding.FragmentIntroAuthEmailBinding

class IntroEmailAuthFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentIntroAuthEmailBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fiaeBackButton.setOnClickListener {
                findNavController().navigate(R.id.introAuthFragment)
            }
            fiaeSignUpButton.setOnClickListener {
                findNavController().navigate(R.id.introSignUpFragment)
            }

            fiaeRemaindPasswordButton.setOnClickListener {
                fiaeGroupForRemindPassword.visibility = View.VISIBLE
                fiaeEnterButton.visibility = View.INVISIBLE
            }

            fiaeCancelButtonRemindPassword.setOnClickListener {
                fiaeGroupForRemindPassword.visibility = View.GONE
            }

            fiaeSentButtonPassword.setOnClickListener {
                fiaeGroupForRemindPassword.visibility = View.GONE

                val toast = Toast.makeText(
                    context,
                    "Инструкция по восстановлению \nпароля была отправлена на ваш E-mail",
                    Toast.LENGTH_SHORT
                )
                toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0)
                toast.show()
            }

            fiaeEnterButton.setOnClickListener {
                findNavController().navigate(R.id.introChooseAuthFragment)
            }

        }

        fun noEmail() {
            val inputEmail = binding.fiaeEmailInput.text.toString()
            if (inputEmail == " ") {
                Toast.makeText(context, R.string.no_email, Toast.LENGTH_SHORT).show()
            }
        }

        fun noPassword() {
            val inputEmail = binding.fiaePasswordInput.text.toString()
            if (inputEmail == " ") {
                Toast.makeText(context, R.string.no_password, Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    fun wrongEmailOrPassword(
        email: String,
        inputEmail: String,
        password: String,
        inputPassword: String
    ) {
        if (email != inputEmail && password != inputPassword) {
            Toast.makeText(context, R.string.wrong_email_password, Toast.LENGTH_SHORT).show()
        }
    }


}