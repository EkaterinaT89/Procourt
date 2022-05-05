package ru.procourt.dto

data class SentDate(
    val whenSent: String,
    override val id: Long
) : Chat()
