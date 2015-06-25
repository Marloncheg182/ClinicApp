package clinicapp.service;


import clinicapp.entity.Patient;

import java.util.List;

public interface PatientService {
    // Create table
    Patient addPatient(Patient patient);
    // Read by first name
    Patient getByFirstName(String firstName);
    // Read by last name
    Patient getByLastName(String lastName);
    // Read by state
    Patient getByState(String state);
    // Read all
    List<Patient> getAll();
    // Update
    Patient editPatient(Patient patient);
    // Delete by id
    void delete(long id);
}
