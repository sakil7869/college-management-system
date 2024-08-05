package College.Management.System.College.Management.Service;

import College.Management.System.College.Management.Entity.StudentEntity;
import College.Management.System.College.Management.Entity.SubjectEntity;
import College.Management.System.College.Management.Repository.StudentRepository;
import College.Management.System.College.Management.Repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    public StudentService(StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    public StudentEntity createNewStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public StudentEntity getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public StudentEntity assignStudentToSubject(Long studentId, Long subjectId) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);
        Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subjectId);

        return studentEntity.flatMap(student ->
                subjectEntity.map(subject ->{
                    subject.getStudent().add(student);
                    student.getSubject().add(subject);
                     studentRepository.save(student);
                    return student;
                } )).orElse(null);
    }
}
