package clinicapp.dbrepository;

import clinicapp.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Long> {

    Card findByFirstName(String firstName);

    Card findByLastName(String lastName);

    Card findById(long id);
}
