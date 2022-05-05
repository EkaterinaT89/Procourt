package ru.procourt.repository

import androidx.lifecycle.LiveData
import ru.procourt.dto.Couch
import ru.procourt.dto.Player

interface CouchRepository {

    fun chooseTime(id: Long)

    fun getAll(): LiveData<List<Couch>>

}