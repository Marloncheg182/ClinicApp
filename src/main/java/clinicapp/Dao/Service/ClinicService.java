package clinicapp.Dao.Service;


import clinicapp.entity.Clinic;

import java.util.List;

public interface ClinicService {

    // Create a clinic object data
    void create(Clinic clinic);

    // get by name
    String getName();

    // get all data
    List<Clinic> getAll();

    // update Clinic data
    void update (Clinic clinic);

    // delete Clinic by id
    void delete(Integer id);
}
