package ru.procourt.fragment.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.databinding.FragmentCardMediaPlayerPersonalBinding
import ru.procourt.databinding.FragmentShedulePlayerPersonalBinding

class ShedulePlayerPersonalFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentShedulePlayerPersonalBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fsppAddTimeForPlayingButton.setOnClickListener {
                fsppAddTimeForPlayingButton.visibility = View.GONE
                chooseTimeVisibility.visibility = View.VISIBLE
            }

            fsppSeeClubs.setOnClickListener {
                fsppSeeClubs.visibility = View.GONE
                fsppClub.visibility = View.VISIBLE
                fsppClubPlayer.visibility = View.VISIBLE
//                переход на страницу клубов в поиске
                fsppDeleteTime.visibility = View.VISIBLE
            }
            fsppDeleteTime.setOnClickListener {
                context?.let { it1 ->
                    AlertDialog.Builder(it1).setMessage("Уверены?")
                        .setPositiveButton(
                            "Да, удалить"
                        ) { dialogInterface, i ->
//                            AppAuth.getInstance().removeAuth()
                            findNavController().navigate(R.id.shedulePlayerPersonalFragment)
                        }
                        .setNegativeButton(
                            "Нет, оставить"
                        ) { dialogInterface, i ->
                            return@setNegativeButton
                        }
                        .show()
                }
            }

        }

        return binding.root
    }

}