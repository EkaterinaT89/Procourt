package ru.procourt.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.procourt.dto.*

class GameRepositoryImpl: GameRepository {

    private var nextId = 1L
    private var games = listOf(
        Game(
            id = nextId++,
            isEnd = true,
            playerOne = Player(1, "Иван Иванов"),
            playeOneScore = 4,
            playerTwo = Player(1, "Иван Иванов"),
            playerTwoScore = 3,
            gameDate = "Сегодня",
            gameLasts = "30 минут"
        ),
        Game(
            id = nextId++,
            isEnd = false,
            playerOne = Player(1, "Иван Иванов"),
            playeOneScore = 8,
            playerTwo = Player(1, "Иван Иванов"),
            playerTwoScore = 10,
            gameDate = "30 ноября 2021",
            gameLasts = "30 минут"
        ),
        Game(
            id = nextId++,
            isEnd = true,
            playerOne = Player(1, "Иван Иванов"),
            playeOneScore = 5,
            playerTwo = Player(1, "Иван Иванов"),
            playerTwoScore = 8,
            gameDate = "Сегодня",
            gameLasts = "25 минут"
        ),
        Game(
            id = nextId++,
            isEnd = false,
            playerOne = Player(1, "Иван Иванов"),
            playeOneScore = 14,
            playerTwo = Player(1, "Иван Иванов"),
            playerTwoScore = 30,
            gameDate = "Сегодня",
            gameLasts = "30 минут"
        ),
        Game(
            id = nextId++,
            isEnd = true,
            playerOne = Player(1, "Иван Иванов"),
            playeOneScore = 4,
            playerTwo = Player(1, "Иван Иванов"),
            playerTwoScore = 3,
            gameDate = "Сегодня",
            gameLasts = "30 минут"
        ),
    ).reversed()

    private val data = MutableLiveData(games)

    override fun getAll(): LiveData<List<Game>> = data

}