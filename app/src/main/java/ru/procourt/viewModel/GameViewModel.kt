package ru.procourt.viewModel

import androidx.lifecycle.ViewModel
import ru.procourt.repository.*

class GameViewModel: ViewModel() {

    private val repository: GameRepository = GameRepositoryImpl()

    val data = repository.getAll()

}