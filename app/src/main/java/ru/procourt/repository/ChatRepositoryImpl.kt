package ru.procourt.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.procourt.dto.*

class ChatRepositoryImpl: ChatRepository {

    private var nextId = 1L
    private var chat = listOf(
        Message(
            id = nextId++,
            senderId = nextId++,
            senderName = "Иван Иванов",
            content = "Some text",
            date = "25.12.2018",
            isMine = true,
            time = "10:45"
        ),
        SentDate(
            id = nextId++,
            whenSent = "Вчера"
        ),
        Message(
            id = nextId++,
            senderId = nextId++,
            senderName = "Иван Иванов",
            content = "Some text",
            date = "25.12.2018",
            isMine = false,
            time = "10:45"
        ),
        Message(
            id = nextId++,
            senderId = nextId++,
            senderName = "Иван Иванов",
            content = "Some text",
            date = "25.12.2018",
            isMine = true,
            time = "10:45"
        ),
        Message(
            id = nextId++,
            senderId = nextId++,
            senderName = "Иван Иванов",
            content = "Some text",
            date = "25.12.2018",
            isMine = false,
            time = "10:45"
        ),
        SentDate(
            id = nextId++,
            whenSent = "Сегодня"
        ),
        Message(
            id = nextId++,
            senderId = nextId++,
            senderName = "Иван Иванов",
            content = "Some text",
            date = "25.12.2018",
            isMine = true,
            time = "10:45"
        ),
        Message(
            id = nextId++,
            senderId = nextId++,
            senderName = "Иван Иванов",
            content = "Some text",
            date = "25.12.2018",
            isMine = false,
            time = "10:45"
        ),
    ).reversed()

    private val data = MutableLiveData(chat)

    override fun getAll(): LiveData<List<Chat>> = data

}