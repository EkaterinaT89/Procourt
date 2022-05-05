package ru.procourt.viewModel

import androidx.lifecycle.ViewModel
import ru.procourt.repository.*

class NotificationViewModel: ViewModel() {

    private val repository: NotificationRepository = NotificationRepositoryImpl()

    val data = repository.getAll()

}