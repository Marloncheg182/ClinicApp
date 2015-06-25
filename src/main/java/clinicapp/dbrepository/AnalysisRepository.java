package clinicapp.dbrepository;

import clinicapp.entity.Analysis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalysisRepository extends JpaRepository<Analysis,Long> {
    Analysis findById(long id);

    Analysis findByDate(String date);
}
