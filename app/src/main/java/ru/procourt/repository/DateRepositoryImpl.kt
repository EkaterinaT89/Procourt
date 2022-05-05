package ru.procourt.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.procourt.dto.Date
import ru.procourt.dto.Media
import ru.procourt.dto.News

class DateRepositoryImpl: DateRepository {

    private var nextId = 1L
    private var media = listOf(
        Date(
            id = nextId++,
            hour = "4 ч",
            dayOfWeek = "Пн",
            number = 5
        ),
        Date(
            id = nextId++,
            hour = "3 ч",
            dayOfWeek = "Пн",
            number = 8
        ),
        Date(
            id = nextId++,
            hour = "4 ч",
            dayOfWeek = "Пн",
            number = 5
        ),
        Date(
            id = nextId++,
            hour = "4 ч",
            dayOfWeek = "Пн",
            number = 10
        ),
        Date(
            id = nextId++,
            hour = "3 ч",
            dayOfWeek = "Пн",
            number = 8
        ),
        Date(
            id = nextId++,
            hour = "3 ч",
            dayOfWeek = "Пн",
            number = 8
        ),
    ).reversed()

    private val data = MutableLiveData(media)

    override fun getAll(): LiveData<List<Date>> = data
}