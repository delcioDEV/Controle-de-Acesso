package cv.tryon.accesscontrol.data.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator

@Entity
class Device(
        @Id
        @GeneratedValue(generator = "system-uuid")
        @GenericGenerator(name = "system-uuid", strategy = "uuid") var id: String = "",

        var macAddress: String = "",
        var name: String = "",
        var model: String = "",

        @OneToMany(mappedBy = "device")
        var accessControlUser: MutableSet<AccessControlUser> = mutableSetOf(),

        @ManyToOne
        @JoinColumn(name = "entry_id", nullable = false)
        var entry: Entry = Entry()
)

