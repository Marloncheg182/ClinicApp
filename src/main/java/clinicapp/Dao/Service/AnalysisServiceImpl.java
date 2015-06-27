package clinicapp.Dao.Service;


import clinicapp.Dao.AnalysisDAO;
import clinicapp.entity.Analysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnalysisServiceImpl implements AnalysisService {

    @Autowired
    private AnalysisDAO analysisDAO;

    @Transactional
    public void create(Analysis analysis) {
        analysisDAO.create(analysis);
    }

    @Transactional
    public int getById() {
        return analysisDAO.getById();
    }

    @Transactional
    public String getByDate() {
        return analysisDAO.getByDate();
    }

    @Transactional
    public List<Analysis> getAll() {
        return analysisDAO.getAll();
    }

    @Transactional
    public void update(Analysis analysis) {
        analysisDAO.update(analysis);
    }

    @Transactional
    public void delete(Integer id) {
        analysisDAO.delete(id);
    }
}
