package clinicapp.service;

import clinicapp.entity.Clinic;

import java.util.List;

public interface ClinicService {

    Clinic addClinic(Clinic clinic);

    void delete(long id);

    Clinic getByName(String name);

    Clinic editClinic(Clinic clinic);

    List<Clinic> getAll();
}
