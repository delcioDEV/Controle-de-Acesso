package com.powersolutioncv.controleDeAcesso.webapi.model

import java.time.LocalDate
import java.time.LocalTime

class BuildInput {
    var owner: String = ""
    var buildName : String = ""
    var location: String = ""
    var registerDate: LocalDate = LocalDate.now()
    var registerTime: LocalTime = LocalTime.now()
}
