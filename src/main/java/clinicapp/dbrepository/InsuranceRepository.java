package clinicapp.dbrepository;

import clinicapp.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dell on 6/24/2015.
 */
public interface InsuranceRepository extends JpaRepository<Insurance,Long> {
}
