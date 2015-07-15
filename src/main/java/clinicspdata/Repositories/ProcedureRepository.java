package clinicspdata.repositories;

import clinicspdata.entity.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Oleg Romanenchuk
 * Procedure repository
 */
public interface ProcedureRepository extends JpaRepository<Procedure, Long> {

    @Query("select p from Procedure p where p.id =:id")
    Procedure findById(@Param("id")Long id);

    @Query("select p from Procedure p where p.date =:date")
    Procedure findByDate(@Param("date")String date);
}
