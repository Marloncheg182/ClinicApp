package clinicapp.dbrepository;

import clinicapp.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByLastName(String lastName);

    Patient findByFirstName(String firstName);

    Patient findByState(String state);
}
