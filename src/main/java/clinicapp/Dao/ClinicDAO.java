package clinicapp.Dao;


import clinicspdata.entity.Clinic;

import java.util.List;

public interface ClinicDAO {

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
