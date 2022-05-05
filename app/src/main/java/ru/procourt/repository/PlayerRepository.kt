package ru.procourt.repository

import androidx.lifecycle.LiveData
import ru.procourt.dto.Player

interface PlayerRepository {

    fun chooseTime(id: Long)

    fun write(id: Long)

    fun getAll(): LiveData<List<Player>>

}