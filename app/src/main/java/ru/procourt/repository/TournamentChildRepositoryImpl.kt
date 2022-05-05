package ru.procourt.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.procourt.dto.Player
import ru.procourt.dto.Tournament

class TournamentChildRepositoryImpl: TournamentChildRepository {

    private var nextId = 1L
    private var tournaments = listOf(
        Tournament(
            id = nextId++,
            title = "Tournament title",
            rank = "Парный женский",
            place = "Клуб Коломенский",
            price = "4 000 руб.",
            level = "Средний",
            date = "01.01.2022",
            maxPartsNumber = 20,
            partsNumber = 5
        ),
        Tournament(
            id = nextId++,
            title = "Tournament title",
            rank = "Парный женский",
            place = "Клуб Коломенский",
            price = "4 000 руб.",
            level = "Средний",
            date = "01.01.2022",
            maxPartsNumber = 20,
            partsNumber = 20
        ),
        Tournament(
            id = nextId++,
            title = "Tournament title",
            rank = "Парный женский",
            place = "Клуб Коломенский",
            price = "4 000 руб.",
            level = "Средний",
            date = "01.01.2022",
            maxPartsNumber = 20,
            partsNumber = 15
        ),
        Tournament(
            id = nextId++,
            title = "Tournament title",
            rank = "Парный женский",
            place = "Клуб Коломенский",
            price = "4 000 руб.",
            level = "Средний",
            date = "01.01.2022",
            maxPartsNumber = 20,
            partsNumber = 1
        ),
    ).reversed()

    private val data = MutableLiveData(tournaments)

    override fun getAll(): LiveData<List<Tournament>> = data

    override fun choose(id: Long) {

    }
}