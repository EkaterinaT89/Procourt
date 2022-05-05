package ru.procourt.viewModel

import androidx.lifecycle.ViewModel
import ru.procourt.repository.*

class TournamentChildViewModel: ViewModel() {

    private val repository: TournamentChildRepository = TournamentChildRepositoryImpl()

    val data = repository.getAll()

    fun choose(id: Long) {
        repository.choose(id)
    }

}