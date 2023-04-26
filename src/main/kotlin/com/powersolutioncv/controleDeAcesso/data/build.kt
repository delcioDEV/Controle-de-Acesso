package com.powersolutioncv.controleDeAcesso.data

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.time.LocalDate
import java.time.LocalTime

@Entity
class Build (
    @Id
    @GeneratedValue
    val id : Long= 0L,
    var location : String = "",
    var name : String = "",
    var owner : String = "",
    var registerDate : LocalDate = LocalDate.now(),
    var registerTime : LocalTime = LocalTime.now(),
    var updateTimeStamp : LocalDate = LocalDate.now()

)