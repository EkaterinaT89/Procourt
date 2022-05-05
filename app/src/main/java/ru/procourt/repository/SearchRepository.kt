package ru.procourt.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.procourt.dto.Club
import ru.procourt.dto.Player
import ru.procourt.dto.Search

class SearchRepository {

    private var nextId = 1L
    private var playersAndClubs = listOf(
        Club (
            id = nextId++,
            name = "Club",
            location = "location"
        ),
        Player(
            id = nextId++,
            name = "Иван Иванов",
            rank = "Мастер спорта"
        ),
        Player(
            id = nextId++,
            name = "Иван Иванов",
            rank = "Мастер спорта"
        ),
        Player(
            id = nextId++,
            name = "Иван Иванов",
            rank = "Мастер спорта"
        ),
        Player(
            id = nextId++,
            name = "Иван Иванов",
            rank = "Мастер спорта"
        ),
        Club (
            id = nextId++,
            name = "Club",
            location = "location"
        ),
        Player(
            id = nextId++,
            name = "Иван Иванов",
            rank = "Мастер спорта"
        ),
        Player(
            id = nextId++,
            name = "Иван Иванов",
            rank = "Мастер спорта"
        ),
    ).reversed()

    private val data = MutableLiveData(playersAndClubs)

    fun getAll(): LiveData<List<Search>> = data

}