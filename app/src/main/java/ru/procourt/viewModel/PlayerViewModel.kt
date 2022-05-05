package ru.procourt.viewModel

import androidx.lifecycle.ViewModel
import ru.procourt.repository.NewsRepository
import ru.procourt.repository.NewsRepositoryImpl
import ru.procourt.repository.PlayerRepository
import ru.procourt.repository.PlayerRepositoryImpl

class PlayerViewModel: ViewModel() {

    private val repository: PlayerRepository = PlayerRepositoryImpl()

    val data = repository.getAll()

    fun chooseTime(id: Long) {
        repository.chooseTime(id)
    }

    fun loadPlayers() {
        repository.getAll()
    }

    fun write(id: Long) {
        repository.write(id)
    }

}