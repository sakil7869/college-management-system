package College.Management.System.College.Management.Repository;

import College.Management.System.College.Management.Entity.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity , Long> {
}
