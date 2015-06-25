package clinicapp.service;


import clinicapp.entity.Operation;

import java.util.List;

public interface OperationService {
    // Create table
    Operation addOperation(Operation operation);

    // Read by id
    Operation getById(long id);

    // Read by Date
    Operation getByDate(String date);

    // Read all
    List<Operation> getAll();

    // Update
    Operation editOperation(Operation operation);

    // Delete by id
    void delete(long id);

}
