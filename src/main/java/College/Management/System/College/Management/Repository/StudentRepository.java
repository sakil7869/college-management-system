package College.Management.System.College.Management.Repository;

import College.Management.System.College.Management.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity , Long> {
}
