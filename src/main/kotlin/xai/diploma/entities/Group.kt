package xai.diploma.entities
import javax.persistence.*

@Entity
@Table(name = "groups")
data class Group (
        @Id @GeneratedValue
        @Column(name="group_id")
        val id: Int=0,
        val num: String,
        val specialty: String,
        val year: Int
)

/*@OneToMany(mappedBy = "group_id", cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
private var group_student: MutableList<Student>? = null*/
