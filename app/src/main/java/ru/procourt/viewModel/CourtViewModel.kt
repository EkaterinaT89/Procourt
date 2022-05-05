package ru.procourt.viewModel

import androidx.lifecycle.ViewModel
import ru.procourt.repository.*

class CourtViewModel : ViewModel() {

    private val repository: CourtRepository = CourtRepositoryImpl()

    val data = repository.getAll()

    fun choose(id: Long) {
        repository.onChoose(id)
    }

    fun expand() {
        repository.onExpand()
    }

    fun autoBook() {
        repository.onAutoBook()
    }

}