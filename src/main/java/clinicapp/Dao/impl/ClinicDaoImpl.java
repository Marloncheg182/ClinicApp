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
    public String getName(String name) {
        return sessionFactory.getCurrentSession().createQuery("select * from Clinic where");
    }

    @Override
    public List<Clinic> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Clinic").list();
    }

    @Override
    public Clinic update(Clinic clinic) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
