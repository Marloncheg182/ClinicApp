package clinicapp.service;


import clinicapp.entity.Card;

import java.util.List;

public interface CardService {

    // Create
    Card addCard(Card card);

    // Read by first name
    Card getByFirstName(String firstName);

    // Read by last name
    Card getByLastName(String lastName);

    // Read by id
    Card getById(long id);

    // Read all
    List<Card> getAll();

    // Update
    Card editCard(Card card);

    // Delete by id
    void delete(long id);
}
