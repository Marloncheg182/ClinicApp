package clinicspdata.services;

import clinicapp.entity.Analysis;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Service interface
 */
public interface AnalysisService {

    Analysis create(Analysis analysis);

    Analysis getById(Long id);

    Analysis getByDate(String date);

    List<Analysis> getAll();

    Analysis update(Analysis analysis);

    void delete(Long id);

}
