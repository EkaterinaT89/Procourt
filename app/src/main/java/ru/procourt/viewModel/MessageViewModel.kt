package ru.procourt.viewModel

import androidx.lifecycle.ViewModel
import ru.procourt.repository.*

class MessageViewModel: ViewModel() {

    private val repository: MessageRepository = MessageRepositoryImpl()

    val data = repository.getAll()

    fun expand(id: Long) {
        repository.expand(id)
    }
}