package College.Management.System.College.Management.Controller;

import College.Management.System.College.Management.Entity.StudentEntity;
import College.Management.System.College.Management.Entity.SubjectEntity;
import College.Management.System.College.Management.Service.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@RestController
@RequestMapping(path = "subject")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping
    public SubjectEntity createNewSubject(@RequestBody SubjectEntity subjectEntity){
        return subjectService.createNewSubject(subjectEntity);
    }

    @GetMapping(path = "/{subjectId}")
    public SubjectEntity getSubjectById(@PathVariable(name = "createNewSubject") Long id){
        return subjectService.getSubjectById(id);
    }
}
