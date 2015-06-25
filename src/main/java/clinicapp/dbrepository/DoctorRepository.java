package clinicapp.dbrepository;

import clinicapp.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query("select d from Doctor d where d.lastName = :lastName")
    Doctor findByLastName(@Param("lastname") String lastName);

    @Query("select d from Doctor d where d.firstName = :firstName")
    Doctor findByFirstName(@Param("firstname") String firstName);

    @Query("select d from Doctor d where d.position = :position")
    Doctor findByPosition(@Param("position") String position);

    @Query("select d from Doctor d where d.rating = :rating")
    Doctor findByRating(@Param("rating") String rating);


}
