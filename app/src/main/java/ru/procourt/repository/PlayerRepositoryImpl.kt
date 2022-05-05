package ru.procourt.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.procourt.dto.News
import ru.procourt.dto.Player

class PlayerRepositoryImpl: PlayerRepository {

    private var nextId = 1L
    private var players = listOf(
        Player(
            id = nextId++,
            name = "Иван Иванов",
            rank = "Мастер спорта",
            isOnline = true
        ),
        Player(
            id = nextId++,
            name = "Иван Иванов",
            rank = "Мастер спорта",
            isOnline = false,
            date = "10.04.2022"
        ),
        Player(
            id = nextId++,
            name = "Иван Иванов",
            rank = "Мастер спорта",
            date = "10.04.2022"
        ),
        Player(
            id = nextId++,
            name = "Иван Иванов",
            rank = "Мастер спорта",
            date = "10.04.2022"
        ),
        Player(
            id = nextId++,
            name = "Иван Иванов",
            rank = "Мастер спорта",
            date = "10.04.2022"
        ),
        Player(
            id = nextId++,
            name = "Иван Иванов",
            rank = "Мастер спорта",
            date = "10.04.2022"
        ),
    ).reversed()

    private val data = MutableLiveData(players)

    override fun getAll(): LiveData<List<Player>> = data

    override fun chooseTime(id: Long) {

    }

    override fun write(id: Long) {

    }

}