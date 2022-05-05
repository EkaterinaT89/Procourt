package ru.procourt.repository

import androidx.lifecycle.LiveData
import ru.procourt.dto.Search
import ru.procourt.dto.Tournament

interface TournamentChildRepository {

    fun getAll(): LiveData<List<Tournament>>

    fun choose(id: Long)

}