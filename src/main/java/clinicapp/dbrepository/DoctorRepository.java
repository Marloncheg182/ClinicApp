package clinicapp.dbrepository;

import clinicapp.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

   
    Doctor findByLastName(String lastName);

    Doctor findByFirstName(String firstName);

    Doctor findByPosition(String position);

    Doctor findByRating(String rating);


}
