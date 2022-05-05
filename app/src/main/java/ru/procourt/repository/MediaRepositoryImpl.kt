package ru.procourt.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.procourt.dto.Media
import ru.procourt.dto.News

class MediaRepositoryImpl: MediaRepository {

    private var nextId = 1L
    private var media = listOf(
        Media(
            id = nextId++
        ),
        Media(
            id = nextId++
        ),
        Media(
            id = nextId++
        ),
        Media(
            id = nextId++
        ),
        Media(
            id = nextId++
        ),
        Media(
            id = nextId++
        ),
    ).reversed()

    private val data = MutableLiveData(media)

    override fun getAll(): LiveData<List<Media>> = data
}