package clinicapp.service;

import clinicapp.entity.Doctor;

import java.util.List;

public interface DoctorService {

    // Create table
    Doctor addDoctor(Doctor doctor);
    // Read by first name
    Doctor getByFirstName(String firstName);
    // Read by last name
    Doctor getByLastName(String lastName);
    // Read all
    List<Doctor> getAll();
    // Read by position
    Doctor getByPosition(String position);
    // Read by rating
    Doctor getByRating(String rating);
    // Update
    Doctor editDoctor(Doctor doctor);
    // Delete by id
    void delete(long id);
}
