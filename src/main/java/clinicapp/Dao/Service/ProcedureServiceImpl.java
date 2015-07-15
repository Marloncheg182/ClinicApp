package clinicapp.Dao.Service;

import clinicapp.Dao.ProcedureDAO;
import clinicspdata.entity.Procedure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProcedureServiceImpl implements ProcedureService {

    @Autowired
    private ProcedureDAO procedureDAO;

    @Transactional
    public void create(Procedure procedure) {
        procedureDAO.create(procedure);
    }

    @Transactional
    public int getById() {
        return procedureDAO.getById();
    }

    @Transactional
    public String getByDate() {
        return procedureDAO.getByDate();
    }

    @Transactional
    public List<Procedure> getAll() {
        return procedureDAO.getAll();
    }

    @Transactional
    public void update(Procedure procedure) {
        procedureDAO.update(procedure);
    }

    @Transactional
    public void delete(Integer id) {
        procedureDAO.delete(id);
    }
}
