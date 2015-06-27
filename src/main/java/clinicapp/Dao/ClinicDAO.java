package clinicapp.Dao;


import clinicapp.entity.Clinic;

import java.util.List;

public interface ClinicDAO {

    // Create a clinic object data
    public void create(Clinic clinic);

    // get by name
    public String getName();

    // get all data
    public List<Clinic> getAll();

    // update Clinic data
    public void update (Clinic clinic);

    // delete Clinic by id
    public void delete(Integer id);
}
