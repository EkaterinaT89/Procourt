package ru.procourt.fragment.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import ru.procourt.R
import ru.procourt.adapter.MessageAdapter
import ru.procourt.adapter.MessageListener
import ru.procourt.adapter.NotificationAdapter
import ru.procourt.databinding.FragmentMessagesNotificationsBinding
import ru.procourt.dto.Message
import ru.procourt.service.SwipeToDeleteCallback
import ru.procourt.viewModel.MessageViewModel
import ru.procourt.viewModel.NotificationViewModel

class MessagesNotificationsFragment: Fragment() {

    private val messageViewModel: MessageViewModel by viewModels()
    private val notificationViewModel: NotificationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentMessagesNotificationsBinding.inflate(
            inflater,
            container,
            false
        )

        val messageAdapter = MessageAdapter(object: MessageListener {
            override fun onExpandMesssage(message: Message) {
                messageViewModel.expand(message.id)
            }

        })

        binding.fmnListOfMessagesContainer.adapter = messageAdapter

        messageViewModel.data.observe(viewLifecycleOwner) { messages ->
            messageAdapter.submitList(messages)
        }

        val notificationAdapter = NotificationAdapter()

        binding.fmnListOfNotificationsContainer.adapter = notificationAdapter

        notificationViewModel.data.observe(viewLifecycleOwner) { couches ->
            notificationAdapter.submitList(couches)
        }

        val swipeHandler = object : SwipeToDeleteCallback(context) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                val adapter = recyclerView.adapter as NotificationAdapter
//                adapter.removeAt(viewHolder.adapterPosition)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(binding.fmnListOfNotificationsContainer)

        with(binding) {

            fmnMessagesLight.setOnClickListener {
                fmnMessagesLight.visibility = View.GONE
                fmnMessages.visibility = View.VISIBLE
                fmnListOfMessagesContainer.visibility = View.VISIBLE
                fmnListOfNotificationsContainer.visibility = View.GONE
                fmnNotifications.visibility = View.GONE
                fmnNotificationsLight.visibility = View.VISIBLE
                fmnWriteMessage.visibility = View.VISIBLE
                fmnWriteMessageBackground.visibility = View.GONE
            }

            fmnNotificationsLight.setOnClickListener {
                fmnNotifications.visibility = View.VISIBLE
                fmnNotificationsLight.visibility = View.GONE
                fmnListOfMessagesContainer.visibility = View.GONE
                fmnListOfNotificationsContainer.visibility = View.VISIBLE
                fmnMessagesLight.visibility = View.VISIBLE
                fmnMessages.visibility = View.GONE
                fmnWriteMessage.visibility = View.GONE
                fmnWriteMessage.visibility = View.GONE
                fmnWriteMessageBackground.visibility = View.VISIBLE
            }

            fmnBottomNav.setOnItemSelectedListener { item ->
                when(item.itemId) {
                    R.id.rectangle -> {
                        findNavController().navigate(R.id.newsFragment)
                        true
                    }
                    R.id.search -> {
                        findNavController().navigate(R.id.searchFragment)
                        true
                    }
                    R.id.notifications -> {
                        findNavController().navigate(R.id.messagesNotificationsFragment)
                        true
                    }
                    R.id.person -> {
                        findNavController().navigate(R.id.playerSearchFragment)
                        true
                    }

                    else -> false
                }

            }

            fmnWriteMessage.setOnClickListener {
                findNavController().navigate(R.id.createGroupChatFragment)
            }


        }

        return binding.root
    }

}