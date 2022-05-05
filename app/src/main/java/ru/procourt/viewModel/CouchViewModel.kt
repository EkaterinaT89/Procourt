package ru.procourt.viewModel

import androidx.lifecycle.ViewModel
import ru.procourt.repository.*

class CouchViewModel: ViewModel() {

    private val repository: CouchRepository = CouchRepositoryImpl()

    val data = repository.getAll()

    fun chooseTime(id: Long) {
        repository.chooseTime(id)
    }

    fun loadPlayers() {
        repository.getAll()
    }

}