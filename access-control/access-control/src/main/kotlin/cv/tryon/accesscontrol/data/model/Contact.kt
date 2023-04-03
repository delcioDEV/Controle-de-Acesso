package cv.tryon.accesscontrol.data.model

import jakarta.persistence.Embeddable
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.GenericGenerator

@Embeddable
class Contact(
        var phoneNumber: String = "",
        var adrres: String = "",
        var email: String = "",
)
