package College.Management.System.College.Management.Controller;

import College.Management.System.College.Management.Entity.StudentEntity;
import College.Management.System.College.Management.Service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentEntity createNewStudent(@RequestBody StudentEntity studentEntity){
        return studentService.createNewStudent(studentEntity);
    }

    @GetMapping(path = "/{studentId}")
    public StudentEntity getStudentById(@PathVariable(name = "studentId") Long id){
        return studentService.getStudentById(id);
    }

    @PutMapping("/{studentId}/subject/{subjectId}")
    public StudentEntity assignStudentToSubject(@PathVariable Long studentId,
                                                   @PathVariable Long subjectId){
        return studentService.assignStudentToSubject(studentId,subjectId);
    }
}
