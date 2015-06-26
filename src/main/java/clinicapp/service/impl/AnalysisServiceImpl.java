package clinicapp.service.impl;

import clinicapp.dbrepository.AnalysisRepository;
import clinicapp.entity.Analysis;
import clinicapp.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AnalysisServiceImpl implements AnalysisService {

    @Autowired
    private AnalysisRepository analysisRepository;

    @Override
    public Analysis addAnalysis(Analysis analysis) {
        Analysis saveAnalysis = analysisRepository.saveAndFlush(analysis);
        return saveAnalysis;
    }

    @Override
    public Analysis getById(long id) {
        return analysisRepository.findById(id);
    }

    @Override
    public Analysis getByDate(String date) {
        return analysisRepository.findByDate(date);
    }

    @Override
    public List<Analysis> getAll() {
        return analysisRepository.findAll();
    }

    @Override
    public Analysis editAnalysis(Analysis analysis) {
        return analysisRepository.saveAndFlush(analysis);
    }

    @Override
    public void delete(long id) {
        analysisRepository.delete(id);
    }
}
