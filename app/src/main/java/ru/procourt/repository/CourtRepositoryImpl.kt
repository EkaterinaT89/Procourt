package ru.procourt.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.procourt.dto.Court
import ru.procourt.dto.News

class CourtRepositoryImpl: CourtRepository {

    private var nextId = 1L
    private var courts = listOf(
        Court(
            id = nextId++,
            clubId = 0,
            price = "от 500 руб./час",
            name = "Корт 1 ХАРД"
        ),
        Court(
            id = nextId++,
            clubId = 0,
            price = "от 500 руб./час",
            name = "Корт 1 ХАРД"
        ),
        Court(
            id = nextId++,
            clubId = 0,
            price = "от 500 руб./час",
            name = "Корт 1 ХАРД"
        ),
        Court(
            id = nextId++,
            clubId = 0,
            price = "от 500 руб./час",
            name = "Корт 1 ХАРД"
        ),
    ).reversed()

    private val data = MutableLiveData(courts)


    override fun onExpand() {

    }

    override fun onAutoBook() {

    }

    override fun getAll(): LiveData<List<Court>> = data

    override fun onChoose(id: Long) {

    }
}