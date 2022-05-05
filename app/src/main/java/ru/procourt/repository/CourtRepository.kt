package ru.procourt.repository

import androidx.lifecycle.LiveData
import ru.procourt.dto.Court
import ru.procourt.dto.Player

interface CourtRepository {

    fun onExpand()

    fun onAutoBook()

    fun getAll(): LiveData<List<Court>>

    fun onChoose(id: Long)


}