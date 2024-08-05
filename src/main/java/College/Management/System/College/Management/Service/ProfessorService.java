package College.Management.System.College.Management.Service;

import College.Management.System.College.Management.Entity.ProfessorEntity;
import College.Management.System.College.Management.Entity.StudentEntity;
import College.Management.System.College.Management.Entity.SubjectEntity;
import College.Management.System.College.Management.Repository.ProfessorRepository;
import College.Management.System.College.Management.Repository.StudentRepository;
import College.Management.System.College.Management.Repository.SubjectRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;

    public ProfessorService(ProfessorRepository professorRepository, SubjectRepository subjectRepository, StudentRepository studentRepository) {
        this.professorRepository = professorRepository;
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
    }

    public ProfessorEntity createNewProfessor(ProfessorEntity professorEntity) {
        return professorRepository.save(professorEntity);
    }

    public ProfessorEntity getProfessorById(Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    public ProfessorEntity assignProfessorToSubject(Long professorId, Long subjectId) {
        Optional<ProfessorEntity> professorEntity = professorRepository.findById(professorId);
        Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subjectId);

        return professorEntity.flatMap(professor ->
                subjectEntity.map(subject -> {
                    subject.setProfessor(professor);
                    subjectRepository.save(subject);
                    professor.getSubjects().add(subject);
                    return professor;
                })).orElse(null);
    }

    public ProfessorEntity assignProfessorToStudent(Long professorId, Long studentId) {
        Optional<ProfessorEntity> professorEntity = professorRepository.findById(professorId);
        Optional<StudentEntity> studentEntity= studentRepository.findById(studentId);

        return professorEntity.flatMap(professor ->
                studentEntity.map(student ->{
                    student.getProfessor().add(professor);
                    professor.getStudent().add(student);
                    professorRepository.save(professor);
                    return professor;
                } )).orElse(null);
    }
}
