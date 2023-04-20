package com.powersolutioncv.controleDeAcesso.webapi.model

import org.springframework.hateoas.RepresentationModel
import java.time.LocalDate
import java.time.LocalTime

open class acessoOutput(
    var uid: String,
    var name: String,
    var location: String,
    var nivel: Long,
    var registerDate: LocalDate,
    var registerTime: LocalTime

) : RepresentationModel<acessoOutput>()
