package ru.procourt.fragment.player

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
import ru.procourt.databinding.FragmentSettingsPlayerPersonalBinding

class SettingsPlayerPersonalFragment : Fragment() {

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentSettingsPlayerPersonalBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fsppRemoveAccountButton.setOnClickListener {
                context?.let { it1 ->
                    AlertDialog.Builder(it1).setMessage("Уверены?")
                        .setPositiveButton(
                            "Да, удалить"
                        ) { dialogInterface, i ->
//                            AppAuth.getInstance().removeAuth()
                            findNavController().navigate(R.id.newsFragment)
                        }
                        .setNegativeButton(
                            "Нет, оставить"
                        ) { dialogInterface, i ->
                            return@setNegativeButton
                        }
                        .show()
                }
            }
            extraSet.setOnTouchListener { _, motionEvent ->
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        findNavController().navigate(R.id.playerPersonalFragment)
                    }
                }
                true
            }
            fsppSaveButton.setOnClickListener {
                findNavController().navigate(R.id.playerPersonalFragment)
            }
        }


        return binding.root
    }

}