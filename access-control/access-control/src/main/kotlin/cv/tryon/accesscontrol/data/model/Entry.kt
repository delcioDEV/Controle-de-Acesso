package cv.tryon.accesscontrol.data.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator

@Entity
class Entry(
        @Id
        @GeneratedValue(generator = "system-uuid")
        @GenericGenerator(name = "system-uuid", strategy = "uuid") var id: String = "",

        var userTag: String = "",
        var createdAt: String = "",
        var updatedAt: String = "",

        @OneToMany(mappedBy = "entry")
        var device : MutableSet <Device> = mutableSetOf()
)

