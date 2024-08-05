package College.Management.System.College.Management.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "student")
    @JsonIgnore
    private AdmissionRecordEntity admissionRecord;

    @ManyToMany(mappedBy = "student")
    private Set<ProfessorEntity> professor;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "subject_student_mapping",
    joinColumns = @JoinColumn(name = "studentId"),
    inverseJoinColumns = @JoinColumn(name = "subjectId"))
    private Set<SubjectEntity> subject;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
