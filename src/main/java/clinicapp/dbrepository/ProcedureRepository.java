package clinicapp.dbrepository;

import clinicapp.entity.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProcedureRepository extends JpaRepository<Procedure, Long> {

    @Query("select pr from Procedure pr where pr.id = :id")
    Procedure findById(@Param("id")long id);

    @Query("select pr from Procedure pr where pr.date = :date")
    Procedure findByDate(@Param("date")String date);
}
