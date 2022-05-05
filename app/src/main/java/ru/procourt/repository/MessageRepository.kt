package ru.procourt.repository

import androidx.lifecycle.LiveData
import ru.procourt.dto.Message
import ru.procourt.dto.Player

interface MessageRepository {

    fun getAll(): LiveData<List<Message>>

    fun expand(id: Long)
}