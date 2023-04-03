package cv.tryon.accesscontrol

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AccessControlApplication

fun main(args: Array<String>) {
	runApplication<AccessControlApplication>(*args)
}
