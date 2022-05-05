package ru.procourt.fragment.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.adapter.*
import ru.procourt.databinding.FragmentChatForGroupChatBinding
import ru.procourt.databinding.FragmentCreateGroupChatBinding
import ru.procourt.databinding.FragmentGroupChatBinding
import ru.procourt.databinding.FragmentIntroZeroBinding
import ru.procourt.dto.Player
import ru.procourt.viewModel.ChatViewModel
import ru.procourt.viewModel.PlayerViewModel

class ChatForGroupFragment: Fragment() {

    private val chatForGroupViewModel: ChatViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentChatForGroupChatBinding.inflate(
            inflater,
            container,
            false
        )

        val chatForGroupAdapter = ChatForGroupAdapter()

        binding.chat.adapter = chatForGroupAdapter

        chatForGroupViewModel.data.observe(viewLifecycleOwner) { chat ->
            chatForGroupAdapter.submitList(chat)
        }

        with(binding) {
            fcfgcBackButton.setOnClickListener {
                findNavController().navigate(R.id.groupChatFragment)
            }

        }


        return binding.root
    }

}