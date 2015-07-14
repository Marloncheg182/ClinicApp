package clinicspdata.services;

import clinicapp.entity.Card;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Card Service
 */
public interface CardService {

    Card create(Card card);

    Card getById(Long id);

    Card getByLastName(String lastName);

    Card getByBirthDate(String birthDate);

    List<Card> getAll();

    Card update(Card card);

    void delete(Long id);

}
