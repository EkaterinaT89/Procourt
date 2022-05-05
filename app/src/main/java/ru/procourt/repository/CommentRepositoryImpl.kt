package ru.procourt.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.procourt.dto.Comment
import ru.procourt.dto.News

class CommentRepositoryImpl: CommentRepository {

    private var nextId = 1L
    private var comments = listOf(
        Comment(
            id = nextId++,
            author = "Иван Иванов",
            commentContent = "Какой то текст",
            date = "18:36"
        ),
        Comment(
            id = nextId++,
            author = "Иван Иванов",
            commentContent = "Какой то текст",
            date = "18:36"
        ),
        Comment(
            id = nextId++,
            author = "Иван Иванов",
            commentContent = "Какой то текст",
            date = "18:36"
        ),
        Comment(
            id = nextId++,
            author = "Иван Иванов",
            commentContent = "Какой то текст",
            date = "18:36"
        ),
        Comment(
            id = nextId++,
            author = "Иван Иванов",
            commentContent = "Какой то текст",
            date = "18:36"
        ),
    ).reversed()

    private val CommentData = MutableLiveData(comments)

    override fun getAll(): LiveData<List<Comment>> = CommentData

}