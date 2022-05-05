package ru.procourt.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.procourt.databinding.FragmentCouchBinding

class CouchFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentCouchBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            addCouchToFriends.setOnClickListener {

            }
            addCouchToFriendsText.setOnClickListener {

            }
            couchChat.setOnClickListener {

            }
            couchChatText.setOnClickListener {

            }
        }

        return binding.root
    }

}