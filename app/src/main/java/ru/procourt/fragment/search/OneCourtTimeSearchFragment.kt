package ru.procourt.fragment.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.procourt.R
import ru.procourt.databinding.FragmentOneCourtTimeSearchBinding

class OneCourtTimeSearchFragment: Fragment() {

    var colorForBackground = getResources().getColor(R.color.dark_blue)
    var colorForText = getResources().getColor(R.color.white)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentOneCourtTimeSearchBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            foctsGetCourtButton.setOnClickListener {
                foctsGetCourtButton.setBackgroundColor(colorForBackground)
                foctsGetCourtButton.setTextColor(colorForText)
            }
        }

        return binding.root
    }

}