package clinicapp.Dao.Service;

import clinicapp.Dao.PatientDAO;
import clinicspdata.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDAO patientDAO;

    @Transactional
    public void create(Patient patient) {
        patientDAO.create(patient);
    }

    @Transactional
    public String getByFirstName() {
        return patientDAO.getByFirstName();
    }

    @Transactional
    public String getByLastName() {
        return patientDAO.getByLastName();
    }

    @Transactional
    public String getByState() {
        return patientDAO.getByState();
    }

    @Transactional
    public List<Patient> getAll() {
        return patientDAO.getAll();
    }

    @Override
    public void update(Patient patient) {
        patientDAO.update(patient);
    }

    @Override
    public void delete(Integer id) {
        patientDAO.delete(id);
    }
}
