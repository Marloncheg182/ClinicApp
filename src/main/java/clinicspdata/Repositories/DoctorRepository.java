package clinicspdata.repositories;

import clinicapp.entity.Doctor;
import clinicapp.entity.doctors.DoctorPosition;
import clinicapp.entity.doctors.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Oleg Romanenchuk
 * Doctor Repository
 */
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query("select d from Doctor d where d.firstName =:first_name")
    Doctor findByFirstName(@Param("firs_name")String firstName);

    @Query("select d from Doctor d where d.lastName =:last_name")
    Doctor findByLastName(@Param("last_name")String lastName);

    @Query("select d from Doctor d where d.age =: age")
    Doctor findByAge(@Param("age")Integer age);

    @Query("select d from Doctor d where d.position =:position")
    Doctor findByPosition(@Param("position")DoctorPosition position);

    @Query("select d from Doctor d where d.rating =:rating")
    Doctor findByRating(@Param("rating")Rating rating);


}
