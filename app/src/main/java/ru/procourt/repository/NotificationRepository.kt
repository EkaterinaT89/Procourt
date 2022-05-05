package ru.procourt.repository

import androidx.lifecycle.LiveData
import ru.procourt.dto.Notification

interface NotificationRepository {

    fun getAll(): LiveData<List<Notification>>

}