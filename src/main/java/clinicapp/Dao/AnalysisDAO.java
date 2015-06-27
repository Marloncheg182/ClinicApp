package clinicapp.Dao;


import clinicapp.entity.Analysis;

import java.util.List;

public interface AnalysisDAO {
    // Create an object data
    void create(Analysis analysis);

    // get by id
    int getById();

    // get by date
    String getByDate();

    // get all data
    List<Analysis> getAll();

    // update data
    void update(Analysis analysis);

    // delete by id
    void delete(Integer id);
}
