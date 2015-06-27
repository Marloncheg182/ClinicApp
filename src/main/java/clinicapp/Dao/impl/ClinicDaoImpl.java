package clinicapp.Dao.impl;

import clinicapp.Dao.ClinicDAO;
import clinicapp.entity.Clinic;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ClinicDaoImpl implements ClinicDAO {

    @Autowired
    private SessionFactory sessionFactory;


    public void create(Clinic clinic) {
        sessionFactory.getCurrentSession().save(clinic);
    }


    public String getName() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM clinic WHERE clinic.name = :name").getQueryString();
    }

    @SuppressWarnings("unchecked")
    public List<Clinic> getAll() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM clinic").list();
    }


    public void update(Clinic clinic) {
        sessionFactory.getCurrentSession().save(clinic);
    }


    public void delete(Integer id) {
        Clinic clinic = (Clinic) sessionFactory.getCurrentSession().load(
                Clinic.class, id);
        if (null != clinic) {
            sessionFactory.getCurrentSession().delete(clinic);
        }
    }
}
