package ru.procourt.viewModel

import androidx.lifecycle.ViewModel
import ru.procourt.repository.PlayerRepository
import ru.procourt.repository.PlayerRepositoryImpl
import ru.procourt.repository.TournamentRepository
import ru.procourt.repository.TournamentRepositoryImpl

class TournamentViewModel: ViewModel() {

    private val repository: TournamentRepository = TournamentRepositoryImpl()

    val data = repository.getAll()

    fun choose(id: Long) {
        repository.choose(id)
    }
}