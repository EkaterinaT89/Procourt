package ru.procourt.fragment.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import ru.procourt.databinding.FragmentCardMediaPlayerPersonalBinding
import ru.procourt.databinding.FragmentShedulePlayerAnotherBinding
import ru.procourt.databinding.FragmentShedulePlayerPersonalBinding

class ShedulePlayerAnotherFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentShedulePlayerAnotherBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fspaChoosePlace.setOnClickListener {
//                переход на фрагмент клубов в поиске
                fspaClub.visibility = View.VISIBLE
                fspaClubPlayer.visibility = View.VISIBLE
                fspaChooseButton.visibility = View.VISIBLE
                fspaChoosePlace.visibility = View.GONE
            }
//            Условия появления предупреждения о клубе тренере
//            fspaInfo.visibility = View.VISIBLE
            fspaClubSheduleButton.setOnClickListener {
//                переход на фрагмент клуба
            }
        }

        return binding.root
    }

}