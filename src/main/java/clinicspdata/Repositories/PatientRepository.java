package clinicspdata.repositories;

import clinicspdata.entity.Patient;
import clinicspdata.entity.patients.PatientState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Oleg Romanenchuk
 * Patient repository
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("select p from Patient p where p.firstName =:first_name")
    Patient finByFirstName(@Param("first_name") String firstName);

    @Query("select p from Patient p where p.lastName =:last_name")
    Patient findByLastName(@Param("last_name")String lastName);

    @Query("select p from Patient p where p.age =:age")
    Patient findByAge(@Param("age")Integer age);

    @Query("select p from Patient p where p.state = :state")
    Patient findByStat(@Param("state")PatientState state);


}
