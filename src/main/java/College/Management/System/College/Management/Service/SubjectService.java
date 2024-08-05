package College.Management.System.College.Management.Service;

import College.Management.System.College.Management.Entity.StudentEntity;
import College.Management.System.College.Management.Entity.SubjectEntity;
import College.Management.System.College.Management.Repository.SubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public SubjectEntity createNewSubject(SubjectEntity subjectEntity) {
        return subjectRepository.save(subjectEntity);
    }

    public SubjectEntity getSubjectById(Long id) {
        return subjectRepository.findById(id).orElse(null);
    }
}
