package ru.procourt.fragment.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.procourt.databinding.FragmentCardAddPhotoBinding

class CardAddPhotoFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentCardAddPhotoBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fcapDeletePhoto.setOnClickListener {

            }
            fcapPickPhoto.setOnClickListener {

            }

        }

        return binding.root
    }

}