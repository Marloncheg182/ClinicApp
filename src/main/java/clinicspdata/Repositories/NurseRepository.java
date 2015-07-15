package clinicspdata.repositories;

import clinicspdata.entity.Nurse;
import clinicspdata.entity.nurses.NursePosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Oleg Romanenchuk
 * Nurse Repository
 */
public interface NurseRepository extends JpaRepository<Nurse, Long> {

    @Query("select n from Nurse n where n.firstName = :first_name")
    Nurse findByFirstName(@Param("first_name") String firstName);

    @Query("select n from Nurse n where n.lastName = :last_name")
    Nurse findByLastName(@Param("last_name")String lastName);

    @Query("select n from Nurse n where n.age = :age")
    Nurse findByAge(@Param("age")Integer age);

    @Query("select n from Nurse n where n.position = :position")
    Nurse findByPosition(@Param("position")NursePosition position);
}
