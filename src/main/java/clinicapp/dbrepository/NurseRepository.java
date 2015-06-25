package clinicapp.dbrepository;

import clinicapp.entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NurseRepository extends JpaRepository<Nurse, Long> {

    @Query("select n from Nurse n where n.lastName = :lastName")
    Nurse findByLastName(@Param("lastname") String lastName);

    @Query("select n from Nurse n where n.firstName = :firstName")
    Nurse findByFirstName(@Param("firstname") String firstName);

    @Query("select n from Nurse n where n.position = :position")
    Nurse findByPosition(@Param("position") String position);

}
