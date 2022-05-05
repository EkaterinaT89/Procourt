package ru.procourt.repository

import androidx.lifecycle.LiveData
import ru.procourt.dto.Chat
import ru.procourt.dto.Game
import ru.procourt.dto.Message
import ru.procourt.dto.Player

interface GameRepository {

    fun getAll(): LiveData<List<Game>>

}