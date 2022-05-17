package ru.procourt.dto

import ru.procourt.enumeration.PersonalGender
import ru.procourt.enumeration.RoleType

data class User (
    val userId: Long,
    val login: String,
//    val hash: String, - может и не надо, но в коде с сервера есть такое. Скорее всего типа токена.
    val name: String,
    val lastName: String,
    val email: String,
    val phone: Int,
    val password: String,
    val roleType: RoleType,
    val level: String? = null, /* enum??? */
    val isOnline: Boolean, /* на сервере нет, но может как то по другому называется? Это нужно для отображения он лайн или нет.  */
    val date: String, /* на сервере нет, но может как то по другому называется? Это нужно для отображения он лайн или нет.  */
    val resultUserAge: Int,
    val userLocation: String,
    val gender: PersonalGender,
    val personalPhoto: String,
    val ratingValue: String? = null, /* что это такое? пока использую для мест в турнирах */

//    если не получится с roleType, есть еще просто type, попробовать с ним.
        )