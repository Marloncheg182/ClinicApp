package clinicapp.dbrepository;

import clinicapp.entity.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedureRepository extends JpaRepository<Procedure, Long> {
    Procedure findById(long id);

    Procedure findByDate(String date);
}
