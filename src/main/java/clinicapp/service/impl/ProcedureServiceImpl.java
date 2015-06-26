package clinicapp.service.impl;

import clinicapp.dbrepository.ProcedureRepository;
import clinicapp.entity.Procedure;
import clinicapp.service.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProcedureServiceImpl implements ProcedureService {

    @Autowired
    private ProcedureRepository procedureRepository;

    @Override
    public Procedure addProcedure(Procedure Procedure) {
        Procedure saveProcedure = procedureRepository.saveAndFlush(Procedure);
        return saveProcedure;
    }

    @Override
    public Procedure getById(long id) {
        return procedureRepository.findById(id);
    }

    @Override
    public Procedure getByDate(String date) {
        return procedureRepository.findByDate(date);
    }

    @Override
    public List<Procedure> getAll() {
        return procedureRepository.findAll();
    }

    @Override
    public Procedure editProcedure(Procedure procedure) {
        return procedureRepository.saveAndFlush(procedure);
    }

    @Override
    public void delete(long id) {
        procedureRepository.delete(id);
    }
}
