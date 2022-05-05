package ru.procourt.dto

data class Player(
    override var id: Long,
    val name: String,
    val avatar: String? = null,
    val date: String? = null,
    val rank: String? = null,
    val clubId: Long? = null,
    val isOnline: Boolean? = null
): Search()