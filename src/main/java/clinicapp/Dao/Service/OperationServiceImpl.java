package clinicapp.Dao.Service;

import clinicapp.Dao.OperationDAO;
import clinicspdata.entity.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationDAO operationDAO;

    @Transactional
    public void create(Operation operation) {
        operationDAO.create(operation);
    }

    @Override
    public int getById() {
        return operationDAO.getById();
    }

    @Transactional
    public String getByDate() {
        return operationDAO.getByDate();
    }

    @Transactional
    public List<Operation> getAll() {
        return operationDAO.getAll();
    }

    @Transactional
    public void update(Operation operation) {
        operationDAO.update(operation);
    }

    @Transactional
    public void delete(long id) {
        operationDAO.delete(id);
    }
}
