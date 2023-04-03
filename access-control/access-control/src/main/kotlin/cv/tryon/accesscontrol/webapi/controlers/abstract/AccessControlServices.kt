package cv.tryon.accesscontrol.webapi.controlers.abstract

import org.springframework.data.jpa.repository.JpaRepository

interface AccessControlServices<Input, Output> {

    fun create(intput: Input): Output

    fun find(id : String): Output

}
