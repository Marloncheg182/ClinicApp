package clinicspdata.repositories;

import clinicapp.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Oleg Romanenchuk
 * Card Repository
 */
public interface CardRepository extends JpaRepository<Card, Long> {

    @Query("select c from Card c where c.id = :id")
    Card findById(@Param("id")Long id);

    @Query("select c from Card c where c.lastName =:last_name")
    Card findByName(@Param("last_name")String lastName);

    @Query("select c from Card c where c.birthDate =:date")
    Card findByBirthDate(@Param("date")String birthDate);
}
