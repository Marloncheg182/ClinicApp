package clinicapp.dbrepository;

import clinicapp.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ClinicRepository extends JpaRepository<Clinic, Long> {

    // Using of query for access to base in case, if we want to find a name
    @Query("select c from Clinic c where c.name = :name")
    Clinic findByName(@Param("name")String name);


}
