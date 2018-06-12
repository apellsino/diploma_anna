package xai.diploma.сontrollers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import xai.diploma.entities.Student
import xai.diploma.entities.User
import xai.diploma.repositories.CourseRepository
import xai.diploma.repositories.StudentRepository
import xai.diploma.repositories.UserRepository

@RestController
@RequestMapping("/api/doc")
class DocController(val courseRepository: CourseRepository,
                    val studentRepository: StudentRepository,
                    val userRepository: UserRepository) {

    @GetMapping("/{name}/{group_id}")
    fun getDoc(@PathVariable name:String, @PathVariable group_id:Int): Iterable<User> {
        val course = courseRepository.findByname(name).first()
        val students = studentRepository.findBygroupid(group_id)

        val users = students.map { userRepository.findByid(it.userid).first() }

        return users
    }

}