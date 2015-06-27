package clinicapp.Dao.Service;


import clinicapp.Dao.ClinicDAO;
import clinicapp.entity.Clinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClinicServiceImpl implements ClinicService{

    @Autowired
    private ClinicDAO clinicDAO;

    @Transactional
    public void create(Clinic clinic) {
        clinicDAO.create(clinic);
    }

    @Transactional
    public String getName() {
        return clinicDAO.getName();
    }

    @Override
    public List<Clinic> getAll() {
        return clinicDAO.getAll();
    }

    @Override
    public void update(Clinic clinic) {
         clinicDAO.update(clinic);
    }

    @Override
    public void delete(Integer id) {
         clinicDAO.delete(id);
    }
}
