package ru.procourt.repository

import androidx.lifecycle.LiveData
import ru.procourt.dto.Club

interface ClubRepository {

    fun getAll(): LiveData<List<Club>>

    fun chooseTime(id: Long)
}