package ru.procourt.viewModel

import androidx.lifecycle.ViewModel
import ru.procourt.repository.*

class ChatViewModel: ViewModel() {

    private val repository: ChatRepository = ChatRepositoryImpl()

    val data = repository.getAll()

}