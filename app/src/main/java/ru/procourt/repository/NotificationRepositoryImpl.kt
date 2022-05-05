package ru.procourt.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.procourt.dto.Message
import ru.procourt.dto.News
import ru.procourt.dto.Notification
import ru.procourt.dto.Player

class NotificationRepositoryImpl: NotificationRepository {

    private var nextId = 1L
    private var notifications = listOf(
        Notification(
            id = nextId++,
            senderId = nextId++,
            senderName = "Иван Иванов",
            content = "Some text",
            date = "25.12.2018"
        ),
        Notification(
            id = nextId++,
            senderId = nextId++,
            senderName = "Иван Иванов",
            content = "Some text",
            date = "25.12.2018"
        ),
        Notification(
            id = nextId++,
            senderId = nextId++,
            senderName = "Иван Иванов",
            content = "Some text",
            date = "25.12.2018"
        ),
        Notification(
            id = nextId++,
            senderId = nextId++,
            senderName = "Иван Иванов",
            content = "Some text",
            date = "25.12.2018"
        ),
        Notification(
            id = nextId++,
            senderId = nextId++,
            senderName = "Иван Иванов",
            content = "Some text",
            date = "25.12.2018"
        ),
        Notification(
            id = nextId++,
            senderId = nextId++,
            senderName = "Иван Иванов",
            content = "Some text",
            date = "25.12.2018"
        ),
    ).reversed()

    private val data = MutableLiveData(notifications)

    override fun getAll(): LiveData<List<Notification>> = data

}