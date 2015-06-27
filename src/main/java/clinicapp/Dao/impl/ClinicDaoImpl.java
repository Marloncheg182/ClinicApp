package clinicapp.Dao.impl;

import clinicapp.Dao.ClinicDAO;
import clinicapp.entity.Clinic;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClinicDaoImpl implements ClinicDAO {

    private SessionFactory sessionFactory;

    @Override
    public void create(Clinic clinic) {
        sessionFactory.getCurrentSession().save(clinic);
    }

    @Override
    public String getName() {
        return sessionFactory.getCurrentSession().createQuery("select name from Clinic where name = :name").getQueryString();
    }

    @Override
    public List<Clinic> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Clinic").list();
    }

    @Override
    public void update(Clinic clinic) {
        sessionFactory.getCurrentSession().save(clinic);
    }

    @Override
    public void delete(Integer id) {
        Clinic clinic = (Clinic)sessionFactory.getCurrentSession().load(
                Clinic.class, id);
        if (null != clinic){
            sessionFactory.getCurrentSession().delete(clinic);
        }
    }
}
