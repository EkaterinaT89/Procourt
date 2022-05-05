package ru.procourt.repository

import androidx.lifecycle.LiveData
import ru.procourt.dto.Date
import ru.procourt.dto.Media
import ru.procourt.dto.News

interface DateRepository {

    fun getAll(): LiveData<List<Date>>

}