package ru.procourt.dto

data class Comment(
    val id: Long,
    val commentContent: String,
    val author: String,
    val date: String,
    val avatar: String? = null
)