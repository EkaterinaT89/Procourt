package ru.procourt.fragment.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.procourt.adapter.ChatAdapter
import ru.procourt.databinding.FragmentChatBinding
import ru.procourt.viewModel.ChatViewModel

class ChatFragment: Fragment() {

    private val chatViewModel: ChatViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentChatBinding.inflate(
            inflater,
            container,
            false
        )

        val chatAdapter = ChatAdapter()

        binding.chat.adapter = chatAdapter

        chatViewModel.data.observe(viewLifecycleOwner) { chat ->
            chatAdapter.submitList(chat)
        }

        with(binding) {

        }

        return binding.root
    }

}