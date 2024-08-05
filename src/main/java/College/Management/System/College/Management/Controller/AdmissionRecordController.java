package College.Management.System.College.Management.Controller;

import College.Management.System.College.Management.Entity.AdmissionRecordEntity;
import College.Management.System.College.Management.Service.AdmissionRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "admissionRecord")
public class AdmissionRecordController {

    private final AdmissionRecordService admissionRecordService;

    public AdmissionRecordController(AdmissionRecordService admissionRecordService) {
        this.admissionRecordService = admissionRecordService;
    }

    @PostMapping
    public AdmissionRecordEntity createNewAdmissionRecord(@RequestBody AdmissionRecordEntity admissionRecordEntity){
        return admissionRecordService.createNewAdmissionRecord(admissionRecordEntity);
    }

    @GetMapping(path = "/{admissionRecordId}")
    public Optional<AdmissionRecordEntity> getAdmissionRecordById(@PathVariable(name = "admissionRecordId") Long id){
        return admissionRecordService.getAdmissionRecordById(id);
    }

    @PutMapping(path = "/{admissionRecordId}/student/{studentId}")
    public AdmissionRecordEntity admissionRecord(@PathVariable Long admissionRecordId,
                                                 @PathVariable Long studentId){
        return admissionRecordService.admissionRecord(admissionRecordId,studentId);
    }

}
