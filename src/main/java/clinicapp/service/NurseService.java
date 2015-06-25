package clinicapp.service;


import clinicapp.entity.Nurse;

import java.util.List;

public interface NurseService {

    // Create table
    Nurse addNurse(Nurse nurse);
    // Read by first name
    Nurse getByFirstName(String firstName);
    // Read by last name
    Nurse getByLastName(String lastName);
    // Read by position
    Nurse getByPosition(String position);
    // Read all
    List<Nurse> getAll();
    // Update
    Nurse editNurse(Nurse nurse);
    // Delete by id
    void delete(long id);
}

