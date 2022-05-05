package ru.procourt.fragment.news

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.adapter.CommentAdapter
import ru.procourt.adapter.NewsAdapter
import ru.procourt.adapter.OnInteractionListener
import ru.procourt.databinding.FragmentAddCommentBinding
import ru.procourt.dto.News
import ru.procourt.service.AndroidUtils
import ru.procourt.viewModel.CommentViewModel
import ru.procourt.viewModel.NewsViewModel

class AddCommentFragment: Fragment() {

    val commentViewModel: CommentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentAddCommentBinding.inflate(
            inflater,
            container,
            false
        )

        val commentAdapter = CommentAdapter()

        binding.facContainerForComments.adapter = commentAdapter

        commentViewModel.data.observe(viewLifecycleOwner) { comments ->
            commentAdapter.submitList(comments)
        }

        with(binding) {

            facWriteCommentInput.setOnFocusChangeListener { view, b ->
                if (b) {
                    facCommentSentButton.visibility = View.VISIBLE
                    facBottomNav.visibility = View.GONE
                } else {
                    facCommentSentButton.visibility = View.GONE
                    facBottomNav.visibility = View.VISIBLE
                }
            }

            facCommentSentButton.setOnClickListener{
                commentViewModel.addComment()
                facBottomNav.visibility = View.VISIBLE
                AndroidUtils().hideKeyboard(requireView())
            }

            facBottomNav.setOnItemSelectedListener { item ->
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
            facMenuButton.setOnClickListener {
                findNavController().navigate(R.id.editNewsPopUpFragment)
            }
        }

        return binding.root
    }

}