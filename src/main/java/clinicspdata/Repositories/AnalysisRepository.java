package clinicspdata.repositories;

import clinicspdata.entity.Analysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Oleg Romanenchuk
 * Analysis reposotory
 */
public interface AnalysisRepository extends JpaRepository<Analysis, Long> {

    @Query("select a from Analysis a where a.id =:id")
    Analysis findById(@Param("id")Long id);

    @Query("select a from Analysis a where a.date =:date")
    Analysis findByDate(@Param("date")String date);


}
