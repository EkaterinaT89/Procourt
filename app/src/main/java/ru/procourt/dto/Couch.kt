package ru.procourt.dto

data class Couch(
    override var id: Long,
    val name: String,
    val avatar: String? = null,
    val rank: String? = null,
    val clubId: Long? = null
): Search()