package clinicapp.Dao;


import clinicapp.entity.Operation;

import java.util.List;

public interface OperationDAO {
    // create an object data
    void create(Operation operation);

    // get by id
    int getById(long id);

    // get by date
    String getByDate();

    // get all
    List<Operation> getAll();

    // update
    void update(Operation operation);

    // delete by id
    void delete(long id);
}
