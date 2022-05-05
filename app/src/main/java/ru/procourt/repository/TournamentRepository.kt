package ru.procourt.repository

import androidx.lifecycle.LiveData
import ru.procourt.dto.Search
import ru.procourt.dto.Tournament

interface TournamentRepository {

    fun getAll(): LiveData<List<Tournament>>

    fun choose(id: Long)

}