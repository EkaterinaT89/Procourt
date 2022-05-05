package ru.procourt.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.procourt.repository.CommentRepository
import ru.procourt.repository.CommentRepositoryImpl
import ru.procourt.repository.NewsRepository
import ru.procourt.repository.NewsRepositoryImpl

class CommentViewModel: ViewModel() {

    private val CommentRepository: CommentRepository = CommentRepositoryImpl()

    val data = CommentRepository.getAll()

    fun addComment() {}

}