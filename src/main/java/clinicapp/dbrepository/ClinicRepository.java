package clinicapp.dbrepository;

import clinicapp.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClinicRepository extends JpaRepository<Clinic, Long> {
}
