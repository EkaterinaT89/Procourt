package ru.procourt.dto

data class Notification (
    val id: Long,
    val senderId: Long,
    val senderName: String,
    val content: String,
    val date: String
        )

