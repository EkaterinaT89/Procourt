package ru.procourt.viewModel

import ru.procourt.repository.UserRepository
import ru.procourt.repository.UserRepositoryImpl

class UserViewModel {

    private val repository: UserRepository = UserRepositoryImpl()

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