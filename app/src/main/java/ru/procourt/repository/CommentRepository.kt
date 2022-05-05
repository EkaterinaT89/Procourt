package ru.procourt.repository

import androidx.lifecycle.LiveData
import ru.procourt.dto.Comment
import ru.procourt.dto.News

interface CommentRepository {

    fun getAll(): LiveData<List<Comment>>

}