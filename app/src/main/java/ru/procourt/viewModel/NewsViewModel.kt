package ru.procourt.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.procourt.repository.NewsRepository
import ru.procourt.repository.NewsRepositoryImpl

class NewsViewModel: ViewModel() {

    private val repository: NewsRepository = NewsRepositoryImpl()

    val data = repository.getAll()

    fun shareVkById(id: Long) {
        repository.shareVkById(id)
    }

    fun shareFbById(id: Long) {
        repository.shareFbById(id)
    }

    fun shareOutById(id: Long) {
        repository.shareOutById(id)
    }

    fun loadNews() {
        repository.getAll()
    }

}