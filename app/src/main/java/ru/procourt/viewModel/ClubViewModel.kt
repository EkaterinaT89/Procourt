package ru.procourt.viewModel

import androidx.lifecycle.ViewModel
import ru.procourt.repository.ClubRepository
import ru.procourt.repository.ClubRepositoryImpl
import ru.procourt.repository.PlayerRepository
import ru.procourt.repository.PlayerRepositoryImpl

class ClubViewModel: ViewModel() {

    private val repository: ClubRepository = ClubRepositoryImpl()

    val data = repository.getAll()

    fun loadClubs() {
        repository.getAll()
    }

    fun chooseTime(id: Long) {
        repository.chooseTime(id)
    }

}