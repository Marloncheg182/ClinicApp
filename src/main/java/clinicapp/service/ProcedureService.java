package clinicapp.service;

import clinicapp.entity.Procedure;

import java.util.List;

/**
 * Created by Dell on 6/25/2015.
 */
public interface ProcedureService {
    // Create table
    Procedure addProcedure(Procedure Procedure);

    // Read by id
    Procedure getById(long id);

    // Read by Date
    Procedure getByDate(String date);

    // Read all
    List<Procedure> getAll();

    // Update
    Procedure editProcedure(Procedure procedure);

    // Delete by id
    void delete(long id);
}
