package clinicapp.Dao.Service;


import clinicapp.Dao.DoctorDAO;
import clinicspdata.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorDAO doctorDAO;

    @Override
    public void create(Doctor doctor) {
        doctorDAO.create(doctor);
    }

    @Override
    public String getByFirstName() {
        return doctorDAO.getByFirstName();
    }

    @Override
    public String getByLastName() {
        return doctorDAO.getByLastName();
    }

    @Override
    public String getByPosition() {
        return doctorDAO.getByPosition();
    }

    @Override
    public String getByRating() {
        return doctorDAO.getByRating();
    }

    @Override
    public List getAll() {
        return doctorDAO.getAll();
    }

    @Override
    public void update(Doctor doctor) {
        doctorDAO.update(doctor);
    }

    @Override
    public void delete(Integer id) {
        doctorDAO.delete(id);
    }
}
