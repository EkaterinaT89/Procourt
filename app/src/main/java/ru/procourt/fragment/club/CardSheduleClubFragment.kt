package ru.procourt.fragment.club

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.procourt.databinding.FragmentCardSheduleClubBinding
import ru.procourt.databinding.FragmentClubBinding

class CardSheduleClubFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentCardSheduleClubBinding.inflate(
            inflater,
            container,
            false
        )

//        если дата свободна - текст яркий, если нет - полупрозрачный !!! Через адаптер!!!

        with(binding) {

        }

        return binding.root
    }

}