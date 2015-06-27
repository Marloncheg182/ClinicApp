package clinicapp.Dao;


import clinicapp.entity.Card;

import java.util.List;

public interface CardDAO {
    // Create
    void create(Card card);

    // Read by first name
    String getByFirstName();

    // get by last name
    String getByLastName();

    // get by id
    int getById();

    // get all data
    List<Card> getAll();

    // update data
    void update(Card card);

    // delete by id
    void delete(Integer id);
}
