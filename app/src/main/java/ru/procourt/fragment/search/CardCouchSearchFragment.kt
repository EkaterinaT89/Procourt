package ru.procourt.fragment.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.procourt.databinding.FragmentCardCouchSearchBinding

class CardCouchSearchFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentCardCouchSearchBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fccsChooseCouchTimeButton.setOnClickListener {

            }
        }

        return binding.root
    }

}