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
import ru.procourt.adapter.NewsAdapter
import ru.procourt.adapter.OnInteractionListener
import ru.procourt.databinding.FragmentNewsBinding
import ru.procourt.dto.News
import ru.procourt.repository.NewsRepositoryImpl
import ru.procourt.viewModel.NewsViewModel

class NewsFragment: Fragment() {

    val newsViewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentNewsBinding.inflate(
            inflater,
            container,
            false
        )

        val newsAdapter = NewsAdapter(object : OnInteractionListener {
            override fun onShareVk(news: News) {
                newsViewModel.shareVkById(news.id)
                Log.d("CLICK Fragment!!!!", "click")
            }

            override fun onShareFb(news: News) {
                newsViewModel.shareFbById(news.id)
            }

            override fun onAddComment(news: News) {
                findNavController().navigate(R.id.action_newsFragment_to_addCommentFragment)
            }

            override fun onShareOut(news: News) {
                newsViewModel.shareOutById(news.id)
                val intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, news.content)
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(intent, getString(R.string.share_intent))
                startActivity(shareIntent)
            }

            override fun onEdit(news: News) {
                findNavController().navigate(R.id.action_newsFragment_to_editNewsPopUpFragment)
            }

        })

        binding.fnContainerForNews.adapter = newsAdapter

        newsViewModel.data.observe(viewLifecycleOwner) { news ->
            newsAdapter.submitList(news)
        }

        with(binding) {
            fnAddNewsButton.setOnClickListener {
                findNavController().navigate(R.id.addNewsFragment)
            }
            fnSwiperefresh.setOnRefreshListener {
                newsViewModel.loadNews()
            }
            fnBottomNav.setOnItemSelectedListener { item ->
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
                        findNavController().navigate(R.id.playerPersonalFragment)
                        true
                    }

                    else -> false
                }

            }

        }

        return binding.root
    }

}