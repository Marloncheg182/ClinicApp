package clinicapp.Dao.impl;

import clinicapp.Dao.ClinicDAO;
import clinicspdata.entity.Clinic;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ClinicDaoImpl implements ClinicDAO {

    public static final Logger LOGGER = Logger.getLogger(ClinicDaoImpl.class);

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
        else LOGGER.error("Nothing to delete");
    }
}
