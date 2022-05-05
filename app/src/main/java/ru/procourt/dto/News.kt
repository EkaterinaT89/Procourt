package ru.procourt.dto

import ru.procourt.enumeration.AttachmentType

data class News(
    val id: Long,
    val author: String,
    val content: String,
    var shareVkCount: Long = 0,
    var shareFbCount: Long = 0,
    var shareOutCount: Long = 0,
    val date: String,
    var video: String? = null,
    var attachment: Attachment? = null,
    var comment: Comment? = null,
    val commentCount: Long = 0
)

data class Attachment(
    val url: String,
    val description: String?,
    val type: AttachmentType,
)