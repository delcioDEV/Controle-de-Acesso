package com.powersolutioncv.controleDeAcesso.webapi


import com.powersolutioncv.controleDeAcesso.domain.BuildServices
import com.powersolutioncv.controleDeAcesso.webapi.model.BuildInput
import com.powersolutioncv.controleDeAcesso.webapi.model.BuildOutput
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/builds")
class BuildController(
    private val service: BuildServices
) {

    @GetMapping("/showAll")
    fun getAllBuild(): List<BuildOutput> {
        return service.getAllBuild()
    }

    @GetMapping("/specific/{owner}")
    fun getSpecificBuild(@PathVariable owner: String): BuildOutput {
        return service.getSpecificBuild(owner)
    }

    @PutMapping("/specific/{owner}")
    fun updateBuild(
        @PathVariable owner: String,
        @RequestBody buildInput: BuildInput
    ): BuildOutput {
        return service.updateBuild(owner, buildInput)
    }

    @PostMapping("/create")
    fun createBuild(@RequestBody buildInput: BuildInput): String {
        return service.createBuild(buildInput)
    }


}
