package clinicspdata.repositories;

import clinicapp.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Oleg Romanenchuk
 * Operation repository
 */
public interface OperationRepository extends JpaRepository<Operation, Long> {

    @Query("select o from Operation o where o.id =:id")
    Operation findById(@Param("id")Long id);

    @Query("select o from Operation o where o.date =:date")
    Operation findByDate(@Param("date")String date);

    @Query("select o from Operation o where o.type=:type")
    Operation findByType(@Param("type")String type);
}
