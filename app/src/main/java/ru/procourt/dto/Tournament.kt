package ru.procourt.dto

data class Tournament(
    val id: Long,
    val title: String,
    val rank: String,
    val price: String,
    val place: String,
    val level: String,
    val date: String,
    val partsNumber: Int,
    val maxPartsNumber: Int
) {
}