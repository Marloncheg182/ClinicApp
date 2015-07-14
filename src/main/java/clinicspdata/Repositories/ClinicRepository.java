package clinicspdata.repositories;

import clinicapp.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



/**
 * @author Oleg Romanenchuk
 * Clinic Repository
 */
public interface ClinicRepository extends JpaRepository<Clinic, Long> {

    @Query("select c from Clinic c where c.name =:name")
    Clinic findByName(@Param("name")String name);

    @Query("select c from Clinic c where c.id =:id")
    Clinic findById(@Param("id")Long id);
}
