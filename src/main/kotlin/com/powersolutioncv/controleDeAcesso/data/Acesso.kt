package com.powersolutioncv.controleDeAcesso.data

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.time.LocalDate
import java.time.LocalTime

@Entity
 class Acesso (
    @Id
    @GeneratedValue
    val id: Long = 0L,
    var uid: String = "",
    var name: String = "",
    var location: String = "",
    var nivel: Long = 0L,
    var registerDate: LocalDate = LocalDate.now(),
    var registerTime: LocalTime = LocalTime.now()
)