package ru.procourt.fragment.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.procourt.databinding.FragmentCardFriendPlayerPersonalForListWithSearchBinding
import ru.procourt.databinding.FragmentTournamentsPersonalPlayerBinding

class CardFriendForSearchPP: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentCardFriendPlayerPersonalForListWithSearchBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {

        }

        return binding.root
    }

}