package ru.procourt.viewModel

import androidx.lifecycle.ViewModel
import ru.procourt.repository.MediaRepository
import ru.procourt.repository.MediaRepositoryImpl

class MediaViewModel: ViewModel() {

    private val repository: MediaRepository = MediaRepositoryImpl()

    val data = repository.getAll()
}