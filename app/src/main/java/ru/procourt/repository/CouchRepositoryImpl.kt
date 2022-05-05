package ru.procourt.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.procourt.dto.Couch
import ru.procourt.dto.News
import ru.procourt.dto.Player

class CouchRepositoryImpl: CouchRepository {

    private var nextId = 1L
    private var couches = listOf(
        Couch(
            id = nextId++,
            name = "Иван Иванов",
            rank = "Мастер спорта"
        ),
        Couch(
            id = nextId++,
            name = "Иван Иванов",
            rank = "Мастер спорта"
        ),
        Couch(
            id = nextId++,
            name = "Иван Иванов",
            rank = "Мастер спорта"
        ),
        Couch(
            id = nextId++,
            name = "Иван Иванов",
            rank = "Мастер спорта"
        ),
        Couch(
            id = nextId++,
            name = "Иван Иванов",
            rank = "Мастер спорта"
        ),
        Couch(
            id = nextId++,
            name = "Иван Иванов",
            rank = "Мастер спорта"
        ),
    ).reversed()

    private val data = MutableLiveData(couches)

    override fun getAll(): LiveData<List<Couch>> = data

    override fun chooseTime(id: Long) {

    }

}