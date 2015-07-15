package clinicspdata.repositories;

import clinicspdata.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Oleg Romanenchuk
 * Insurance Repository
 */
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

    @Query("select i from Insurance i where i.id =:id")
    Insurance findById(@Param("id") Long id);
}
