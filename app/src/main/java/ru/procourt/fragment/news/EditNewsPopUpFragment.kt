package ru.procourt.fragment.news

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.databinding.FragmentEditNewsPopUpBinding

@SuppressLint("ClickableViewAccessibility")
class EditNewsPopUpFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentEditNewsPopUpBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fenpEditNewsButton.setOnClickListener {
                findNavController().navigate(R.id.editNewsFragment)
            }
            fenpCancelNewsButton.setOnClickListener {
                findNavController().navigate(R.id.newsFragment)
            }
            fenpDeleteNewsButton.setOnClickListener {

                context?.let { it1 ->
                    AlertDialog.Builder(it1).setMessage("Уверены?")
                        .setPositiveButton(
                            "Удалить"
                        ) { dialogInterface, i ->
                            //           функция удаления  AppAuth.getInstance().removeAuth()
                            findNavController().navigate(R.id.newsFragment)
                        }
                        .setNegativeButton(
                            "Нет"
                        ) { dialogInterface, i ->
                            return@setNegativeButton
                        }
                        .show()
                }

            }
            fenp.setOnTouchListener { _, motionEvent ->
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        findNavController().navigate(R.id.newsFragment)
                    }
                }
                true
            }
        }

        return binding.root
    }

}