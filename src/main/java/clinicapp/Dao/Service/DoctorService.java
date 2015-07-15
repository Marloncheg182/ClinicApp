package clinicapp.Dao.Service;


import clinicspdata.entity.Doctor;

import java.util.List;

public interface DoctorService {
    // Create a clinic object data
    void create(Doctor doctor);

    // get by first name
    String getByFirstName();

    // get by last name
    String getByLastName();

    // get by position
    String getByPosition();

    // get by rating
    String getByRating();

    // get all
    List getAll();

    // update Clinic data
    void update(Doctor doctor);

    // delete by id
    void delete(Integer id);
}
