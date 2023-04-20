package com.powersolutioncv.controleDeAcesso.domain

import com.powersolutioncv.controleDeAcesso.data.Build
import com.powersolutioncv.controleDeAcesso.data.BuildRepository
import com.powersolutioncv.controleDeAcesso.webapi.BuildAssembler
import com.powersolutioncv.controleDeAcesso.webapi.model.BuildInput
import com.powersolutioncv.controleDeAcesso.webapi.model.BuildOutput
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalTime

@Service
class BuildServices(
    private val repository: BuildRepository,
    private val assembler: BuildAssembler,
) {
    fun getSpecificBuild(owner: String): BuildOutput {
        val buildExist = repository.findByOwner(owner).firstOrNull() ?: throw IllegalArgumentException("Build not found")
        return assembler.toModel(buildExist)
    }

    fun updateBuild(owner: String, buildInput: BuildInput): BuildOutput {
        val build = repository.findByOwner(owner).firstOrNull() ?: throw IllegalArgumentException("Build not found")
        build.owner = buildInput.owner ?: build.owner
        build.location = buildInput.location ?: build.location
        build.registerDate = buildInput.registerDate ?: build.registerDate
        build.registerTime = buildInput.registerTime ?: build.registerTime
        repository.save(build)
        return assembler.toModel(build)
    }

    fun getAllBuild(): List<BuildOutput> {
        val builds = repository.findAll()
        return builds.map { assembler.toModel(it) }
    }

    fun createBuild(buildInput: BuildInput): String {
        val build = Build(
            owner = buildInput.owner ?: "",
            buildName = buildInput.buildName ?:"",
            location = buildInput.location ?: "",
            registerDate = buildInput.registerDate ?: LocalDate.now(),
            registerTime = buildInput.registerTime ?: LocalTime.now()
        )
        repository.save(build)
        return "Build created successfully"
    }
}
