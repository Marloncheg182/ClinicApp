package clinicapp.Dao.Service;

import clinicspdata.entity.Procedure;

import java.util.List;

public interface ProcedureService {
    // Create an object data
    void create(Procedure procedure);

    // get by id
    int getById();

    // get by date
    String getByDate();

    // get all data
    List<Procedure> getAll();

    // update data
    void update(Procedure procedure);

    // delete by id
    void delete(Integer id);
}

