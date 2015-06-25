package clinicapp.dbrepository;

import clinicapp.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OperationRepository extends JpaRepository<Operation, Long> {

    @Query("select o from Operation o where o.id = :id")
    Operation findById(@Param("id") long id);

    @Query("select o from Operation o where o.date = :date")
    Operation findByDate(@Param("date") String date);


}
