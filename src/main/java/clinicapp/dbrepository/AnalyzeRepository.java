package clinicapp.dbrepository;

import clinicapp.entity.Analyze;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalyzeRepository extends JpaRepository<Analyze,Long> {
}
