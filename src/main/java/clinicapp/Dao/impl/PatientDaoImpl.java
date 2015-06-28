package clinicapp.Dao.impl;

import clinicapp.Dao.PatientDAO;
import clinicapp.entity.Patient;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDaoImpl implements PatientDAO {

    public static final Logger LOGGER = Logger.getLogger(PatientDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Patient patient) {
        sessionFactory.getCurrentSession().save(patient);
    }

    @Override
    public String getByFirstName() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM patient WHERE patient.first_name = :first_name").getQueryString();
    }

    @Override
    public String getByLastName() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM patient WHERE patient.last_name = :last_name").getQueryString();
    }

    @Override
    public String getByState() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM patient WHERE patient.state = :state").getQueryString();
    }

    @Override
    public List<Patient> getAll() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM nurse").list();
    }

    @Override
    public void update(Patient patient) {
        sessionFactory.getCurrentSession().save(patient);
    }

    @Override
    public void delete(Integer id) {
        Patient patient = (Patient) sessionFactory.getCurrentSession().load(
                Patient.class, id);
        if (null != patient) {
            sessionFactory.getCurrentSession().delete(patient);
        }

        else LOGGER.error("Nothing to delete");
    }
}
