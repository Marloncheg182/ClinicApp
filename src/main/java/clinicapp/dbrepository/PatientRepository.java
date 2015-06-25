package clinicapp.dbrepository;

import clinicapp.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("select p from Patient p where p.lastname = :lastname")
    Patient findByLastName(@Param("last_name")String lastName);

    @Query("select p from Patient p where p.lfirstname = :firstname")
    Patient findByFirstName(@Param("lfirstname")String firstName);

    @Query("select p from Patient p where p.state = :state")
    Patient findByState(@Param("state")String state);
}
