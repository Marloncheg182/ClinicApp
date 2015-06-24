package clinicapp.dbrepository;

import clinicapp.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query("select d from Doctor d where d.first_name=:first_name or d.last_name = :last_name")
    Doctor findByLastnameOrFirstname(@Param("last_name")String lastName, @Param("first_name")String firstName);
}
