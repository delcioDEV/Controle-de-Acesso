package cv.tryon.accesscontrol.data.reposotories

import cv.tryon.accesscontrol.data.model.AccessControlUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface AccessControlUserRepository : JpaRepository<AccessControlUser, String>, JpaSpecificationExecutor<AccessControlUser>