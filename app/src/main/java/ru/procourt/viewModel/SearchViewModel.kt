package ru.procourt.viewModel

import androidx.lifecycle.ViewModel
import ru.procourt.repository.PlayerRepository
import ru.procourt.repository.PlayerRepositoryImpl
import ru.procourt.repository.SearchRepository

class SearchViewModel: ViewModel() {

    private val repository: SearchRepository = SearchRepository()

    val data = repository.getAll()
}