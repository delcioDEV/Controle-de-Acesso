package com.powersolutioncv.controleDeAcesso.webapi.model

import java.time.LocalDate
import java.time.LocalTime


class AcessoInput (
    var name: String = "",
    var uid: String ="",
    var location: String = "",
    var nivel: Long = 0L,
    var  registerDate: LocalDate = LocalDate.now(),
    var  registerTime: LocalTime = LocalTime.now()
)