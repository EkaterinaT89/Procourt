package ru.procourt.dto

data class Game(
    val id: Long,
    val isEnd: Boolean,
    val playerOne: Player,
    val playerTwo: Player,
    val playeOneScore: Int,
    val playerTwoScore: Int,
    val gameDate: String,
    val gameLasts: String
)