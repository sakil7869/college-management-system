package College.Management.System.College.Management.Repository;

import College.Management.System.College.Management.Entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity , Long> {
}
