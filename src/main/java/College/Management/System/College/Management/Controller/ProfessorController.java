package College.Management.System.College.Management.Controller;

import College.Management.System.College.Management.Entity.ProfessorEntity;
import College.Management.System.College.Management.Service.ProfessorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/professor")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    public ProfessorEntity createNewProfessor(@RequestBody ProfessorEntity professorEntity){
        return professorService.createNewProfessor(professorEntity);
    }

    @GetMapping(path = "/{professorId}")
    public ProfessorEntity getProfessorById(@PathVariable(name = "professorId") Long id){
        return professorService.getProfessorById(id);
    }

    @PutMapping(path = "/{professorId}/subject/{subjectId}")
    public ProfessorEntity assignProfessorToSubject(@PathVariable Long professorId,
                                                    @PathVariable Long subjectId){
        return professorService.assignProfessorToSubject(professorId , subjectId);
    }

    @PutMapping(path = "/{professorId}/student/{studentId}")
    public ProfessorEntity assignProfessorToStudent(@PathVariable Long professorId,
                                                    @PathVariable Long studentId){
        return professorService.assignProfessorToStudent(professorId,studentId);
    }
}
