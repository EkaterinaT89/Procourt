package ru.procourt.fragment.tournament

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.databinding.FragmentSetkaTournamentBinding

class SetkaTournamentFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentSetkaTournamentBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            backButton.setOnClickListener {
                findNavController().navigate(R.id.gamesTournamentFragment)
            }
            oneEightFinal.setOnClickListener {
                tableContainerEight.visibility = View.VISIBLE
                tableContainerFour.visibility = View.GONE
                tableContainerTwo.visibility = View.GONE
            }
            oneFourFinal.setOnClickListener {
                tableContainerEight.visibility = View.GONE
                tableContainerFour.visibility = View.VISIBLE
                tableContainerTwo.visibility = View.GONE
            }
            oneTwoFinal.setOnClickListener {
                tableContainerEight.visibility = View.GONE
                tableContainerFour.visibility = View.GONE
                tableContainerTwo.visibility = View.VISIBLE
            }
        }

        return binding.root
    }

}