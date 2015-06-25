package clinicapp.service;


import clinicapp.entity.Analysis;

import java.util.List;

public interface AnalysisService {
    // Create table
    Analysis addAnalysis(Analysis analysis);

    // Read by id
    Analysis getById(long id);

    // Read by Date
    Analysis getByDate(String date);

    // Read all
    List<Analysis> getAll();

    // Update
    Analysis editAnalysis(Analysis analysis);

    // Delete by id
    void delete(long id);

}
