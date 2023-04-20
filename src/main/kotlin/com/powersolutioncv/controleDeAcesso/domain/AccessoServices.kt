package com.powersolutioncv.controleDeAcesso.domain

import com.powersolutioncv.controleDeAcesso.data.AcessRepository
import com.powersolutioncv.controleDeAcesso.data.Acesso
import com.powersolutioncv.controleDeAcesso.webapi.AcessoAssemble
import com.powersolutioncv.controleDeAcesso.webapi.model.AcessoInput
import com.powersolutioncv.controleDeAcesso.webapi.model.acessoOutput
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalTime

@Service
class AccessoServices(
    private val repository: AcessRepository,
    private val assembler: AcessoAssemble,
) {
    fun getSpecific(id: Long): acessoOutput {
        val userExist = repository.findById(id).orElseThrow()

        return assembler.toModel(userExist)
    }

    fun updateuser(name: String, user: AcessoInput): Any {
        val acesso = repository.findByName(name).first() //?: return "User not found"
        if (user.name.isEmpty()) user.name = acesso.name
        if (user.uid.isEmpty()) user.uid = acesso.uid
        if (user.location.isEmpty()) user.location = acesso.location
        if (user.nivel == 0L) user.nivel = acesso.nivel
        acesso.apply {
            acesso.name = user.name
            acesso.uid = user.uid
            acesso.location = user.location
            acesso.nivel = user.nivel
            acesso.registerDate = user.registerDate
            acesso.registerTime = user.registerTime
        }
        return repository.save(acesso)
        return assembler.toModel(acesso)
    }


    fun getAllusers(): MutableList<Acesso> {
        return repository.findAll()
    }


    fun createUser(
        accessInput: AcessoInput
    ): String {
        val user = Acesso()
        user.name = accessInput.name
        user.uid = accessInput.uid
        user.location = accessInput.location
        user.nivel = accessInput.nivel
        user.registerDate = LocalDate.now()
        user.registerTime = LocalTime.now()
        repository.save(user)
        return "Success"
    }

    fun grant(id: Long): String {
        val acesso = repository.findById(id)

        return if (acesso.isPresent) {
            "Access Granted"
        } else {
            "User does not exist"
        }
    }

}
