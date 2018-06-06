package xai.diploma.entities

import com.vladmihalcea.hibernate.type.json.JsonBinaryType
import com.vladmihalcea.hibernate.type.json.JsonStringType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import org.hibernate.annotations.TypeDefs
import javax.persistence.*
import kotlin.Enum

@TypeDefs(TypeDef(name = "json", typeClass = JsonStringType::class),
        TypeDef(name = "jsonb", typeClass = JsonBinaryType::class))
@Entity
@Table(name = "studies")
data class Study(
        @Id @GeneratedValue
        val study_id: Int = 0,
        @Column(name="user_id")
        val user: Int,
        @Column(name="student_id")
        val student: Int,
        @Column(name="course_id")
        val course: Int,
        @Type(type = "json")
        @Column(columnDefinition = "json")
        val modules: Map<String, String>,
        @Type(type = "json")
        @Column(columnDefinition = "json")
        val lectures: Map<String, String>,
        @Type(type = "json")
        @Column(columnDefinition = "json")
        val labs: Map<String, String>,
        @Type(type = "json")
        @Column(columnDefinition = "json")
        val pract: Map<String, String>,
        val control: Int,
        val mark: Int,
        @Enumerated(EnumType.STRING)
        val pass: Pass
) {

    enum class Pass (val value: String){
        DROPPED("Не допущен"),
        PASSED("Зачтено"),
        FAILED("Не зачтено")
    }

}

/*@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "user_id")
private var study_user: User? = null

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "student_id")
private var study_student: Student? = null

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "course_id")
private var study_course: Course? = null*/