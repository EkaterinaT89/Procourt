package ru.procourt.dto

data class Scores (
    val gameId: Long,
    val participants: List<Player>,
    val scores: List<Int>
        )