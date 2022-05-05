package ru.procourt.viewModel

import androidx.lifecycle.ViewModel
import ru.procourt.repository.DateRepository
import ru.procourt.repository.DateRepositoryImpl

class DateViewModel: ViewModel() {

    private val repository: DateRepository = DateRepositoryImpl()

    val data = repository.getAll()
}