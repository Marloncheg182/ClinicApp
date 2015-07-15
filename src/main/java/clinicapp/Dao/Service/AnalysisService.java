package clinicapp.Dao.Service;

import clinicspdata.entity.Analysis;

import java.util.List;

public interface AnalysisService {
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
