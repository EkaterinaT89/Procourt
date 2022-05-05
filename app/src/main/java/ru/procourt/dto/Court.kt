package ru.procourt.dto

data class Court(
    val id: Long,
    val clubId: Long,
    val price: String,
    val name: String
) {
}