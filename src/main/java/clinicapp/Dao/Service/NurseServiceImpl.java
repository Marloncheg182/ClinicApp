package clinicapp.Dao.Service;

import clinicapp.Dao.NurseDAO;
import clinicspdata.entity.Nurse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NurseServiceImpl implements NurseService {

    @Autowired
    private NurseDAO nurseDAO;

    @Transactional
    public void create(Nurse nurse) {
        nurseDAO.create(nurse);
    }

    @Transactional
    public String getByFirstName() {
        return nurseDAO.getByFirstName();
    }

    @Transactional
    public String getByLastName() {
        return nurseDAO.getByLastName();
    }

    @Transactional
    public String getByPosition() {
        return nurseDAO.getByPosition();
    }

    @Transactional
    public List<Nurse> getAll() {
        return nurseDAO.getAll();
    }

    @Transactional
    public void update(Nurse nurse) {
        nurseDAO.update(nurse);
    }

    @Transactional
    public void delete(Integer id) {
        nurseDAO.delete(id);
    }
}
