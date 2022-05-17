package ru.procourt.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.procourt.dto.Player
import ru.procourt.dto.User
import ru.procourt.enumeration.PersonalGender
import ru.procourt.enumeration.RoleType

class UserRepositoryImpl: UserRepository {

    private var nextId = 1L
    private var users = listOf(
        User(
            userId = nextId++,
            login = "login",
            name = "Иван",
            lastName = "Иванов",
            email = "email",
            phone = 123456789,
            password = "pass",
            roleType = RoleType.PARTNER,
            level = "level",
            isOnline = true,
            resultUserAge = 25,
            userLocation = "Moscow",
            gender = PersonalGender.MALE,
            personalPhoto = "photo",
            date = "10.03.2022",
            ratingValue = "1 место"
        ),
        User(
            userId = nextId++,
            login = "login",
            name = "Иван",
            lastName = "Иванов",
            email = "email",
            phone = 123456789,
            password = "pass",
            roleType = RoleType.PARTNER,
            level = "level",
            isOnline = false,
            resultUserAge = 25,
            userLocation = "Moscow",
            gender = PersonalGender.MALE,
            personalPhoto = "photo",
            date = "10.03.2022"
            ),
        User(
            userId = nextId++,
            login = "login",
            name = "Иван",
            lastName = "Иванов",
            email = "email",
            phone = 123456789,
            password = "pass",
            roleType = RoleType.PARTNER,
            level = "level",
            isOnline = true,
            resultUserAge = 25,
            userLocation = "Moscow",
            gender = PersonalGender.FEMALE,
            personalPhoto = "photo",
            date = "10.03.2022",
            ratingValue = "3 место"
            ),
        User(
            userId = nextId++,
            login = "login",
            name = "Иван",
            lastName = "Иванов",
            email = "email",
            phone = 123456789,
            password = "pass",
            roleType = RoleType.PARTNER,
            level = "level",
            isOnline = false,
            resultUserAge = 25,
            userLocation = "Moscow",
            gender = PersonalGender.FEMALE,
            personalPhoto = "photo",
            date = "10.03.2022",
            ratingValue = "1 место"
            ),
    ).reversed()

    private val data = MutableLiveData(users)

    override fun getAll(): LiveData<List<User>> = data

    override fun chooseTime(id: Long) {

    }

    override fun write(id: Long) {

    }

}