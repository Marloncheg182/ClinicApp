package clinicapp.dbrepository;

import clinicapp.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CardRepository extends JpaRepository<Card, Long> {

    @Query("select cd from Card cd where cd.firstname = :firstname")
    Card findByFirstName(@Param("firstname") String firstName);

    @Query("select cd from Card cd where cd.lasttname = :lasttname")
    Card findByLastName(@Param("lastname") String lastName);

    @Query("select cd from Card cd where cd.id = :id")
    Card findById(@Param("id") long id);
}
