package clinicapp.service;

import clinicapp.entity.Clinic;

import java.util.List;

public interface ClinicService {

    // Create
    Clinic addClinic(Clinic clinic);
    // Read
    Clinic getByName(String name);
    // Read all
    List<Clinic> getAll();
    // Update
    Clinic editClinic(Clinic clinic);
    // Delete
    void delete(long id);
}
