package clinicapp.dbrepository;

import clinicapp.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {

    Operation findById(long id);

    Operation findByDate(String date);


}
