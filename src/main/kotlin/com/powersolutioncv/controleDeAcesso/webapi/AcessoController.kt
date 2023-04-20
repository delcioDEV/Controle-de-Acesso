package com.powersolutioncv.controleDeAcesso.webapi

import com.powersolutioncv.controleDeAcesso.data.Acesso
import com.powersolutioncv.controleDeAcesso.domain.AccessoServices
import com.powersolutioncv.controleDeAcesso.webapi.model.AcessoInput
import com.powersolutioncv.controleDeAcesso.webapi.model.acessoOutput
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.CorsRegistry

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Configuration
class CorsConfig {
    @Bean
    fun corsConfigurer(): WebMvcConfigurer {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowedMethods("GET", "POST", "PUT", "DELETE")
                    .allowedHeaders("*")
            }
        }
    }
}


@RestController
@RequestMapping("/access")
class AcessoController(
    private val service: AccessoServices
) {


    @GetMapping("/showAll")
    fun getAllUsers(): MutableList<Acesso> {
        return service.getAllusers()

    }

    @PostMapping("/createUser")
    fun createUser(
        @RequestBody accessInput: AcessoInput
    ): String {
        return service.createUser(accessInput)
    }


    @GetMapping("/specific/{id}")
    fun getSpecific(@PathVariable id: Long): acessoOutput {
        return service.getSpecific(id)
    }

    @PostMapping("/update/{name}")
    fun updateUser(@PathVariable name: String, @RequestBody user: AcessoInput): Any {

        return service.updateuser(name, user)
    }

    @PostMapping("/grantAccess/{id}")
    fun grant(@PathVariable id: Long): String {
        return service.grant(id)
    }


}
