package com.powersolutioncv.controleDeAcesso.webapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EntityScan("com.powersolutioncv.controleDeAcesso.data")
@ComponentScan(basePackages = ["com.powersolutioncv.controleDeAcesso"])
@EnableJpaRepositories(basePackages = ["com.powersolutioncv.controleDeAcesso.data"])
class ControleDeAcessoApplication

fun main(args: Array<String>) {
    runApplication<ControleDeAcessoApplication>(*args)
}
