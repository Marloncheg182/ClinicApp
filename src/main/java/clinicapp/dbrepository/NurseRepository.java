package clinicapp.dbrepository;

import clinicapp.entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NurseRepository extends JpaRepository<Nurse, Long> {

    Nurse findByLastName(String lastName);

    Nurse findByFirstName(String firstName);

    Nurse findByPosition(String position);

}
