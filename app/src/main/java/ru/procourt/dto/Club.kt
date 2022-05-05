package ru.procourt.dto

data class Club (
    override val id: Long,
    val name: String,
    val location: String,
    val image: String? = null,
    val hasShower: Boolean? = null,
    val hasLight: Boolean? = null,
    val hasSauna: Boolean? = null,
    val hasMassage: Boolean? = null,

) : Search() {

}