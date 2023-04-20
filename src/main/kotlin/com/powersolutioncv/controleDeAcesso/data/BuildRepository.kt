package com.powersolutioncv.controleDeAcesso.data

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BuildRepository : JpaRepository<Build, Long> {
    fun findByOwner(owner: String): MutableList<Build>
}
