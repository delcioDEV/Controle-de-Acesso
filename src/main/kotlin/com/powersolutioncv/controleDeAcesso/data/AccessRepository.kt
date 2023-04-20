package com.powersolutioncv.controleDeAcesso.data


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
public interface AcessRepository : JpaRepository<Acesso, Long> {
    fun findByName(name: String): MutableList<Acesso>
}
