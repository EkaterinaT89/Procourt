package ru.procourt.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.procourt.dto.Club
import ru.procourt.dto.Player

class ClubRepositoryImpl: ClubRepository {

    private var nextId = 1L
    private var clubs = listOf(
        Club(
            id = nextId++,
            name = "Клуб Коломенский",
            location = "2 км. Коломенская наб. д. 20",
            hasLight = true,
            hasMassage = false,
            hasSauna = true,
            hasShower = false
        ),
        Club(
            id = nextId++,
            name = "Клуб Коломенский",
            location = "2 км. Коломенская наб. д. 20"
        ),
        Club(
            id = nextId++,
            name = "Клуб Коломенский",
            location = "2 км. Коломенская наб. д. 20"
        ),
        Club(
            id = nextId++,
            name = "Клуб Коломенский",
            location = "2 км. Коломенская наб. д. 20"
        ),
        Club(
            id = nextId++,
            name = "Клуб Коломенский",
            location = "2 км. Коломенская наб. д. 20"
        ),
        Club(
            id = nextId++,
            name = "Клуб Коломенский",
            location = "2 км. Коломенская наб. д. 20",
            hasLight = false,
            hasMassage = true,
            hasSauna = true,
            hasShower = false
        ),
    ).reversed()

    private val data = MutableLiveData(clubs)

    override fun getAll(): LiveData<List<Club>> = data

    override fun chooseTime(id: Long) {

    }

}