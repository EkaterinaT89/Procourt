package ru.procourt.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.procourt.dto.Message
import ru.procourt.dto.News
import ru.procourt.dto.Player

class MessageRepositoryImpl: MessageRepository {

    private var nextId = 1L
    private var messages = listOf(
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

    private val data = MutableLiveData(messages)

    override fun getAll(): LiveData<List<Message>> = data

    override fun expand(id: Long) {

    }
}