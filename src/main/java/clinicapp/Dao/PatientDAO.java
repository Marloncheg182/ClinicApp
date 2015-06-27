package clinicapp.Dao;


import clinicapp.entity.Patient;

import java.util.List;

public interface PatientDAO {

    // Create an object data
    void create(Patient patient);

    // get by first name
    String getByFirstName();

    // get by last name
    String getByLastName();

    // get by state
    String getByState();

    // get all
    List<Patient> getAll();

    // update data
    void update(Patient patient);

    // delete by id
    void delete(Integer id);
}
