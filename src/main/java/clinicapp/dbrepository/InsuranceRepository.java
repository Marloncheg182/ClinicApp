package clinicapp.dbrepository;

import clinicapp.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Dell on 6/24/2015.
 */
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

    @Query("select i from Insurance i where i.bankaccount = :bankaccount")
    Insurance findByBankAccount(@Param("bankaccount") String bankaccount);
}
