package ru.procourt.repository

import androidx.lifecycle.LiveData
import ru.procourt.dto.Player
import ru.procourt.dto.User

interface UserRepository {

    fun chooseTime(id: Long)

    fun write(id: Long)

    fun getAll(): LiveData<List<User>>

}