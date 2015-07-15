package clinicapp.Dao.Service;


import clinicspdata.entity.Operation;

import java.util.List;

public interface OperationService {
    // create an object data
    void create(Operation operation);

    // get by id
    int getById();

    // get by date
    String getByDate();

    // get all
    List<Operation> getAll();

    // update
    void update(Operation operation);

    // delete by id
    void delete(long id);
}