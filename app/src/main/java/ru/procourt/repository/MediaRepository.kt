package ru.procourt.repository

import androidx.lifecycle.LiveData
import ru.procourt.dto.Media
import ru.procourt.dto.News

interface MediaRepository {

    fun getAll(): LiveData<List<Media>>

}