package com.powersolutioncv.controleDeAcesso.webapi

import com.powersolutioncv.controleDeAcesso.data.Acesso
import com.powersolutioncv.controleDeAcesso.webapi.model.acessoOutput
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.stereotype.Component


@Component
class AcessoAssemble : RepresentationModelAssemblerSupport<Acesso, acessoOutput>(
    AcessoController::class.java, acessoOutput::class.java
) {
    override fun toModel(entity: Acesso): acessoOutput {
        return acessoOutput(
            uid = entity.uid,
            name = entity.name,
            location = entity.location,
            nivel = entity.nivel,
            registerDate = entity.registerDate,
            registerTime = entity.registerTime
        ).apply {
            this.add(
                WebMvcLinkBuilder.linkTo(
                    WebMvcLinkBuilder.methodOn(AcessoController::class.java)
                        .getSpecific(entity.id)
                ).withSelfRel()
            )
        }
    }
}