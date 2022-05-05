package ru.procourt.dto

data class Message (
    override val id: Long,
    val senderId: Long,
    val senderName: String,
    val content: String,
    val date: String,
    var isMine: Boolean,
    val time: String
        ): Chat()

