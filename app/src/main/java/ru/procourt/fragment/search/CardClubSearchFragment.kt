package ru.procourt.fragment.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.procourt.databinding.FragmentCardClubSearchBinding

class CardClubSearchFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentCardClubSearchBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fcclPriceButton.setOnClickListener {
// переход на страницу клуба !!!
            }
        }

        return binding.root
    }

}