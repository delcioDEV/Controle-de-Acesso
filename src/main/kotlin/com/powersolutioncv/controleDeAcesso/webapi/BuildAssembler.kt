package com.powersolutioncv.controleDeAcesso.webapi

import com.powersolutioncv.controleDeAcesso.data.Build
import com.powersolutioncv.controleDeAcesso.domain.BuildController
import com.powersolutioncv.controleDeAcesso.webapi.model.BuildOutput
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.stereotype.Component

@Component
class BuildAssembler : RepresentationModelAssemblerSupport<Build, BuildOutput>(
    BuildController::class.java, BuildOutput::class.java
) {
    override fun toModel(build: Build): BuildOutput {
        val output = BuildOutput(
            owner = build.owner,
            location = build.location,
            registerDate = build.registerDate,
            registerTime = build.registerTime
        )

        output.add(
            WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(BuildController::class.java)
                    .getSpecificBuild(build.owner)
            ).withSelfRel()
        )

        return output
    }

//    override fun toCollectionModel(builds: Iterable<Build>): CollectionModel<BuildOutput> {
//        val outputList = builds.map { build -> toModel(build) }
//        val collectionModel = CollectionModel(outputList)
//        collectionModel.add(
//            WebMvcLinkBuilder.linkTo(BuildController::class.java).withSelfRel()
//        )
//        return collectionModel
//    }
}
