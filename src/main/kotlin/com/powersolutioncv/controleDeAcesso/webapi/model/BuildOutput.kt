package com.powersolutioncv.controleDeAcesso.webapi.model

import org.springframework.hateoas.RepresentationModel
import java.time.LocalDate
import java.time.LocalTime

open class BuildOutput(

        var owner: String,
        var location: String,
        var registerDate: LocalDate,
        var registerTime: LocalTime

    ) : RepresentationModel<BuildOutput>()
