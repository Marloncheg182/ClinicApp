package clinicapp.Dao.impl;

import clinicapp.Dao.DoctorDAO;
import clinicspdata.entity.Doctor;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorDaoImpl implements DoctorDAO {

    public static final Logger LOGGER = Logger.getLogger(DoctorDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Doctor doctor) {
        sessionFactory.getCurrentSession().save(doctor);
    }

    @Override
    public String getByFirstName() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM doctor WHERE doctor.first_name = :first_name").getQueryString();
    }

    @Override
    public String getByLastName() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM doctor WHERE doctor.last_name = :last_name").getQueryString();
    }

    @Override
    public String getByPosition() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM doctor WHERE doctor.position = :position").getQueryString();
    }

    @Override
    public String getByRating() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM  doctor WHERE doctor.rating = :rating").getQueryString();
    }

    @Override
    public List<Doctor> getAll() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM doctor").list();
    }

    @Override
    public void update(Doctor doctor) {
        sessionFactory.getCurrentSession().save(doctor);
    }

    @Override
    public void delete(Integer id) {
        Doctor doctor = (Doctor) sessionFactory.getCurrentSession().load(
                Doctor.class, id);
        if (null != doctor) {
            sessionFactory.getCurrentSession().delete(doctor);
        }

        else LOGGER.error("Nothing to delete");
    }
}

