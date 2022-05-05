package ru.procourt.fragment.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.databinding.FragmentEditPlayerPersonalBinding

class EditPlayerPersonalFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentEditPlayerPersonalBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            feppSaveButton.setOnClickListener {
                findNavController().navigate(R.id.playerPersonalFragment)
            }
            feppSettingsButton.setOnClickListener {
                findNavController().navigate(R.id.settingsPlayerPersonalFragment)
            }

        }

        return binding.root
    }

}