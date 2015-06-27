package clinicapp.Dao;


import clinicapp.entity.Nurse;

import java.util.List;

public interface NurseDAO {
    // Create an object data
    void create(Nurse nurse);

    // get by first name
    String getByFirstName();

    // get by last name
    String getByLastName();

    // get by position
    String getByPosition();

    // get all
    List<Nurse> getAll();

    // update data
    void update(Nurse nurse);

    // delete by id
    void delete(Integer id);
}
