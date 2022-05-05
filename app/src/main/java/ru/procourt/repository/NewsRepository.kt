package ru.procourt.repository

import androidx.lifecycle.LiveData
import ru.procourt.dto.News

interface NewsRepository {

    fun getAll(): LiveData<List<News>>

    fun shareVkById(id: Long)

    fun shareFbById(id: Long)

    fun shareOutById(id: Long)


}