package College.Management.System.College.Management.Service;

import College.Management.System.College.Management.Entity.AdmissionRecordEntity;
import College.Management.System.College.Management.Entity.StudentEntity;
import College.Management.System.College.Management.Repository.AdmissionRecordRepository;
import College.Management.System.College.Management.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdmissionRecordService {

    private final AdmissionRecordRepository admissionRecordRepository;
    private final StudentRepository studentRepository;

    public AdmissionRecordService(AdmissionRecordRepository admissionRecordRepository, StudentRepository studentRepository) {
        this.admissionRecordRepository = admissionRecordRepository;
        this.studentRepository = studentRepository;
    }

    public Optional<AdmissionRecordEntity> getAdmissionRecordById(Long id) {
        return admissionRecordRepository.findById(id);
    }

    public AdmissionRecordEntity createNewAdmissionRecord(AdmissionRecordEntity admissionRecordEntity) {
        return admissionRecordRepository.save(admissionRecordEntity);
    }

    public AdmissionRecordEntity admissionRecord(Long admissionRecordId, Long studentId) {
        Optional<AdmissionRecordEntity> admissionRecordEntity = admissionRecordRepository.findById(admissionRecordId);
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);

        return admissionRecordEntity.flatMap(admissionRecordEntity1 ->
                studentEntity.map(studentEntity1 -> {
                    admissionRecordEntity1.setStudent(studentEntity1);
                    return admissionRecordRepository.save(admissionRecordEntity1);
                })).orElse(null);
    }
}
